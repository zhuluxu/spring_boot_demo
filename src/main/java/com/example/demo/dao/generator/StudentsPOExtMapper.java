package com.example.demo.dao.generator;

import com.example.demo.entity.generator.model.StudentsPOExt;
import com.example.demo.entity.generator.model.StudentsQueryBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author didi
 */
public interface StudentsPOExtMapper extends StudentsPOMapper {

    /**
     * 分页查询
     * @param pageWhere
     * @return
     */
    List<StudentsPOExt> selectByPage(@Param("pageWhere") StudentsQueryBo pageWhere);
}
