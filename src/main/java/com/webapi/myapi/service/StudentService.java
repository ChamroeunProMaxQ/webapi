package com.webapi.myapi.service;

import com.webapi.myapi.model.Student;
import com.webapi.myapi.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> findAllStudent () {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }

    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }

    public List<Student> findByGender(char gender){
        return studentRepo.findByGender(gender);
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public void update(Student student) {
       Student student1 = studentRepo.findById(student.getSid()).orElse(new Student());
       if(student1.getSid() != 0)
           studentRepo.save(student);
       else student1.setName("168");

    }

    public Student updateById(int id, String name){
        Student student = studentRepo.findById(id).orElse(new Student());
        student.setName(name);
        studentRepo.save(student);
        return student;
    }

    public Student deleteStudent(int sid) {
        Student student = studentRepo.findById(sid).get();
        studentRepo.deleteById(sid);
        return student;
    }

    public int deleteByObj(Student student) {
        return  studentRepo.delete(student.getSid());
    }
}
