# Restaurant Reservation Management System

Java project developed using Object-Oriented Programming, Swing for the graphical interface, and text file persistence for data storage.

The application simulates a reservation management system for a restaurant, allowing users to create and manage reservations in a simple and organized way.

---

# Overview

The system allows users to:

- Create reservations
- Select indoor or terrace seating
- Automatically calculate reservation deposits
- Cancel reservations
- Mark customers as no-shows
- Display reservations in a table
- Save and load reservations from a text file

Each reservation requires a deposit of **5€ per guest**. If a customer does not attend the reservation, the restaurant keeps the deposit.

---

# Features

- Graphical user interface built with Swing
- Reservation management using ArrayList
- Automatic deposit calculation
- Reservation status management
- File persistence using `.txt` files
- Data loading at application startup

---

# Technologies Used

- Java
- Swing
- Object-Oriented Programming
- ArrayList Collections
- File Handling (`BufferedReader` / `BufferedWriter`)

---

# Object-Oriented Structure

The project is divided into several classes to keep the code organized and modular.

## Main Classes

### `Main`
Starts the application and launches the main window.

### `VentanaPrincipal`
Contains the graphical interface and user interactions.

### `Reserva`
Abstract parent class containing the common reservation data.

### `ReservaInterior`
Represents indoor reservations.

### `ReservaTerraza`
Represents terrace reservations.

### `GestorReservas`
Handles reservation management and file operations.

### `EstadoReserva`
Enum used to manage reservation states:
- CONFIRMADA
- CANCELADA
- NO_PRESENTADO

---

# Implemented Concepts

## Object-Oriented Programming
- Classes and objects
- Constructors
- Methods
- Encapsulation

## Inheritance
The project uses inheritance to avoid duplicated code:

```java id="87pbhq"
public class ReservaInterior extends Reserva
