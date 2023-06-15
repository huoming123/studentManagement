package com.design.studentManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2022-08-08 22:12:17
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -19159197640605192L;
     
    private Integer id;

    private String courseNo;

    private Integer professionId;

    private Double gpa;
    /**
     *  人数
     */
    private Integer num;
    /**
     *  额外字段 专业名称
     */
    private String professionName;
     /**
     * 课程名字
     */
    private String courseName;
    /**
     * 类型
     */
    private String type;
     /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Timestamp createdAt;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

