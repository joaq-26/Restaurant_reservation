import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/*
  Esta es la ventana principal del programa, aqui es donde el usuario hace todas las reservas.
  Se está utilizando un Swing para la interfaz grafica.
 */

public class VentanaPrincipal extends JFrame {

    // Aqui se gestiona toda la logica de reservas
    private GestorReservas gestor;

    // Tabla donde se ven las reservas
    private JTable tabla;

    // Modelo de la tabla
    private DefaultTableModel modelo;

    // Campos del formulario
    private JTextField txtNombre;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtComensales;

    // Para elegir si es terraza o interior
    private JComboBox<String> comboZona;

     // Constructor de la ventana

    public VentanaPrincipal() {

        gestor = new GestorReservas();

        // Configuracion basica de la ventana
        setTitle("Sistema de Reservas Restaurante");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        /*
          PARTE DE ARRIBA: FORMULARIO
          Aqui se meten los datos de la reserva
         */

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(6, 2));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Fecha:"));
        txtFecha = new JTextField();
        panelFormulario.add(txtFecha);

        panelFormulario.add(new JLabel("Hora:"));
        txtHora = new JTextField();
        panelFormulario.add(txtHora);

        panelFormulario.add(new JLabel("Comensales:"));
        txtComensales = new JTextField();
        panelFormulario.add(txtComensales);

        panelFormulario.add(new JLabel("Zona:"));

        comboZona = new JComboBox<>();
        comboZona.addItem("INTERIOR");
        comboZona.addItem("TERRAZA");

        panelFormulario.add(comboZona);

        JButton btnCrear = new JButton("Crear reserva");
        panelFormulario.add(btnCrear);

        JButton btnGuardar = new JButton("Guardar");
        panelFormulario.add(btnGuardar);

        add(panelFormulario, BorderLayout.NORTH);

        /*
         CENTRO: TABLA
         Aqui se ven todas las reservas
         */

        modelo = new DefaultTableModel();

        modelo.addColumn("Cliente");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Comensales");
        modelo.addColumn("Zona");
        modelo.addColumn("Deposito");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);


         // ABAJO: BOTONES DE ACCION


        JPanel panelBotones = new JPanel();

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnNoPresentado = new JButton("No presentado");

        panelBotones.add(btnCancelar);
        panelBotones.add(btnNoPresentado);

        add(panelBotones, BorderLayout.SOUTH);

        // Cargamos datos al iniciar
        cargarTabla();


         // BOTON CREAR RESERVA

        btnCrear.addActionListener(e -> {

            try {

                String nombre = txtNombre.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();
                int comensales = Integer.parseInt(txtComensales.getText());

                // comprobacion basica
                // Vemos si no pone nombre o fecha o hora lo rellenamos con un null
                if (nombre.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }

                Reserva reserva;

                // segun la zona se crea un tipo u otro
                if (comboZona.getSelectedItem().equals("TERRAZA")) {
                    reserva = new ReservaTerraza(nombre, fecha, hora, comensales);
                } else {
                    reserva = new ReservaInterior(nombre, fecha, hora, comensales);
                }

                gestor.agregarReserva(reserva);

                JOptionPane.showMessageDialog(null,
                        "Reserva creada. Pagas: " + reserva.getDeposito() + " €");

                cargarTabla();
                limpiarCampos();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        });


         // BOTON GUARDAR

        btnGuardar.addActionListener(e -> {
            gestor.guardarReservas();
            JOptionPane.showMessageDialog(null, "Guardado correcto");
        });


         // BOTON CANCELAR

        btnCancelar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                gestor.cancelarReserva(fila);
                cargarTabla();
            }
        });


         //BOTON NO PRESENTADO

        btnNoPresentado.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                gestor.marcarNoPresentado(fila);

                JOptionPane.showMessageDialog(null,
                        "El restaurante se queda el dinero");

                cargarTabla();
            }
        });
    }


     // Actualiza la tabla con los datos

    private void cargarTabla() {

        modelo.setRowCount(0);

        for (Reserva r : gestor.getReservas()) {

            Object[] fila = {
                    r.getNombreCliente(),
                    r.getFecha(),
                    r.getHora(),
                    r.getNumComensales(),
                    r.getTipoZona(),
                    r.getDeposito(),
                    r.getEstado()
            };

            modelo.addRow(fila);
        }
    }


     //Limpia los campos despues de crear una reserva

    private void limpiarCampos() {

        txtNombre.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtComensales.setText("");
    }
}