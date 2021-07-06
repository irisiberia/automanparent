package com.automan.fill;

import com.automan.bean.SignedSupplierFillable;
import com.automan.bean.SupplierAo;
import com.automan.root.utils.fill.Filler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author he.zhou
 * @date 2020/1/9
 **/
@Component
public class SignedSupplierFiller implements Filler<SignedSupplierFillable, String, SupplierAo> {
    @Override
    public String getBeanKey(SignedSupplierFillable bean) {
        return bean.getSupplierCode();
    }

    @Override
    public Map<String, SupplierAo> prepareData(Set<String> keys) {

        return keys.stream().map(ar -> {
            SupplierAo supplierAo = new SupplierAo();
            supplierAo.setCode(ar);
            supplierAo.setName("测试" +ar);
            return supplierAo;
        }).collect(Collectors.toMap(SupplierAo::getCode, o -> o));
    }

    @Override
    public void fill(SignedSupplierFillable bean, SupplierAo data) {
        bean.fillSupplier(data);
    }
}
