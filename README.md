### Proyecto de microservicios utilizando Eureka y Spring Cloud Gateway
## Java + Spring Boot

Ejercicio básico con 4 microservicios:
* Eureka Server: servidor de nombres que permite el trabajo coordinado, seguro y escalable de los demás microservicios.
* Gateway Server: servidor que permite un ingreso por un puerto único con endpoints personalizados para cada microservicio.
* Usuarios: consume datos ficticios (import.sql) desde una base de datos en memoria H2, implementando diversos servicios REST de los tipos GET, POST y DELETE.
* Nómina: genera una nómina de reajuste de sueldo de empleados, consumiendo los datos desde la api generada por el microservicio Usuarios.
