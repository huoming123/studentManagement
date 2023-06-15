package com.design.studentManagement.controller;

import com.design.studentManagement.pojo.ClasseHistory;
import com.design.studentManagement.service.ClasseHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.studentManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (ClasseHistory)表控制层
 *
 * @author makejava
 * @since 2022-08-13 12:43:58
 */
@RestController
@RequestMapping("/classeHistory")
public class ClasseHistoryController {
    /**
     * 服务对象
     */
    @Autowired
    private ClasseHistoryService classeHistoryService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<ClasseHistory>page) throws Exception{
        return this.classeHistoryService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<ClasseHistory> queryById(@RequestBody ClasseHistory classeHistory) {
        return this.classeHistoryService.queryById(classeHistory.getId());
    }

    /**
     * 新增数据
     *
     * @param classeHistory 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ClasseHistory classeHistory) {
        return this.classeHistoryService.insert(classeHistory);
    }

    /**
     * 编辑数据
     *
     * @param classeHistory 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ClasseHistory classeHistory) {
        return this.classeHistoryService.update(classeHistory);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ClasseHistory classeHistory) {
        return this.classeHistoryService.deleteById(classeHistory.getId());
    }

}

