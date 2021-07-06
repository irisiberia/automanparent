package com.automan.siberia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/10/12
 **/
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Arrange {
    private String id;
    private String code;
}
