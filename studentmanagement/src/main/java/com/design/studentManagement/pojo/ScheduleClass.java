package com.design.studentManagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (ScheduleClass)实体类
 *
 * @author makejava
 * @since 2022-08-10 15:31:35
 */
public class ScheduleClass implements Serializable {
    private static final long serialVersionUID = -36922746318695840L;

    private Integer id;
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 班级id
     */
    private Integer classeId;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 学期
     */
    private String term;
    /**
     * 教师id
     */
    private Integer userId;
    /**
     * 创建日期
     */
    private Timestamp createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 周几
     */
    private String weekDay;
    /**
     * 开始时间段
     */
    private String startTime;
    /**
     * 结束时间段
     */
    private String endTime;
    /**
     * 课室
     */
    private String room;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     *  专业名称
     */
    private String professionName;
    /**
     * 专业id
     */
    private Integer professionId;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 班级
     */
    private String className;
    /**
     * 选修或必修
     */
    private Integer elective;
    /**
     * 课程编号
     */
    private String courseNo;
    /**
     * 限制人数
     */
    private Integer num;
    /**
     * 剩余人数
     */
    private Integer remainNum;
    /**
     * 是否提交
     */
    private String confirm;
    /**
     *  额外字段 用于控制前端按钮是否可以编辑
     */
    private Boolean disabled;
    /**
     * 选课表 choose_course id
     */
    private Integer chooseId;

    private Double gpa;

    private Double score;
    /**
     * 前端tab栏传来的index值 0 为必修 1为选修
     */
    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getElective() {
        return elective;
    }

    public void setElective(Integer elective) {
        this.elective = elective;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
