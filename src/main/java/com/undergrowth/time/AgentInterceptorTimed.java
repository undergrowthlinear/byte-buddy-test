package com.undergrowth.time;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-14:05
 */
public class AgentInterceptorTimed {

    public void hello() {
        System.out.println("hello world");
    }

    public void helloSleep() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello world helloSleep");
    }

}