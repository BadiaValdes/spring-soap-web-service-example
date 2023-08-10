package com.spring.xml.webservice.soap.springbootsoap.endpoints;

import com.soap.students.CreateStudentDetailsRequest;
import com.soap.students.GetStudentDetailsResponse;
import com.soap.students.StudentDetails;
import com.spring.xml.webservice.soap.springbootsoap.core.constants.Namespaces;
import com.spring.xml.webservice.soap.springbootsoap.models.entity.Student;
import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoom;
import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoomRequest;
import com.spring.xml.webservice.soap.springbootsoap.service.IClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

/**
 * Aqui no cambia nada con respecto a Student Endpoint
 */

@Endpoint // Indicates web service endpoints
@RequiredArgsConstructor // Use this instead @Autowired
public class ClassRoomEndpoint {
    private final IClassRoomService classRoomService;

    @PayloadRoot(localPart = "ClassRoomRequest", namespace = Namespaces.CLASS_ROOM_NAMESPACE) //The request that will be handled and the namespace
    @ResponsePayload // Convert the response in XML
    public ClassRoom createStudent(@RequestPayload ClassRoomRequest classRoom){
        ClassRoom createData = new ClassRoom();

        createData
                .setId(UUID.randomUUID().toString())
                .setNumber(classRoom.getNumber())
                .setTables(classRoom.getTables())
                .setChairs(classRoom.getChairs());

        createData = classRoomService.createClassRoom(createData);

        return createData;
    }
}
