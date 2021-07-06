package com.automan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author he.zhou
 * @date 2020/1/9
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierAo {

    private String code;
    private String supplierCode;
    private String name;
    private String nameEn;

    private String shortName;
    private Integer type;
    private String companyCode;
    private String secondPartyCompanyCode;
    private String director;

}
