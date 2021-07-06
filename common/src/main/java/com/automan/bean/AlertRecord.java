package com.automan.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

//@Component
//@Scope("prototype")
@Component("dsds")
public class AlertRecord implements Serializable {

//    @Autowired
//    private Expire expire;

    public AlertRecord(Expire expire) {
//        this.expire = expire;
    }

    private Integer id;

    private String shopCode;

    private String shopName;

    private String macAddress;

    private String alertName;

    private Float valueMin;

    private Float valueMax;

    private Float alertValue;

    private Date startTime;

    private Date endTime;

    private long duration;

    private String remark;

    private Integer isNotice;

    private Integer exceptionType;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress == null ? null : macAddress.trim();
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName == null ? null : alertName.trim();
    }

    public Float getValueMin() {
        return valueMin;
    }

    public void setValueMin(Float valueMin) {
        this.valueMin = valueMin;
    }

    public Float getValueMax() {
        return valueMax;
    }

    public void setValueMax(Float valueMax) {
        this.valueMax = valueMax;
    }

    public Float getAlertValue() {
        return alertValue;
    }

    public void setAlertValue(Float alertValue) {
        this.alertValue = alertValue;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Integer isNotice) {
        this.isNotice = isNotice;
    }

    public Integer getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public AlertRecord() {
    }

    public AlertRecord(Builder builder) {
        setId(builder.id);
        setShopCode(builder.shopCode);
        setShopName(builder.shopName);
        setMacAddress(builder.macAddress);
        setAlertName(builder.alertName);
        setValueMin(builder.valueMin);
        setValueMax(builder.valueMax);
        setAlertValue(builder.alertValue);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setDuration(builder.duration);
        setRemark(builder.remark);
        setIsNotice(builder.isNotice);
        setExceptionType(builder.exceptionType);
        setCreateTime(builder.createTime);
        setUpdateTime(builder.updateTime);
    }

    public static final class Builder {
        private Integer id;
        private String shopCode;
        private String shopName;
        private String macAddress;
        private String alertName;
        private Float valueMin;
        private Float valueMax;
        private Float alertValue;
        private Date startTime;
        private Date endTime;
        private long duration;
        private String remark;
        private Integer isNotice;
        private Integer exceptionType;
        private Date createTime;
        private Date updateTime;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder shopCode(String val) {
            shopCode = val;
            return this;
        }

        public Builder shopName(String val) {
            shopName = val;
            return this;
        }

        public Builder macAddress(String val) {
            macAddress = val;
            return this;
        }

        public Builder alertName(String val) {
            alertName = val;
            return this;
        }

        public Builder valueMin(Float val) {
            valueMin = val;
            return this;
        }

        public Builder valueMax(Float val) {
            valueMax = val;
            return this;
        }

        public Builder alertValue(Float val) {
            alertValue = val;
            return this;
        }

        public Builder startTime(Date val) {
            startTime = val;
            return this;
        }

        public Builder endTime(Date val) {
            endTime = val;
            return this;
        }

        public Builder duration(long val) {
            duration = val;
            return this;
        }

        public Builder remark(String val) {
            remark = val;
            return this;
        }

        public Builder isNotice(Integer val) {
            isNotice = val;
            return this;
        }

        public Builder exceptionType(Integer val) {
            exceptionType = val;
            return this;
        }

        public Builder createTime(Date val) {
            createTime = val;
            return this;
        }

        public Builder updateTime(Date val) {
            updateTime = val;
            return this;
        }

        public AlertRecord build() {
            return new AlertRecord(this);
        }

    }

}