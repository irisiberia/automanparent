package com.automan.bean;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author he.zhou
 * @date 2020/1/9
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventory implements SignedSupplierFillable, SkuTypeDictFillable {
    /**
     * 物流方案code
     */
    private String planCode;

    /**
     * 物流方案编码
     */
    private String planName;

    /**
     * 货主编码
     */
    private String ownerCode;

    /**
     * 货主
     */
    private String ownerName;

    /**
     * 机构代码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构类型
     */
    private Integer orgType;

    private String orgTypeName;

    /**
     * 商品code
     */
    private String skuCode;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品条码
     */
    private String skuBarCode;

    /**
     * 温度带类型
     */
    private Integer temperature;

    /**
     * 温度带名称
     */
    private String temperatureName;

    /**
     * 商品类型
     */
    private Integer skuType;

    /**
     * 商品类型
     */
    private String skuTypeName;

    /**
     * 后台分类名称
     */
    private String category;

    /**
     * 供应商编码
     */
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 销售规格
     */
    private String saleSpecUnit;

    /**
     * 销售单位
     */
    private String saleSpecExpression;

    /**
     * 仓位编码
     */
    private String positionCode;

    /**
     * 仓位名称
     */
    private String positionName;

    /**
     * 配货在途
     */
    private String shippingTransit;

    /**
     * 返仓在途
     */
    private String returnWarehouseTransit;

    /**
     * 配货预留
     */
    private String shippingLocked;

    /**
     * 残品
     */
    private String defectiveGoods;

    /**
     * 库存总量
     */
    private String sum;

    /**
     * 调出可用量
     */
    private String callOutAvailable;

    /**
     * 退供可用量
     */
    private String returnSupplierAvailable;

    /**
     * 退供预留
     */
    private String returnSupplierLocked;

    /**
     * 采购在途
     */
    private String purchaseTransit;

    /**
     * 调出预留
     */
    private String transitOutLocked;

    /**
     * 调出在途
     */
    private String transitOut;

    /**
     * 调入在途
     */
    private String transitIn;

    /**
     * 调拨预计到货
     */
    private String transitInExpected;

    /**
     * 待上架
     */
    private String goodWaitPutaway;

    /**
     * 加工预留
     */
    private String processingLocked;

    /**
     * 不可退供残品量
     */
    private String defectiveUnavailable;

    /**
     * 物流商品状态
     */
    private String logisticsStatusCode;

    private String logisticsStatusName;

    /**
     * 配送方式
     */
    private Integer deliveryType;

    private String deliveryTypeName;

    @Override
    public void fillSupplier(SupplierAo supplier) {
        this.supplierName = supplier.getName();
    }

    @Override
    public void fillSku(DictAo dictAo) {
        this.skuTypeName = dictAo.getName();
    }
}
