package com.stenahe.spring.jpa.repository;

import com.stenahe.spring.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //Will affect the database
//@DataJpaTest //Used for normal testing, does not affect the DB
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("santiago@gmail.com")
                .firstName("Santiago")
                .lastName("Tena")
                .guardianName("Gaspar")
                .guardianEmail("gaspar@gmail.com")
                .guardianMobile("12345")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

}