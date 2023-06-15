package com.design.studentManagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (ChooseCourse)实体类
 *
 * @author makejava
 * @since 2022-08-11 11:23:09
 */
public class ChooseCourse implements Serializable {
    private static final long serialVersionUID = -23927541137485710L;
    
    private Integer id;
    /**
     * 课表id
     */
    private Integer scheduleClassId;
    /**
     * 用户id  记录哪个学生
     */
    private Integer userId;
    /**
     * 选课时间
     */
    private Timestamp createdAt;
    /**
     * 是否确定提交 1 为确定 0 为还没有提交
     */
    private Integer confirm;
    /**
     * 课程id
     */
    private Integer courseId;
    private Integer year;
    private String term;
    private Integer classeId;

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleClassId() {
        return scheduleClassId;
    }

    public void setScheduleClassId(Integer scheduleClassId) {
        this.scheduleClassId = scheduleClassId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

}
