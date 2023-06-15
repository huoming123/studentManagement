package com.design.studentManagement.service;

import com.design.studentManagement.pojo.Classe;
import com.design.studentManagement.pojo.Course;
import com.design.studentManagement.pojo.res.RestFulBean;
import com.design.studentManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Course)表服务接口
 *
 * @author makejava
 * @since 2022-08-08 22:12:17
 */
public interface CourseService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Course> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Course> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Course course);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Course>> getByprofessionId(Integer professionId);
}
