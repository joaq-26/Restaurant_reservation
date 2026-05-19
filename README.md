# Restaurant_reservation

El proyecto consiste en un sistema de reservas para un restaurante desarrollado en Java. La aplicación ha sido creada utilizando programación orientada a objetos y una interfaz gráfica realizada con la librería Swing. El objetivo principal del programa es permitir gestionar reservas de clientes de una forma sencilla, organizada y visual.

El usuario puede crear reservas introduciendo diferentes datos desde la interfaz gráfica, como:

nombre del cliente
fecha de la reserva
hora
número de comensales
tipo de zona, pudiendo elegir entre terraza o interior

Cada vez que se crea una reserva, el sistema calcula automáticamente un depósito de 5 euros por cada comensal. Este depósito se considera una señal para confirmar la reserva. Además, el programa contempla la posibilidad de que el cliente no se presente al restaurante; en ese caso, el restaurante conserva el dinero del depósito.

El proyecto está dividido en varias clases para organizar correctamente el código y aplicar los conceptos vistos en clase. Existe una clase principal llamada Reserva, que almacena la información común de cualquier reserva, como el nombre, la fecha o el número de comensales. A partir de esta clase se crean dos clases hijas:

ReservaInterior
ReservaTerraza

Estas clases heredan los atributos y métodos de la clase padre utilizando herencia, evitando repetir código y haciendo el programa más organizado.

También se utiliza un ArrayList para almacenar todas las reservas creadas durante la ejecución del programa. Gracias a esto, el sistema puede manejar múltiples reservas dinámicamente.

Para la interfaz gráfica se ha utilizado Swing, empleando componentes como:

JFrame
JButton
JTextField
JTable
JComboBox
JOptionPane

La ventana principal permite:

crear nuevas reservas
visualizar todas las reservas en una tabla
cancelar reservas
marcar clientes como “no presentados”
guardar la información

Uno de los aspectos más importantes del proyecto es la persistencia de datos. Todas las reservas se guardan en un fichero de texto plano llamado reservas.txt. Cuando el usuario pulsa el botón de guardar, el programa recorre el ArrayList y escribe cada reserva en una línea del fichero. Posteriormente, cuando el programa vuelve a iniciarse, el sistema lee automáticamente el archivo y recupera todas las reservas guardadas anteriormente.

Además, el programa utiliza un enum llamado EstadoReserva para controlar el estado de cada reserva. Los posibles estados son:

CONFIRMADA
CANCELADA
NO_PRESENTADO

En general, el proyecto permite aplicar muchos de los conceptos trabajados en clase, como:

programación orientada a objetos
clases y objetos
herencia
colecciones
manejo de ficheros
interfaces gráficas
eventos y botones en Swing

El resultado final es una aplicación sencilla pero funcional, que simula un sistema real de gestión de reservas para un restaurante.
