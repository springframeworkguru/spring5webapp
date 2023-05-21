package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "student_details")
@Table(name = "my_Student")
public class Student {
    private String name;

    @Id
    private Integer id;
    private String city;

    public Student(String name, Integer id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public Student() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
