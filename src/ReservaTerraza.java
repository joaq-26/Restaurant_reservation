/*
  Reserva para la terraza.
  Tambien hereda de Reserva.
 */

public class ReservaTerraza extends Reserva {

    // Constructor
    public ReservaTerraza(String nombreCliente,
                          String fecha,
                          String hora,
                          int numComensales) {

        super(nombreCliente, fecha, hora, numComensales);
    }

    // Tipo de zona
    @Override
    public String getTipoZona() {

        return "TERRAZA";
    }
}