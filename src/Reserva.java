/*
  Clase padre de las reservas.

  Aqui se guardan los datos comunes:
   - nombre
   - fecha
   - hora
   - personas

  Luego heredaran:
 - ReservaInterior
 - ReservaTerraza

 */

public abstract class Reserva {

    // Datos de la reserva
    protected String nombreCliente;
    protected String fecha;
    protected String hora;
    protected int numComensales;

    // Dinero pagado por adelantado
    protected double deposito;

    // Estado actual
    protected EstadoReserva estado;

    /*
      Constructor:
      Se ejecuta cuando creamos una reserva.
     */

    public Reserva(String nombreCliente,
                   String fecha,
                   String hora,
                   int numComensales) {

        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.numComensales = numComensales;

        // Calculamos el deposito
        this.deposito = calcularDeposito();

        // La reserva empieza confirmada
        this.estado = EstadoReserva.CONFIRMADA;
    }

    /*
      Cada persona paga 5€.
     */
    public double calcularDeposito() {

        return numComensales * 5;
    }


      // Este metodo lo haran las clases hijas.

    public abstract String getTipoZona();


     // Convierte la reserva en texto para guardarla en el fichero.

    public String toFileString() {

        return nombreCliente + ";" +
                fecha + ";" +
                hora + ";" +
                numComensales + ";" +
                getTipoZona() + ";" +
                deposito + ";" +
                estado;
    }

    // GETTERS

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public double getDeposito() {
        return deposito;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    // Cambiar estado
    public void setEstado(EstadoReserva estado) {

        this.estado = estado;
    }
}