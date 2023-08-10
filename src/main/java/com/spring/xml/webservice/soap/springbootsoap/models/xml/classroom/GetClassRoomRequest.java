package com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "classRoomRequest"
})
@XmlRootElement(name = "GetClassRoomRequest")
public class GetClassRoomRequest {

    @XmlElement(name = "ClassRoomRequest", required = true)
    protected ClassRoomRequest classRoomRequest;

    public ClassRoomRequest getClassRoomRequest() {
        return classRoomRequest;
    }

    public void setClassRoomRequest(ClassRoomRequest classRoomRequest) {
        this.classRoomRequest = classRoomRequest;
    }
}
