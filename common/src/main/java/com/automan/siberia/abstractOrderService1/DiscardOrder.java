package com.automan.siberia.abstractOrderService1;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class DiscardOrder {

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

    public DiscardOrder(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
