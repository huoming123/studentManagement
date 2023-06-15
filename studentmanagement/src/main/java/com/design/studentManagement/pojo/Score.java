package com.design.studentManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * (Score)实体类
 *
 * @author makejava
 * @since 2022-08-08 23:10:18
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 848023603842292465L;
     
    private Integer id;
     /**
     * 用户id 记录是哪个学生的成绩
     */
    private Integer userId;

    private Integer classeId;

     /**
     * 分数
     */
    private Double score;
     /**
     * 年份
     */
    private Integer year;
    /**
     * 是否为选修
     */
    private Integer elective;
    /**
     * 是否为选修 用于前端显示
     */
    private String electived;
     /**
     * 记录一个成绩是上学期还是下学期
     */
    private String term;
     /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 录入时间
     */
    private Timestamp createdAt;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 姓名
     */
    private String UserName;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 班级
     */
    private String className;
    /**
     * 学号
     */
    private String userNo;
    /**
     * 参数 判断是打印成绩还是打印学生名单 共用打印接口
     */
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    private List<Score> scoreList;

    public Integer getElective() {
        return elective;
    }

    public void setElective(Integer elective) {
        this.elective = elective;
    }

    public String getElectived() {
        return electived;
    }

    public void setElectived(String electived) {
        this.electived = electived;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}

