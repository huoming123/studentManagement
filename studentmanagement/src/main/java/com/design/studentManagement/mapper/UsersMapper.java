package com.design.studentManagement.mapper;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-04 15:05:48
 */
public interface UsersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);


    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Users getByUserNoAndRole(String userNo, String role);

    List<Users> getPageListByCondition(@Param("page") Page<Users> page);

    Integer getPageListCount(@Param("page") Page<Users> page);

    //根据身份证查找用户
    Users getByCardId(String cardId);;

    List<Users> getPageCountListByCondition(@Param("page") Page<Users> page);

    Integer getPageCountByCondition(@Param("page") Page<Users> page);

    List<Users> getAllStudentsList();

    void updateClass(Users users);

    List<Users> getTeachList();

    List<Users> getAbsenteeListByCondition(@Param("page") Page<Users> page);

    Integer getAbsenteeCountByCondition(@Param("page") Page<Users> page);

    void updatePassword(Users users);
}
