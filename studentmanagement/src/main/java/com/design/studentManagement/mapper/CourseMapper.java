package com.design.studentManagement.mapper;

import com.design.studentManagement.pojo.Course;
import java.util.List;
import com.design.studentManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Course)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-08 22:12:17
 */
public interface CourseMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Course queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Course> getPageListByCondition(@Param("page") Page<Course> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Course> page);


    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int insert(Course course);




    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Course> getByprofessionId(Integer professionId);

    Course getNum(Integer courseId);
}

