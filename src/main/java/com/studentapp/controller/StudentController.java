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

    // Display home page with student list
    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    // Add new student
    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String name) {
        studentService.addStudent(name);
        return "redirect:/";
    }

    // Update attendance
    @PostMapping("/updateAttendance")
    public String updateAttendance(@RequestParam Long id, @RequestParam boolean attendance) {
        studentService.updateAttendance(id, attendance);
        return "redirect:/";
    }

    // Delete student
    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
