package com.example.onlinerent.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 房间表
 * @TableName room
 */
public class Room implements Serializable {
    /**
     * 编号
     */
    private Integer roomId;

    /**
     * 所属小区
     */
    private Integer rid;

    /**
     * 楼栋名称
     */
    private String buildingNo;

    /**
     * 单元号
     */
    private String unitNo;

    /**
     * 房间号
     */
    private String roomNo;

    /**
     * 户型
     */
    private String roomType;

    /**
     * 房间朝向
     */
    private String roomDirection;

    /**
     * 租金
     */
    private Double rentFee;

    /**
     * 物业费
     */
    private Double propertyFee;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 编号
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 所属小区
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 所属小区
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 楼栋名称
     */
    public String getBuildingNo() {
        return buildingNo;
    }

    /**
     * 楼栋名称
     */
    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    /**
     * 单元号
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 单元号
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * 房间号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 房间号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 户型
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * 户型
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * 房间朝向
     */
    public String getRoomDirection() {
        return roomDirection;
    }

    /**
     * 房间朝向
     */
    public void setRoomDirection(String roomDirection) {
        this.roomDirection = roomDirection;
    }

    /**
     * 租金
     */
    public Double getRentFee() {
        return rentFee;
    }

    /**
     * 租金
     */
    public void setRentFee(Double rentFee) {
        this.rentFee = rentFee;
    }

    /**
     * 物业费
     */
    public Double getPropertyFee() {
        return propertyFee;
    }

    /**
     * 物业费
     */
    public void setPropertyFee(Double propertyFee) {
        this.propertyFee = propertyFee;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
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
     * 
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 
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
        Room other = (Room) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getBuildingNo() == null ? other.getBuildingNo() == null : this.getBuildingNo().equals(other.getBuildingNo()))
            && (this.getUnitNo() == null ? other.getUnitNo() == null : this.getUnitNo().equals(other.getUnitNo()))
            && (this.getRoomNo() == null ? other.getRoomNo() == null : this.getRoomNo().equals(other.getRoomNo()))
            && (this.getRoomType() == null ? other.getRoomType() == null : this.getRoomType().equals(other.getRoomType()))
            && (this.getRoomDirection() == null ? other.getRoomDirection() == null : this.getRoomDirection().equals(other.getRoomDirection()))
            && (this.getRentFee() == null ? other.getRentFee() == null : this.getRentFee().equals(other.getRentFee()))
            && (this.getPropertyFee() == null ? other.getPropertyFee() == null : this.getPropertyFee().equals(other.getPropertyFee()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getBuildingNo() == null) ? 0 : getBuildingNo().hashCode());
        result = prime * result + ((getUnitNo() == null) ? 0 : getUnitNo().hashCode());
        result = prime * result + ((getRoomNo() == null) ? 0 : getRoomNo().hashCode());
        result = prime * result + ((getRoomType() == null) ? 0 : getRoomType().hashCode());
        result = prime * result + ((getRoomDirection() == null) ? 0 : getRoomDirection().hashCode());
        result = prime * result + ((getRentFee() == null) ? 0 : getRentFee().hashCode());
        result = prime * result + ((getPropertyFee() == null) ? 0 : getPropertyFee().hashCode());
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
        sb.append(", roomId=").append(roomId);
        sb.append(", rid=").append(rid);
        sb.append(", buildingNo=").append(buildingNo);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", roomNo=").append(roomNo);
        sb.append(", roomType=").append(roomType);
        sb.append(", roomDirection=").append(roomDirection);
        sb.append(", rentFee=").append(rentFee);
        sb.append(", propertyFee=").append(propertyFee);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}