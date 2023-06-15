package com.design.studentManagement.controller;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.ScheduleClass;
import com.design.studentManagement.pojo.Score;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.pojo.res.RestFulBean;
import com.design.studentManagement.service.ScheduleClassService;
import jxl.write.WriteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (ScheduleClass)表控制层
 *
 * @author makejava
 * @since 2022-08-10 15:31:35
 */
@RestController
@RequestMapping("/scheduleClass")
public class ScheduleClassController {
    /**
     * 服务对象
     */
    @Autowired
    private ScheduleClassService scheduleClassService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getList(page);
    }
    /**
     * 分页查询获取选修课
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/choose/list")
    public RestFulBean<Map> getChooseList(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getChooseList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<ScheduleClass> queryById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.queryById(scheduleClass.getId());
    }

    /**
     * 新增数据
     *
     * @param ScheduleClass 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.insert(scheduleClass);
    }

    /**
     * 编辑数据
     *
     * @param ScheduleClass 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.update(scheduleClass);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.deleteById(scheduleClass.getId());
    }
    /**
     * 获取教师所教的课程
     *
     * @param
     * @return
     */
    @PostMapping("/get/course/by/userId")
    public RestFulBean<Map> getCourseByUserId(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getCourseByUserId(page);
    }

    //获取教师所教课程的学生
    @PostMapping("/get/studentList")
    public RestFulBean<List<Score>> getStudentList(@RequestBody ScheduleClass scheduleClass) throws Exception {
        return scheduleClassService.getStudentList(scheduleClass);
    }

}
