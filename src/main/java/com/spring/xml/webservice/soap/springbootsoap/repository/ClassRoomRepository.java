package com.spring.xml.webservice.soap.springbootsoap.repository;

import com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ClassRoomRepository extends JpaRepository<ClassRoom, String> {
}
