BibliotecaProyecto
Descripción
BibliotecaProyecto es un sistema para la gestión de bibliotecas, que permite realizar operaciones CRUD completas sobre libros, clientes y préstamos. 
Utiliza una base de datos MySQL, asegurando la integridad de los datos mediante claves foráneas. También genera PDFs para reportar préstamos, devoluciones e historial de clientes, y cuenta con búsqueda avanzada y filtros. Además, gestiona un límite de préstamos por cliente.

Tecnologías
Lenguaje: Java
Base de Datos: MySQL
PDFs: iText o Apache PDFBox
Instalación
Clona el repositorio:

bash
Copiar código
git clone https://github.com/Danistan015/Biblioteca.git
Configura la base de datos MySQL:

Crea la base de datos y ajusta las credenciales en el código.
Instala dependencias:

bash
Copiar código
mvn install
Ejecuta el proyecto:

bash
Copiar código
mvn spring-boot:run
Funcionalidades
Gestión de clientes, libros y préstamos.
Búsqueda avanzada y filtrado.
Generación de reportes en PDF.
Control de límite de préstamos por cliente.
