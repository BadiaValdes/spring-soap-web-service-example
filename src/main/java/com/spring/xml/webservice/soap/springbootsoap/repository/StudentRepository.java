package com.spring.xml.webservice.soap.springbootsoap.repository;

import com.spring.xml.webservice.soap.springbootsoap.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
