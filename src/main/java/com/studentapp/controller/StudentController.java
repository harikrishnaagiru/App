package com.studentapp.controller;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String name) {
        studentService.addStudent(name);
        return "redirect:/";
    }

    @PutMapping("/updateAttendance/{id}")
    public String updateAttendance(@PathVariable Long id) {
        studentService.toggleAttendance(id);
        return "Attendance updated";
    }
}
