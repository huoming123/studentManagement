package com.design.studentManagement.service;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Profession;
import com.design.studentManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Profession)表服务接口
 *
 * @author makejava
 * @since 2022-08-05 10:45:22
 */
public interface ProfessionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Profession> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Profession profession);

    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Profession profession);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Profession>> getList();

    RestFulBean<Map> getPageList(Page<Profession> page) throws Exception;
}
