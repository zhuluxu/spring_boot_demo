package com.example.demo.service.impl;

import com.example.demo.dao.StudentsDao;
import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author didi
 */
@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsDao studentsDao;

    @Override
    public Students getById(Integer id) {
        return studentsDao.selectById(id);
    }
}
