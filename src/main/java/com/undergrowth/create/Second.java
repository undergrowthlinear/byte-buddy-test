package com.undergrowth.create;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-11-16:16
 */
public interface Second {
    default String qux() { return "BAR"; }
}