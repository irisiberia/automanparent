package com.automan.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.NewParentTypeMunger;

/**
 * @author he.zhou
 * @date 2019/9/29
 **/
@Data
@Builder
public class PersonOne extends Person {
    private int id;
    private String type;
    private String code;
    private String name;

    public PersonOne(int id) {
        System.out.println("232323");
        this.id = id;
    }

    public PersonOne(int id, String type, String code) {
        this.id = id;
        this.type = type;
        this.code = code;
    }

    public PersonOne(int id, String type, String code, String name) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.name = name;
    }

}
