package com.example.demo.dao;

import com.example.demo.entity.Students;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author didi
 */
@Repository
@Mapper
public interface StudentsDao {
    /**
     * 根据ID查询一个学生
     * @param id
     * @return
     */
    Students selectById(@Param("id") Integer id);
}
