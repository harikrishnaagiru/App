package com.studentapp.controller;

import com.studentapp.model.Student;
import com.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String name) {
        Student student = new Student();
        student.setName(name);
        student.setAttendance(false);
        studentRepository.save(student);
        return "redirect:/";
    }
}
