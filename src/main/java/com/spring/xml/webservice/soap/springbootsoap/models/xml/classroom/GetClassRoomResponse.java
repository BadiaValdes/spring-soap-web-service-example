package com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "classRoom"
})
@XmlRootElement(name = "GetClassRoomResponse")
public class GetClassRoomResponse {

    @XmlElement(name = "ClassRoom", required = true)
    protected ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
