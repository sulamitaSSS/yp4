package com.web_project.school.controllers;

import com.web_project.school.model.StudentModel;
import com.web_project.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String corpEmail) {
        StudentModel newStudent = new StudentModel(0, name, firstName, lastName, corpEmail);
        studentService.addStudent(newStudent);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String corpEmail) {
        StudentModel updateStudent = new StudentModel(id, name, firstName, lastName, corpEmail);
        studentService.updateStudent(updateStudent);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("students", studentService.findStudentById(id));
        return "studentList";
    }

    @GetMapping("/filter")
    public String filterStudent(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String corpEmail,
                                Model model) {
        List<StudentModel> students = studentService.findByFirstNameAndLastNameAndCorpEmail(firstName, lastName, corpEmail);
        model.addAttribute("students", students);
        return "studentList";
    }
}
