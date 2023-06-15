package com.design.studentManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Classe)实体类
 *
 * @author makejava
 * @since 2022-08-08 22:20:39
 */
public class Classe implements Serializable {
    private static final long serialVersionUID = -10426001669721365L;

    private Integer id;
     /**
     * 专业id
     */
     private Integer year;
    /**
     * 用户id
     */
    private Integer userId;

    private Integer professionId;
     /**
     * 班级
     */
    private String className;

    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Timestamp createdAt;

    private String professionName;
    private String userName;
    private Integer historyId;
    private Integer classeId;

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}

