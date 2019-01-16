package com.undergrowth.secure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ${Description}
 *
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-10:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Secured {
    String user();
}
