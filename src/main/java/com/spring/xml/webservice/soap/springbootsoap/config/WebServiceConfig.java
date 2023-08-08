package com.spring.xml.webservice.soap.springbootsoap.config;

import com.spring.xml.webservice.soap.springbootsoap.core.constants.Namespaces;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs // Enable WS Soap for Spring boot
@Configuration
public class WebServiceConfig {

    /**
     * Create webservice context
     * @param context
     * @return
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet (ApplicationContext context){
        MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet(); // Add message handler
        dispatcherServlet.setApplicationContext(context); // Add the app context
        dispatcherServlet.setTransformWsdlLocations(true); // Set wsdl usage - wee need to create the wsdl bean for each xsd
        return new ServletRegistrationBean(dispatcherServlet, "/ws/*"); // Message handler and url registered
    }

    /**
     * WSD definition for student schema.
     *
     * For each schema we need to create one method like this
     *
     * @param studentsSchema
     * @return
     */
    @Bean(name = "students")
    public DefaultWsdl11Definition studentDefinition(XsdSchema studentsSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition(); // Definition
        definition.setPortTypeName("StudentPort"); // Name of the port
        definition.setTargetNamespace(Namespaces.STUDENT_NAMESPACE); // Namespace
        definition.setLocationUri("/ws"); // Previous uri
        definition.setSchema(studentsSchema); // Schema
        return definition;
    }

    /**
     * Records one schema from resources
     * @return
     */
    @Bean
    public  XsdSchema studentsSchema(){
        return new SimpleXsdSchema(new ClassPathResource("/xsd/student-details.xsd"));
    }



}
