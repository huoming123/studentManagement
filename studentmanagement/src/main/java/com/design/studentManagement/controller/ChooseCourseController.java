package com.design.studentManagement.controller;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.ChooseCourse;
import com.design.studentManagement.pojo.ChooseCourse;
import com.design.studentManagement.pojo.res.RestFulBean;
import com.design.studentManagement.service.ChooseCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (ChooseCourse)表控制层
 *
 * @author makejava
 * @since 2022-08-11 11:23:09
 */
@RestController
@RequestMapping("/chooseCourse")
public class ChooseCourseController {
    /**
     * 服务对象
     */
    @Autowired
    private ChooseCourseService chooseCourseService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<ChooseCourse> page) throws Exception{
        return this.chooseCourseService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<ChooseCourse> queryById(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.queryById(chooseCourse.getId());
    }

    /**
     * 新增数据
     *
     * @param ChooseCourse 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.insert(chooseCourse);
    }

    /**
     * 编辑数据
     *
     * @param ChooseCourse 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.update(chooseCourse);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.deleteById(chooseCourse.getId());
    }

}
