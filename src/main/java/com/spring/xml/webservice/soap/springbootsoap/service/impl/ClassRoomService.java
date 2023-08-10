package com.spring.xml.webservice.soap.springbootsoap.service.impl;

import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoom;
import com.spring.xml.webservice.soap.springbootsoap.repository.ClassRoomRepository;
import com.spring.xml.webservice.soap.springbootsoap.service.IClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomService implements IClassRoomService {

    public final ClassRoomRepository classRoomRepository;

    @Override
    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom getClassRoom(String id) throws Exception {
        return classRoomRepository.findById(id).orElse(new ClassRoom());
    }
}
