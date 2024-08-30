package com.example.practice.student;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentWebController {
    private final StudentService studentService;

    @GetMapping({ "/web" })
    public String getWebPage(Model model) {
        List<Student> students = this.studentService.getStudents();
        model.addAttribute("students", students);
        return "index";
    }
}
