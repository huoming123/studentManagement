package com.design.studentManagement.mapper;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Application;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Application)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-10 09:08:58
 */
public interface ApplicationMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Application queryById(Integer id);


    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int insert(Application application);


    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 分页查询数据
     *
     * @param
     * @return 实例对象
     */
    List<Application> getPageListByCondition(@Param("page") Page<Application> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Application> page);
}
