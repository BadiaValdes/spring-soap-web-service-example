package com.spring.xml.webservice.soap.springbootsoap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private int age;
}
