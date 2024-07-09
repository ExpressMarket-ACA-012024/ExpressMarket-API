# Manual Técnico del Proyecto *ExpressMarket* 
[![uca.png](https://i.postimg.cc/44tV6yRT/uca.png)](https://postimg.cc/HjYrHpLS)


## Índice
- [Manual Técnico del Proyecto *ExpressMarket*](#manual-técnico-del-proyecto-expressmarket)
  - [Índice](#índice)
- [Manual Técnico ](#manual-técnico-)
  - [Aspectos generales](#aspectos-generales)
  - [Modelos utilizados ](#modelos-utilizados-)
  - [Compatibilidad de licencias](#compatibilidad-de-licencias)
  - [**Tipos de error**  ](#tipos-de-error--)
  - [Licencia de código](#licencia-de-código)




# Manual Técnico <a name="Manualtécnico"></a>


- [Manual Técnico del Proyecto *ExpressMarket*](#manual-técnico-del-proyecto-expressmarket)
  - [Índice](#índice)
- [Manual Técnico ](#manual-técnico-)
  - [Aspectos generales](#aspectos-generales)
  - [Modelos utilizados ](#modelos-utilizados-)
  - [Compatibilidad de licencias](#compatibilidad-de-licencias)
  - [**Tipos de error**  ](#tipos-de-error--)
  - [Licencia de código](#licencia-de-código)
 
 ## Aspectos generales
 <a name="Aspectosgenerales"></a>
 
**Objetivos del documento**  <a name="objetivos"></a>
El presente manual técnico tiene como objetivo principal presentar y explicar los distintos aspectos y herramientas que se tomaron en cuenta para el desarrollo del proyecto *ExpressMarket*. Está dirigido tanto al equipo de desarrollo como al usuario final que utilizará la aplicación.


**Descripción general**  <a name="desc"></a>
ExpressMarket es una aplicación web que está diseñada para optimizar la compra en
supermercados, utilizando Sistemas de información geográfica (SIG), la aplicación permite a
los usuarios poder ver y localizar el supermercado más cercano dependiendo de su
ubicación actual.

ExpressMarket está diseñada para transformar la forma en que las personas realizan sus
compras diarias, combinando localización en tiempo real y recomendaciones inteligentes
para ofrecer una solución tecnológica que se adapte a las necesidades del cliente.

La idea de ExpressMarket se originó a partir de “Ticketify”, un proyecto previo enfocado en
la compra y venta de tickets. Sin embargo, decidimos cambiar el enfoque a esta dirección
debido a la alta demanda y la mayor frecuencia de uso de supermercados, consideramos
que esta nueva aplicación web, es más común y más esencial en la vida de las personas,
así ofreciendo una solución tecnológica de mayor impacto y disponibilidad en línea,
adaptándose mejor a las necesidades cotidianas de los clientes.

**Requisitos del Sistema**  <a name="req"></a>


* **Requisitos del sistema operativo**
  - El sistema debe ser compatible con los sistemas operativos Windows o macOS.
  - Se recomienda tener la versión más reciente del sistema operativo instalada para garantizar la compatibilidad y el rendimiento óptimo de la aplicación.
 
* **Requerimientos de Hardware**
  - Procesador de al menos 1 GHz.
  - Memoria RAM de al menos 2 GB (requisito mínimo).
  - Se recomienda tener al menos 8 GB de RAM para un rendimiento óptimo.
  - Espacio de almacenamiento disponible de al menos 2 GB (requisito mínimo).
  - Espacio de almacenamiento disponible de al menos 10 GB para tener rendimiento óptimo.
  - Se recomienda tener al menos 4 GB de espacio en disco duro para un funcionamiento adecuado.
 
* **Requerimientos de Software**
  - Se recomienda tener al menos Windows 7 o posterior para un funcionamiento óptimo.
  - Se recomienda utilizar la versión más reciente de Windows, como Windows 10, para aprovechar las últimas mejoras y actualizaciones de seguridad.
  - Java Development Kit (JDK) 8 o superior.
  - Un servidor de aplicaciones compatible, como
  - Spring Boot Tool Suite 4 requiere Java 8 o una versión superior. Se recomienda tener la última versión estable de Java instalada.
  - Un navegador web actualizado, como Google Chrome, Mozilla Firefox o Microsoft Edge, para acceder a la interfaz gráfica de usuario.

 **Software utilizado** <a name="soft"></a>
 
  Para el desarrollo de la aplicación se utilizo Spring Boot Tool Suite (STS) 4 es un entorno de desarrollo integrado (IDE) basado en Eclipse, diseñado específicamente para el desarrollo de aplicaciones utilizando el framework Spring Boot. Proporciona un conjunto de herramientas y características que facilitan la creación, prueba y despliegue de aplicaciones Spring Boot.


También se utilizaron las siguientes tecnologías:


 - **Java**: Lenguaje de programación utilizado para el desarrollo del sistema de Registro de Notas.


- **Spring Boot**: Framework de desarrollo de aplicaciones Java que proporciona un entorno simplificado para crear aplicaciones web.


- **Spring MVC**: Framework de Spring utilizado para desarrollar la capa de controladores y manejar las solicitudes HTTP.


- **Hibernate**: Framework de mapeo objeto-relacional utilizado para interactuar con la base de datos y realizar operaciones de persistencia.

- **HTML/CSS**: Lenguajes de marcado utilizados para definir la estructura y el estilo de las páginas web.
 
- **Gestor de Base de datos**: PostgreSQL 15v.


- **JavaScript**: Lenguaje de programación utilizado para agregar interactividad y funcionalidad dinámica a las páginas web.

- **ReactJS**: Biblioteca Javascript de código abierto utilizada para crear las interfaces de usuario.

- **Github**: Sistema de control de versiones utilizado para gestionar y colaborar en el desarrollo del proyecto.


## Modelos utilizados <a name="modelosutilizados"></a>


**Patrón de diseño MVVM**  <a name="mvvm"></a>


La arquitectura del sistema se basa en el patrón de diseño Modelo-Vista-Controlador (MVC). Este patrón se utiliza para separar la lógica de negocio, la presentación de datos y la interacción con el usuario en tres componentes principales: el Modelo, la Vista y el Controlador.


La adopción del patrón MVC en nuestro sistema de Registro de Notas nos ha brindado varios beneficios.
Por un lado, nos permite tener una separación clara de responsabilidades, lo cual facilita el mantenimiento y la evolución del sistema. Además, al separar la lógica de negocio de la presentación, se mejora la reutilización de componentes y la estructura del código. Esto nos permite realizar modificaciones y mejoras de forma más eficiente, permitiendonos tener un sistema bien estructurado, modular y fácilmente mantenible. La separación de responsabilidades entre el Modelo, la Vista y el Controlador nos brinda flexibilidad y escalabilidad, permitiendo adaptarnos a cambios futuros y proporcionando una experiencia de usuario mejorada.


## Compatibilidad de licencias


- Compatibilidad de Licencias: https://github.com/ExpressMarket-ACA-012024/ExpressMarket-API/tree/main/Anaisis%20de%20licencia


## **Tipos de error**  <a name="error1"></a>


La herramienta "Projects" de Github nos ha permitido organizar y dar seguimiento a cada error de manera estructurada, ay que cada  issue ha sido creado como una tarjeta en el tablero de proyectos, donde se ha asignado un título descriptivo, se han añadido etiquetas relevantes y se ha asignado un responsable para su solución.
Dicho tablero contiene un registro detallado de todos los problemas y errores encontrados durante el desarrollo y despliegue del aplicativo.


Cada issue ha sido creado con el objetivo de proporcionar una descripción clara y concisa del problema encontrado.


- Link de Github Project: https://github.com/orgs/ExpressMarket-ACA-012024/projects/3
 
 ## Licencia de código  
 <a name="Licencia"></a>
 - GNU General Public
License v3.0: https://github.com/ExpressMarket-ACA-012024/ExpressMarket-API/commit/e9f5c1100f802fe17d6806767b97cd8e3be9c197#diff-c693279643b8cd5d248172d9c22cb7cf4ed163a3c98c8a3f69c2717edd3eacb7
