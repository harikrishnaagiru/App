package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Add new student (default attendance = false)
    public void addStudent(String name) {
        Student student = new Student();
        student.setName(name);
        student.setAttendance(false);
        studentRepository.save(student);
    }

    // Update student attendance
    @Transactional
    public boolean updateAttendance(Long id, boolean attendance) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setAttendance(attendance);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    // Find students by name
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    // Delete student by ID
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
