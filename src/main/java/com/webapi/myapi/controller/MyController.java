package com.webapi.myapi.controller;

import com.webapi.myapi.model.Student;
import com.webapi.myapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentList")
public class MyController {

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, DELETE");
    }

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> studentList () {
        return studentService.findAllStudent();
    }

    @GetMapping("/id/{id}")
    public Optional<Student> FindStudentById(@PathVariable int id){
        return studentService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> FindStudentByName(@PathVariable String name){
        return studentService.findByName(name);
    }

    @GetMapping("/gender/{gender}")
    public List<Student> FindStudentByGender(@PathVariable char gender){
        return studentService.findByGender(gender);
    }
}
