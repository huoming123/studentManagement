package com.design.studentManagement.service;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.ChooseCourse;
import com.design.studentManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (ChooseCourse)表服务接口
 *
 * @author makejava
 * @since 2022-08-11 11:23:09
 */
public interface ChooseCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ChooseCourse> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ChooseCourse chooseCourse);

    /**
     * 修改数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ChooseCourse chooseCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<ChooseCourse> page) throws Exception;


}
