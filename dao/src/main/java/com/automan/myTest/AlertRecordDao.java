package com.automan.myTest;



import com.automan.bean.AlertRecord;
import com.automan.bean.ShopSkuSign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface AlertRecordDao {
    List<ShopSkuSign> getall();

  Integer insertSelective (List<AlertRecord> recordList);
}