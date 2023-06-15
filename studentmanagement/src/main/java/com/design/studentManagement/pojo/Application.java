package com.design.studentManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2022-08-10 09:08:58
 */
public class Application implements Serializable {
    private static final long serialVersionUID = -48218368310193247L;
    
    private Integer id;
    /**
     * 用户id 记录是哪位教师的课程
     */
    private Integer userId;
    /**
     * 课程名字
     */
    private String name;
    /**
     * 理由
     */
    private String reason;
    /**
     * 开课申请 审核是否通过 1为通过 0为不通过
     */
    private Integer checked;
    /**
     * 申请时间
     */
    private Timestamp createdAt;
    /**
     * 审核人
     */
    private String checkBy;
    /**
     * 额外字段 用户名
     */
    private String userName;
    /**
     * 额外字段 控制按钮的编辑状态
     */
    private Boolean disabled;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

}
