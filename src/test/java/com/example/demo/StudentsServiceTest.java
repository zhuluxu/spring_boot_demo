package com.example.demo;

import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootTest
public class StudentsServiceTest {

    @Resource
    private StudentsService studentsService;

    @Test
    public void testById() {
        Students byId = studentsService.getById(1);
        System.out.println(byId);
    }
}
