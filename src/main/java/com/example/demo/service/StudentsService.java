package com.example.demo.service;

import com.example.demo.entity.Students;

/**
 * @author didi
 */
public interface StudentsService {
    /**
     * 查询单个学生
     * @param id
     * @return
     */
    Students getById(Integer id);
}
