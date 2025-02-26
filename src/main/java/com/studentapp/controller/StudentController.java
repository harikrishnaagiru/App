package com.studentapp.controller;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Student name cannot be empty");
            return "addStudent"; // Return to the form page with an error message
        }
        studentService.addStudent(name);
        return "redirect:/students/";
    }

    @GetMapping("/attendance")
    public String viewAttendance(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "viewAttendance";
    }
}
