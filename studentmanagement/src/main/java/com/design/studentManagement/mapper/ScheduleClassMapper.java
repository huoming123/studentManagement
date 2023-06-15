package com.design.studentManagement.mapper;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.ScheduleClass;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ScheduleClass)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-10 15:31:35
 */
public interface ScheduleClassMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleClass queryById(Integer id);


    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int insert(ScheduleClass scheduleClass);


    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int update(ScheduleClass scheduleClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    ScheduleClass getByTime(ScheduleClass scheduleClass);

    List<ScheduleClass> getPageListByCondition(@Param("page") Page<ScheduleClass> page);

    Integer getPageListCount(@Param("page") Page<ScheduleClass> page);

    List<ScheduleClass> getPageChooseListByCondition( @Param("page") Page<ScheduleClass> page);

    Integer getPageChooseListCount(@Param("page") Page<ScheduleClass> page);

    ScheduleClass getById(Integer scheduleClassId);

    List<ScheduleClass> getCourseByUserId(@Param("page") Page<ScheduleClass> page);

    ScheduleClass getByTime1(ScheduleClass scheduleClass);

    List<ScheduleClass> getStudentList(ScheduleClass scheduleClass);

    List<ScheduleClass> getScoreList(ScheduleClass scheduleClass);


    List<ScheduleClass> queryByScheduleClassId(Integer id);
}
