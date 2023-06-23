package com.example.onlinerent.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 小区
 * @TableName residence
 */
public class Residence implements Serializable {
    /**
     * 编号
     */
    private Integer rid;

    /**
     * 小区名称
     */
    private String name;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    private String link;

    /**
     * 联系电话
     */
    private String linkPhone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 0 表示删除；1 表示未删除
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 编号
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 小区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 小区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 联系人
     */
    public String getLink() {
        return link;
    }

    /**
     * 联系人
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 联系电话
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 联系电话
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 0 表示删除；1 表示未删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 0 表示删除；1 表示未删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Residence other = (Residence) that;
        return (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", name=").append(name);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", link=").append(link);
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}