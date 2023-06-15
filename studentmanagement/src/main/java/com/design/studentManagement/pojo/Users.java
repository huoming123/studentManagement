package com.design.studentManagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2022-08-04 15:05:48
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 309307584285486824L;
    
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 角色
     */
    private String role;
    /**
     * 密码
     */
    private String password;
    /**
     * 宿舍住址
     */
    private String address;
    /**
     * 注册时间
     */
    private Timestamp createdAt;
    /**
     * 入学时间
     */
    private Timestamp startAt;
    /**
     * 入学时间 (教师为入职时间) 用于打印excel表格
     */
    private String createdTime;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 学号 教师号
     */
    private String userNo;
    /**
     * 身份证
     */
    private String cardId;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号存个字符串11位
     */
    private String telephone;
    /**
     * 照片
     */
    private String image;
    /**
     * 照片路劲 前端显示
     */
    private String imageUrl;
    /**
     *
     * 民族
     */
    private String nation;
    /**
     * 出生年月 时间戳
     */
    private Timestamp birthday;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 婚姻状况
     */
    private String maritalStatus;
    /**
     * 政治面貌
     */
    private String political;
    /**
     * 毕业时间 (教师为辞职时间)
     */
    private Timestamp leaveAt;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 修改时间
     */
    private Timestamp updatedAt;
    /**
     * 部门 (教师用)
     */
    private String depart;
    /**
     * 职称(教师用)
     */
    private String rank;
    /**
     * 专业id
     */
    private Integer professionId;
    /**
     * 专业名字
     */
    private String professionName;
    /**
     *  年份 额外字段 接收前端参数
     */
    private Integer year;
    /**
     *  是否离职 额外字段 接收前端参数
     */
    private Integer isLeave;
    /**
     *  统计条数
     */
    private Integer count;
    /**
     *  结业
     */
    private Integer isGraduate;
    /**
     *  班级id
     */
    private Integer classeId;
    /**
     *  额外字段 是否是新生
     */
    private Integer isNew;
    /**
     *  数组参数
     */
    private List<Users> usersList;
    /**
     *  额外字段 在籍
     */
    private Integer absentee;

    /**
     * 班级名称
     */
    private String className;
    /**
     * 班主任
     */
    private String classMaster;

    public String getClassMaster() {
        return classMaster;
    }

    public void setClassMaster(String classMaster) {
        this.classMaster = classMaster;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getAbsentee() {
        return absentee;
    }

    public void setAbsentee(Integer absentee) {
        this.absentee = absentee;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(Integer isGraduate) {
        this.isGraduate = isGraduate;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Timestamp getLeaveAt() {
        return leaveAt;
    }

    public void setLeaveAt(Timestamp leaveAt) {
        this.leaveAt = leaveAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
