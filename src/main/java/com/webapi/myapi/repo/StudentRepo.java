package com.webapi.myapi.repo;

import com.webapi.myapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);
    List<Student> findByGender(char gender);

    @Modifying
    @Query(value = "DELETE FROM Student WHERE sid= ?1",nativeQuery = true)
    int delete(int id);
}
