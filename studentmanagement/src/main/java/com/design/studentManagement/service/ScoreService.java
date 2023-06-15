package com.design.studentManagement.service;

import com.design.studentManagement.pojo.Score;
import com.design.studentManagement.pojo.res.RestFulBean;
import com.design.studentManagement.dto.Page;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Score)表服务接口
 *
 * @author makejava
 * @since 2022-08-08 23:10:18
 */
public interface ScoreService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Score> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Score> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Score>> getScoreList(Score score);

    RestFulBean<Map> export(Score score) throws WriteException, IOException;

    RestFulBean<List<Score>> getStudentScoreList(Page<Score> page);

}
