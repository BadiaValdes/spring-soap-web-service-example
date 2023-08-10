package com.spring.xml.webservice.soap.springbootsoap.service.impl;

import com.spring.xml.webservice.soap.springbootsoap.models.entity.Student;
import com.spring.xml.webservice.soap.springbootsoap.repository.StudentRepository;
import com.spring.xml.webservice.soap.springbootsoap.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    public final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(String id) throws Exception {
        return studentRepository.findById(id).orElseThrow(Exception::new);
    }
}
