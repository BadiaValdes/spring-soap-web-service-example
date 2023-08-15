# Spring Boot Soap

--------

### Sobre el proyecto


Este proyecto de Spring Boot explora la forma de trabajar con web services; específicamente SOAP. La idea fue probar dos enfoques de desarrollo de aplicaciones SOAP; la primera era utilizando un acercamiento basado en esquemas (Schemas). En este creamos un esquema como base **Student** y mediante un plugin (```jaxb2-maven-plugin```) convertimos el archivo **XSD** en clases de JAVA.

El segundo enfoque sigue un acercamiento más propio de la **PPO**. La idea es crear primero los objetos que vamos a utilizar y mediante anotaciones de (```jakarta```) le decimos a Spring Broot como debe mapear de objeto a xml.

### XSD a Objeto

Como mencionamos anteriormente este acercamiento se basa en la creación de un archivo en formato XSD y mediante el plugin
(```jaxb2-maven-plugin```) convertimos ese documento en Objeto. Una vez que tengamos el archivo ubicado dentro de nuestra carpeta resource
tenemos que indicarle al plugin el origen (una entrada por cada archivo a convertir) y destino de la conversión:

```xml
<configuration>
    <sources>
        <source>${project.basedir}/src/main/resources/xsd/student-details.xsd</source>
    </sources>
    <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
    <clearOutputDir>false</clearOutputDir>
</configuration>
```

Terminado esto tenemos que ejecutar nuestro proyecto y automáticamente se creará una carpeta en el destino con varios archivos dentro. De ellos, la mayoría son objetos, pero hay dos importantes que hay que tener en cuenta:

- ObjectFactory -> Se encarga de declarar todas las operaciones que se declararon en el XSD.
- package-info -> Posee la información del NAMESPACE del archivo XSD utilizado.

### Objeto a XSD

Este enfoque es un poco más amigable con el programador que no esté acostumbrado a trabajar con archivos XML. El primer paso es crear un objeto y añadir las anotaciones necesarias que brinda
la librería (```jakarta```). Cuando tengamos esto hecho, ya no tenemos que preocuparnos mucho por el XSD ya que el mismo sistema se encargará de mapear de objeto a XML. Esto último se logra gracias a la clase (```JAXBContext```)

### Exponiendo el WSDL
Una de las ventajas que nos brinda el trabajo con web service (SOAP) en spring boot es la capacidad de mostrar el archivo WSDL correspondiente a los XSD que estemos utilizando en el proyecto. Ambos casos están programados en el archivo ```WebServiceConfig```.

El primer enfoque sigue un camino bastante estándar. Esto se debe a que en la configuración solo debemos apuntar al archivo XSD y la magia se realiza por sí misma.

El segundo es un caso aparta ya que no contamos con un archivo XSD (schema) físico. La idea seguida en este caso fue tomar la carpeta del objeto y mediante la clase ``JAXBContext`` generar el XSD (``classRoomSchema`` es el método que se encarga de esto).

En ambos caso el encargado de hacer la magia de conversión de XSD a WSDL es la dependencia ``wsdl4j``.

### Particularidades a tener en cuenta

En cualquier caso hay que tener en cuenta una regla de oro para que el archivo WSDL agrupe las operaciones de forma correcta.

La primera particularidad ya se mencionó en el enfoque de Objeto a XSD pero no es menos cierto que debemos recordarla. Esta consiste en que todas las clases pertenecientes a un mismo XSD, o en este caso mismo objeto, deben ir en la misma carpeta.
Además, poseer dos archivos muy importantes llamados ObjectFactory y package-info.

La segunda particularidad es la forma de nombrar las clases. De forma automática, cuando se genere el XSD, Spring Boot unirá en una misma operación (declaradas en object factory) los métodos con objetos de nombre similares. En nuestro código tenemos ``GetClassRoomRequest`` y ``GetClassRoomResponse``. Esto quiere decir que en el WSDL resultante la operación se va a llamar `GetClassRoom` mientras que la parte del nombre perteneciente a `Request` y `Response`, definen quien es el objeto de entrada y quien el de salida. En este mismo apartado, hay que tener en cuenta que los nombres de todas las funciones que se creen en `Object Factory` deben comenzar con el nombre `create`:

```XML
<wsdl:operation name="GetClassRoom">
    <soap:operation soapAction=""/>
    <wsdl:input name="GetClassRoomRequest">
        <soap:body use="literal"/>
    </wsdl:input>
    <wsdl:output name="GetClassRoomResponse">
        <soap:body use="literal"/>
    </wsdl:output>
</wsdl:operation>
```

### Para probar la app

Primer ejecutamos nuestra aplicación mediante el comando `mvn spring-boot:run`. Y una vez que termine de cargar el servidor, utilizamos el siguiente endpoint:
- localhost:8080/ws

Para comprobar los dos WSDL que tenemos creados en el proyecto, utilizamos los siguientes endpoint:
- localhost:8080/ws/student.wsdl
- localhost:8080/ws/classRoom.wsdl

### Agradecimientos

Si estás viendo esto es porque tuviste dudas de cómo crear un web service mediante Spring Boot. Espero que haya sido de utilidad este pequeño repositorio y si encuentras alguna mejora, no dudes en clonar el repo o enviar las mejoras para integrarlas con el proyecto.

