package com.design.studentManagement.pojo;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2022-08-06 12:38:13
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = -60861557822201442L;
     
    private Integer id;
     /**
     * 用户id
     */
    private Integer userId;
     /**
     * 是否缴费 1为是 0为否
     */
    private Integer isPay;
    /**
     * 是否缴费 1为是 0为否
     */
    private String pay;
     /**
     * 年份
     */
    private Integer year;
    /**
     * 专业名称
     */
    private String name;
    /**
     * 额外字段 学费
     */
    private Integer tuition;
    /**
     * 额外字段 住宿费
     */
    private Integer stayFee;
    /**
     * 额外字段 合计
     */
    private Integer total;
    /**
     * 额外字段 已交费用
     */
    private Integer havedTotal;
    /**
     * 额外字段 未交费用
     */
    private Integer unHavedTotal;
    /**
     *  未缴费可以点缴费 已缴费不给点
     */
    private boolean disabled;
    /**
     * 年级
     */
    private Integer yearClass;
    /**
     * 专业id
     */
    private Integer professionId;
    /**
     * 班级id
     */
    private Integer classeId;
    /**
     * 专业名称
     */
    private String professionName;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 打印链接
     */
    private String excelUrl;

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getExcelUrl() {
        return excelUrl;
    }

    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl;
    }

    public Integer getHavedTotal() {
        return havedTotal;
    }

    public void setHavedTotal(Integer havedTotal) {
        this.havedTotal = havedTotal;
    }

    public Integer getUnHavedTotal() {
        return unHavedTotal;
    }

    public void setUnHavedTotal(Integer unHavedTotal) {
        this.unHavedTotal = unHavedTotal;
    }

    public Integer getYearClass() {
        return yearClass;
    }

    public void setYearClass(Integer yearClass) {
        this.yearClass = yearClass;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public Integer getStayFee() {
        return stayFee;
    }

    public void setStayFee(Integer stayFee) {
        this.stayFee = stayFee;
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

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}

