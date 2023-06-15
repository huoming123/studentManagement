package com.design.studentManagement.controller;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Application;
import com.design.studentManagement.pojo.res.RestFulBean;
import com.design.studentManagement.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (Application)表控制层
 *
 * @author makejava
 * @since 2022-08-10 09:08:58
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {
    /**
     * 服务对象
     */
    @Autowired
    private ApplicationService applicationService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Application> page) throws Exception{
        return this.applicationService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<Application> queryById(@RequestBody Application application) {
        return this.applicationService.queryById(application.getId());
    }

    /**
     * 新增数据
     *
     * @param application 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Application application) {
        return this.applicationService.insert(application);
    }

    /**
     * 编辑数据
     *
     * @param application 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Application application) {
        return this.applicationService.update(application);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Application application) {
        return this.applicationService.deleteById(application.getId());
    }

}
