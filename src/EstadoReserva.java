
  // Posibles estados de una reserva.
  // Por si algun cliente cancela o no se presenta podemos anotarlo

public enum EstadoReserva {

    // Reserva activa
    CONFIRMADA,

    // Reserva cancelada
    CANCELADA,

    // El cliente no vino
    NO_PRESENTADO
}