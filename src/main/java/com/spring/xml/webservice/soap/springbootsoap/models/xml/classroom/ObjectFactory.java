package com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry // Permite registrar el object factory donde declaramos todos los mensajes
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.students
     */
    public ObjectFactory() {
    }

    /**
     * Creamos un método del tipo ClassRoomRequest (Para poder crear el request de la peticion).
     * Además el nombre del método debe crear con la acción a realizar. En este caso create.
     */
    // El Request dice que es input
    public ClassRoomRequest createClassRoomRequest() {
        return new ClassRoomRequest();
    }

    /**
     * Estas dos clases de abajo se agrupan en el XSD.
     * Esto se debe a que ambas clases comienzan con el mismo nombre
     * GetClassRoom y respectivamente terminan en Request y Response.
     * La que lleve el nombre request será el input y la otra el output
     *
     * <wsdl:operation name="GetClassRoom">
     * <wsdl:input message="tns:GetClassRoomRequest" name="GetClassRoomRequest"> </wsdl:input>
     * <wsdl:output message="tns:GetClassRoomResponse" name="GetClassRoomResponse"> </wsdl:output>
     * </wsdl:operation>
     *
     * @return
     */

    // El Response detras dice que es output
    public GetClassRoomResponse createGetClassRoomResponse() {
        return new GetClassRoomResponse();
    }


    // El Request detras dice que es input
    public GetClassRoomRequest createGetClassRoomRequest() {
        return new GetClassRoomRequest();
    }
}
