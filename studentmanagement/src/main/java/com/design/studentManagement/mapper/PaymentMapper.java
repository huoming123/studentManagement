package com.design.studentManagement.mapper;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Payment;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * (Payment)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-06 12:38:13
 */
public interface PaymentMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Payment> getPageListByCondition(@Param("page") Page<Payment> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Payment> page);


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);




    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Payment> queryByUserId(Integer userId);

    void pay(Payment payment);

    List<Payment> getTotalListByCondition(@Param("page") Page<Payment> page);

    Integer getTotalListCount(@Param("page")Page<Payment> page);

    List<Payment> getTotalFee(Payment payment);

    List<Payment> getHavedTotalFee(Payment payment);

    List<Payment> getUnhavedTotalFee(Payment payment);
}

