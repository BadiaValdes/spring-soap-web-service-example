//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.08.08 a las 05:10:55 PM EDT 
//


package com.soap.students;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.students package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.students
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentDetailsRequest }
     * 
     */
    public GetStudentDetailsRequest createGetStudentDetailsRequest() {
        return new GetStudentDetailsRequest();
    }

    /**
     * Create an instance of {@link GetStudentDetailsResponse }
     * 
     */
    public GetStudentDetailsResponse createGetStudentDetailsResponse() {
        return new GetStudentDetailsResponse();
    }

    /**
     * Create an instance of {@link StudentDetails }
     * 
     */
    public StudentDetails createStudentDetails() {
        return new StudentDetails();
    }

    /**
     * Create an instance of {@link CreateStudentDetailsRequest }
     * 
     */
    public CreateStudentDetailsRequest createCreateStudentDetailsRequest() {
        return new CreateStudentDetailsRequest();
    }

    /**
     * Create an instance of {@link StudentCreate }
     * 
     */
    public StudentCreate createStudentCreate() {
        return new StudentCreate();
    }

}
