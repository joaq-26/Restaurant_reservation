/*
  Reserva para el interior del restaurante.

  Hereda de Reserva.
 */

public class ReservaInterior extends Reserva {

    // Constructor
    public ReservaInterior(String nombreCliente,
                           String fecha,
                           String hora,
                           int numComensales) {

        // Llamamos al constructor padre
        super(nombreCliente, fecha, hora, numComensales);
    }

    // Devuelve el tipo de zona
    @Override
    public String getTipoZona() {

        return "INTERIOR";
    }
}