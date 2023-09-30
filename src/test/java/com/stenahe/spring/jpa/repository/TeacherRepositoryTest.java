package com.stenahe.spring.jpa.repository;

import com.stenahe.spring.jpa.entity.Course;
import com.stenahe.spring.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(8)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Johnathan")
                        .lastName("Haidt")
//                        .courses(List.of(courseDBA, courseJAVA))
                        .build();

        teacherRepository.save(teacher);
    }
}