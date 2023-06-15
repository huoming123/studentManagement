package com.design.studentManagement.controller;

import com.design.studentManagement.pojo.Classe;
import com.design.studentManagement.pojo.Course;
import com.design.studentManagement.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.studentManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2022-08-08 22:12:17
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Course> page) throws Exception{
        return this.courseService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Course> queryById(@RequestBody Course course) {
        return this.courseService.queryById(course.getId());
    }

    /**
     * 新增数据
     *
     * @param course 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Course course) {
        return this.courseService.insert(course);
    }

    /**
     * 编辑数据
     *
     * @param course 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Course course) {
        return this.courseService.update(course);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Course course) {
        return this.courseService.deleteById(course.getId());
    }
    /**
     * 根据专业id获取课程
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/professionId")
    public RestFulBean<List<Course>> getByprofessionId(@RequestBody Course course) {
        return this.courseService.getByprofessionId(course.getProfessionId());
    }
}

