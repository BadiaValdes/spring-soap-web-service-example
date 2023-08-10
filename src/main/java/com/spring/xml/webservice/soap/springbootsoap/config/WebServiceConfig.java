package com.spring.xml.webservice.soap.springbootsoap.config;

import com.spring.xml.webservice.soap.springbootsoap.core.constants.Namespaces;
import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoom;
import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoomRequest;
import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@EnableWs // Enable WS Soap for Spring boot
@Configuration
public class WebServiceConfig {

    /**
     * Create webservice context
     *
     * @param context
     * @return
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet(); // Add message handler
        dispatcherServlet.setApplicationContext(context); // Add the app context
        dispatcherServlet.setTransformWsdlLocations(true); // Set wsdl usage - wee need to create the wsdl bean for each xsd
        return new ServletRegistrationBean(dispatcherServlet, "/ws/*"); // Message handler and url registered
    }

    /**
     * WSD definition for student schema.
     * <p>
     * For each schema we need to create one method like this
     *
     * @param studentsSchema
     * @return
     */
    @Bean(name = "students")
    public DefaultWsdl11Definition studentDefinition(XsdSchema studentsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition(); // Definition
        definition.setPortTypeName("StudentPort"); // Name of the port
        definition.setTargetNamespace(Namespaces.STUDENT_NAMESPACE); // Namespace
        definition.setLocationUri("/ws"); // Previous uri
        definition.setSchema(studentsSchema); // Schema
        return definition;
    }

    /**
     * Creamos la definicion, aunque estamos usando un acercamiento code first. Este no tienen ningun cambio con respecto al otro.
     * @param classRoomSchema
     * @return
     */
    @Bean(name = "classRoom")
    public DefaultWsdl11Definition classRoomDefinition(@Qualifier("classRoomSchema") XsdSchema classRoomSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition(); // Definition
        definition.setPortTypeName("ClassRoomPort"); // Name of the port
        definition.setTargetNamespace(Namespaces.CLASS_ROOM_NAMESPACE); // Namespace
        definition.setLocationUri("/ws"); // Previous uri
        definition.setSchema(classRoomSchema); // Schema
        return definition;
    }

    /**
     * Records one schema from resources
     *
     * @return
     */
    @Bean()
    public XsdSchema studentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/xsd/student-details.xsd"));
    }

    /**
     * Code First WSDL Schema Approach
     *
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    @Bean(name = "classRoomSchema")
    public XsdSchema classRoomSchema() throws JAXBException, IOException {
        // Para poder seguir el acercameinto de code first la instancia debe apuntar al package y utilizar el object factory
        JAXBContext context = JAXBContext.newInstance("com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom", ObjectFactory.class.getClassLoader());

        StringWriter sw = new StringWriter(); // Creamos el string writer.
        class CustomSchemaOutputResolver extends SchemaOutputResolver {
            @Override
            public Result createOutput(String s, String s1) throws IOException {
                StreamResult result = new StreamResult(sw);
                result.setSystemId("classRoom.xsd");
                return result;
            }
        }

        SchemaOutputResolver outputResolver = new CustomSchemaOutputResolver();
        context.generateSchema(outputResolver); // Generamos el esquema
        Resource resource = new ByteArrayResource(sw.toString().getBytes()); // Creamos un recurso a partir de un Array de bytes
        return new SimpleXsdSchema(resource); // Devolvemos el esquema
    }


}
