package com.spring.xml.webservice.soap.springbootsoap.service;

import com.spring.xml.webservice.soap.springbootsoap.models.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);
    Student getStudent(String id) throws Exception;
}
