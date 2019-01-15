package com.undergrowth.time;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-14:04
 */
public class TimingInterceptorMain {

    /**
     * -javaagent:E:\\code\\github\\bigdata\\byte-buddy-test\\target\\byte.buddy.test-1.0-SNAPSHOT.jar
     */
    public static void main(String[] args) throws InterruptedException {
        AgentInterceptorTimed agentInterceptorTimed = new AgentInterceptorTimed();
        agentInterceptorTimed.hello();
        agentInterceptorTimed.helloSleep();
    }

}