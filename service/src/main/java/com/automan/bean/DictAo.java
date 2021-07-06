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
public class DictAo {

    private String name;
    private String value;
    private int order;
    private Integer type;
    private String ext;

}
