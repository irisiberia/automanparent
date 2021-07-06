package com.automan;

import com.automan.bean.Inventory;
import com.automan.root.utils.fill.FillableResolver;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: he.zhou
 * @Date: 2018-10-26
 */
@Service
public class AlertRecordService {

    @Resource
    private FillableResolver fillableResolver;

//    @Resource
//    private AlertRecordDao alertRecordDao;
//
//    public List<ShopSkuSign> getAll() {
//        return alertRecordDao.getall();
//    }
//
//    @Transactional
//    public Integer insert(List<AlertRecord> recordList) {
//
//        return alertRecordDao.insertSelective(recordList);
//
//
//    }

    @Transactional
    public List<Inventory> getInventory() {
        List<Inventory> inventories = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Inventory inventory = new Inventory();
            inventory.setSkuType(i);
            inventory.setSupplierCode("code" + i);
            inventories.add(inventory);
        }

        fillableResolver.multiResolve(inventories);

        return  inventories;
    }
}
