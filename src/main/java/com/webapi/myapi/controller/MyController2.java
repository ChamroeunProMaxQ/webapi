package com.webapi.myapi.controller;

import com.webapi.myapi.model.Student;
import com.webapi.myapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/studentList")
public class MyController2 {

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }


    @CrossOrigin(methods = RequestMethod.POST)
    @PostMapping("")
    public Student addStudent(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @PutMapping("")
    public Student updateStudent(@RequestBody Student student){
        studentService.update(student);
        return student;
    }

    @PutMapping("/id/{id}")
    public Student updateById(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/id/{id}/{name}")
    public Student updateNameById(@PathVariable int id,@PathVariable String name){
       return studentService.updateById(id,name);
    }

    @DeleteMapping("/id/{id}")
    public Student deleteStudentById(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("")
    public int deleteById(@RequestBody Student student){
        return studentService.deleteByObj(student);
    }

}
