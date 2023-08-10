package com.spring.xml.webservice.soap.springbootsoap.service;

import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoom;

public interface IClassRoomService {
    ClassRoom createClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoom(String id) throws Exception;
}
