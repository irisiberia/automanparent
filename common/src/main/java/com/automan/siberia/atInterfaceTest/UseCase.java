package com.automan.siberia.atInterfaceTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: he.zhou
 * @Date: 2019-02-11
 */
@Target({ElementType.METHOD,ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public String id();

    public String description() default "no description";
}
