package com.stenahe.spring.jpa.repository;

import com.stenahe.spring.jpa.entity.Guardian;
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
                .firstName("Santiago")
                .lastName("Tena")
                .emailId("santiago@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Bob")
                .email("bob@gmail.com")
                .mobileNumber("54321")
                .build();

        Student student = Student.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .emailId("max@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("Max");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("tia");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Bob");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentWithLastName() {
        List<Student> students =
                studentRepository.findByLastNameNotNull();

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student student =
                studentRepository.findByFirstNameAndLastName("Santiago", "Tena");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentsByEmailAddress("santiago@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String studentName =
                studentRepository.getStudentFirstNameByEmailAddress("santiago@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student studentName =
                studentRepository.getStudentByEmailAddressNative("santiago@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void printGetStudentByEmailAddressNamedParam() {
        Student studentName =
                studentRepository.getStudentByEmailAddressNative("santiago@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Maxwell",
                "max@gmail.com");
    }

}
