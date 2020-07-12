# Burger King

_El proyecto final se basa en convertir el trabajo practico número 2, a un servidor web, utilizando base de datos, y dos Framework._

## Trabajo Práctico 2 📋

_Desarrolle un sistema para gestionar la información de un restaurante de comidas rápidas, relativa a los pedidos y a los empleados que toman y despachan los pedidos teniendo en cuenta que:_
* Cada pedido está compuesto por un conjunto de ítems. Cada ítem puede, a su vez, estar formados por un conjunto de ingredientes, que pueden ser agregados o quitados.
* Al sistema podrán acceder tres tipos de usuarios: Vendedores (que tomaran pedidos), cocineros (que despacharan los pedidos), y gerentes (que administraran todo y obtendrán los listados de ventas)

### Pre-requisitos 

_Para la compilación y ejecución del proyecto se utilizó las siguientes tecnologías_


* [NetBeans](https://netbeans.org/) - IDE versión 11.3

* [Xampp](https://www.apachefriends.org/index.html) - MySql versión 10.4.6-MariaDB y Apache versión 3.2.4

* [Java](https://www.java.com/es/download/) - Version 8 Update 111

* [Google Chrome](https://www.google.com/intl/es-419/chrome/) - Navegador web


### Instalación 🔧

_Primero: Crear el usuario "userbk" sin contraseña._
_Segundo: Crear la base de datos "dbbk"._
_Tercero: Asignar todos los permisos al usuario creado en el primer punto, para que tenga acceso a la base de datos creada anteriormente._
_Cuarto: Iniciar la aplicación desde el IDE, este proceso creara todas las tablas correspondientes a la BBDD gracias al Framework Hibernate._
_Quinto: Ejecutar la siguiente sentencia sql a fin de tener el sistema funcional.

```
insert into estadopedido value ('1','vendido');
insert into estadopedido value ('2','preparacion');
insert into roles value ('1', 'Gerente');
insert into roles value ('2', 'Vendedor');
insert into roles value ('3', 'Cocinero');
insert into usuarios value ('1', 'ApellidoUsuario', 'legajo', 'NombreUsuario','password','rol');

```
_Tener en cuenta al momento de ejecutar la ultima sentencia, modificar los datos a necesidad del usuario._ 

_Podría ser:_

```
insert into usuarios value ('1', 'Mamoris', '1', 'Federico','1','1');
```

_Sexto: Opcional, si desea generar más datos para un mejor interacción con el sistema se puede ejecutar las consultas del archivo primer uso que se encuentra en la raíz del proyecto._

_Septimo: Ejecutar la aplicación desde "http://localhost:8080/"_

## Construido con 🛠️

_Para dar cumplimiento a los requisitos solicitados se utilizaron las siguientes herramientas para el desarrollo del sistema._

* [Spring](https://spring.io/) - Framework Core - 
_Se utilizaron las siguientes dependencias pertenecientes a Spring:_
    * [Spring Boot](https://docs.spring.io/spring-boot/docs/2.2.8.RELEASE/reference/html/) - Version 2.2.8.BUILD-SNAPSHOT
    * [Spring Data](https://spring.io/projects/spring-data) – Dependeia para persistencia de datos
* [Thymeleaf](https:/www.thymeleaf.org) - Motor de plantillas web
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Hibernate](https://hibernate.org/orm/releases/5.4/) - Framework ORM - Version 5.4.15.Final



## Autor ✒️

**Federico Mamoris** 

