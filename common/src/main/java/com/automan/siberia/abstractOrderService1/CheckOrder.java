package com.automan.siberia.abstractOrderService1;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class CheckOrder {
    private Integer id;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CheckOrder(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
