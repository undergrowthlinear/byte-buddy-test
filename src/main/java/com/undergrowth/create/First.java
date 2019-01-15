package com.undergrowth.create;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-11-16:15
 */
public interface First {
    default String qux() { return "FOO"; }
}