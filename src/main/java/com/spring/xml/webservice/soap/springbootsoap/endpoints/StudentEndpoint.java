package com.spring.xml.webservice.soap.springbootsoap.endpoints;

import com.soap.students.CreateStudent;
import com.soap.students.CreateStudentDetailsRequest;
import com.soap.students.GetStudentDetailsResponse;
import com.soap.students.StudentDetails;
import com.spring.xml.webservice.soap.springbootsoap.core.constants.Namespaces;
import com.spring.xml.webservice.soap.springbootsoap.models.Student;
import com.spring.xml.webservice.soap.springbootsoap.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

@Endpoint // Indicates web service endpoints
@RequiredArgsConstructor // Use this instead @Autowired
public class StudentEndpoint {
    public final IStudentService studentService;

    @PayloadRoot(localPart = "CreateStudentDetailsRequest", namespace = Namespaces.STUDENT_NAMESPACE) //The request that will be handled and the namespace
    @ResponsePayload // Convert the response in XML
    public GetStudentDetailsResponse createStudent(@RequestPayload CreateStudentDetailsRequest createStudent){

        Student createData = new Student();

        createData
                .setId(UUID.randomUUID().toString())
                .setName(createStudent.getName())
                .setAge(Integer.parseInt(createStudent.getAge()));

        createData = studentService.createStudent(createData);

        GetStudentDetailsResponse response = new GetStudentDetailsResponse();

        StudentDetails studentDetails = new StudentDetails();

        studentDetails.setAge(createData.getAge() + "");
        studentDetails.setName(createData.getName());
        studentDetails.setId(createData.getId());

        response.setStudentDetails(studentDetails);

        return response;
    }
}
