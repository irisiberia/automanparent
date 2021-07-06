package com.automan.bean;

import java.io.Serializable;
import java.util.Date;

public class ShopSkuSign implements Serializable {

    private Long id;
    private Integer state;
    private Date createdTime;
    private Date updatedTime;

    private String shopCode;

    private String skuCode;

    public ShopSkuSign() {}

    public ShopSkuSign(String shopCode) {
        this.shopCode = shopCode;
    }

    public ShopSkuSign(Integer state) {
        this.setState(state);
    }

    public ShopSkuSign(String shopCode, String skuCode, Integer state) {
        this.shopCode = shopCode;
        this.skuCode = skuCode;
        this.setState(state);
    }

    public ShopSkuSign(String shopCode, Date updatedTime) {
        this.shopCode = shopCode;
        this.setUpdatedTime(updatedTime);
    }

    private ShopSkuSign(Builder builder) {
        setId(builder.id);
        setState(builder.state);
        setCreatedTime(builder.createdTime);
        setUpdatedTime(builder.updatedTime);
        setShopCode(builder.shopCode);
        setSkuCode(builder.skuCode);
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }


    public static final class Builder {
        private Long id;
        private Integer state;
        private Date createdTime;
        private Date updatedTime;
        private String shopCode;
        private String skuCode;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder state(Integer val) {
            state = val;
            return this;
        }

        public Builder createdTime(Date val) {
            createdTime = val;
            return this;
        }

        public Builder updatedTime(Date val) {
            updatedTime = val;
            return this;
        }

        public Builder shopCode(String val) {
            shopCode = val;
            return this;
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public ShopSkuSign build() {
            return new ShopSkuSign(this);
        }
    }
}