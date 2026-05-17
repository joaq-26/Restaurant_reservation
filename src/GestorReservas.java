import java.io.*;
import java.util.ArrayList;

/*
  Esta clase se encarga de gestionar todas las reservas.

  Aqui usamos:
  - ArrayList
  - lectura y escritura de ficheros

 */

public class GestorReservas {

    // Lista de reservas
    private ArrayList<Reserva> reservas;

    // Nombre del fichero
    private final String ARCHIVO = "reservas.txt";

    // Constructor
    public GestorReservas() {

        reservas = new ArrayList<>();

        // Cargamos las reservas guardadas
        cargarReservas();
    }

    // Añadir reserva
    public void agregarReserva(Reserva reserva) {

        reservas.add(reserva);
    }

    // Obtener lista
    public ArrayList<Reserva> getReservas() {

        return reservas;
    }

    // Cancelar reserva
    public void cancelarReserva(int indice) {

        reservas.get(indice)
                .setEstado(EstadoReserva.CANCELADA);
    }

    // Cliente no presentado
    public void marcarNoPresentado(int indice) {

        reservas.get(indice)
                .setEstado(EstadoReserva.NO_PRESENTADO);
    }


     // Guardar reservas en el txt.

    public void guardarReservas() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(ARCHIVO));

            // Recorremos las reservas
            for (Reserva r : reservas) {

                // Guardamos cada una
                bw.write(r.toFileString());

                bw.newLine();
            }

            // Cerramos el fichero
            bw.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


     // Leer reservas desde el txt.

    public void cargarReservas() {

        File archivo = new File(ARCHIVO);

        // Si no existe, salimos
        if (!archivo.exists()) {
            return;
        }

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(ARCHIVO));

            String linea;

            // Leemos linea por linea
            while ((linea = br.readLine()) != null) {

                // Separar datos
                String[] datos = linea.split(";");

                String nombre = datos[0];
                String fecha = datos[1];
                String hora = datos[2];

                int comensales =
                        Integer.parseInt(datos[3]);

                String zona = datos[4];

                EstadoReserva estado =
                        EstadoReserva.valueOf(datos[6]);

                Reserva reserva;

                // Crear tipo de reserva
                if (zona.equals("TERRAZA")) {

                    reserva =
                            new ReservaTerraza(
                                    nombre,
                                    fecha,
                                    hora,
                                    comensales);

                } else {

                    reserva =
                            new ReservaInterior(
                                    nombre,
                                    fecha,
                                    hora,
                                    comensales);
                }

                // Recuperar estado
                reserva.setEstado(estado);

                // Añadir al ArrayList
                reservas.add(reserva);
            }

            br.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}