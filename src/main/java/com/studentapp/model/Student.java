package com.studentapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean attendance;

    // Default constructor (Required by JPA)
    public Student() {}

    // Parameterized constructor for convenience
    public Student(String name, boolean attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Corrected Getter and Setter for Attendance
    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
