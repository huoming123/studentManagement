package com.design.studentManagement.pojo;

import java.io.Serializable;

/**
 * (Profession)实体类
 *
 * @author makejava
 * @since 2022-08-05 10:45:22
 */
public class Profession implements Serializable {
    private static final long serialVersionUID = -89513042067126838L;
    
    private Integer id;
    /**
     * 专业名称
     */
    private String name;
    /**
     * 学费
     */
    private Integer  tuition;
    /**
     * 住宿费
     */
    private Integer  stayFee;
    /**
     * 总计
     */
    private Integer  total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
