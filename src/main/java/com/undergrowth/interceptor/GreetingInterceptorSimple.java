package com.undergrowth.interceptor;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-11:50
 */
public class GreetingInterceptorSimple {
    public Object greet(Object argument) {
        return "Hello from " + argument;
    }
}