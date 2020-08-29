package com.example.demo;

import com.example.demo.config.application.listener.MyApplicationEvent;
import com.example.demo.config.application.useone.MailSender;
import com.example.demo.dao.generator.StudentsPOExtMapper;
import com.example.demo.dao.generator.StudentsPOMapper;
import com.example.demo.entity.Students;
import com.example.demo.entity.generator.model.StudentsPO;
import com.example.demo.entity.generator.model.StudentsPOCriteria;
import com.example.demo.entity.generator.model.StudentsPOExt;
import com.example.demo.entity.generator.model.StudentsQueryBo;
import com.example.demo.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class StudentsServiceTest {

    @Resource
    private StudentsService studentsService;

    @Resource
    private StudentsPOMapper studentsPOMapper;

    @Resource
    private StudentsPOExtMapper studentsPOExtMapper;

    @Resource(name = "mailSender")
    private MailSender mailSender;

    @Test
    public void testById() {
        Students byId = studentsService.getById(1);
        System.out.println(byId);
        mailSender.sendMail("er");
    }

    @Test
    public void testByCon() {
        StudentsPOCriteria studentsPOCriteria = new StudentsPOCriteria();
        studentsPOCriteria.createCriteria().andIdEqualTo(1);
        List<StudentsPO> studentsPOS = studentsPOMapper.selectByExample(studentsPOCriteria);
        System.out.println(studentsPOS.get(0).getName());
    }

    @Test
    public void testSelect() {
        StudentsPOCriteria studentsPOCriteria = new StudentsPOCriteria();
        studentsPOCriteria.createCriteria();
        List<StudentsPO> studentsPOS = studentsPOMapper.selectByExample(studentsPOCriteria);

        System.out.println(studentsPOS.size());
    }


    @Test
    public void testSelectByPage() {
        Integer  pageSize = 2;
        Integer  page = 1;

        StudentsQueryBo studentsQueryBo = new StudentsQueryBo();
        studentsQueryBo.setOffset((page - 1) * pageSize);
        studentsQueryBo.setLimit(pageSize);
        studentsQueryBo.setExcellent(0);
        List<StudentsPOExt> studentsPOExts = studentsPOExtMapper.selectByPage(studentsQueryBo);

        System.out.println(studentsPOExts.size());
        studentsPOExts.forEach(st -> System.out.println(st.getName()));

    }
}
