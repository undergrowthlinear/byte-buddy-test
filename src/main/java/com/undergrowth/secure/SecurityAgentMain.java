package com.undergrowth.secure;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-11:05
 */
public class SecurityAgentMain {

    /**
     * -javaagent:E:\\code\\github\\bigdata\\byte-buddy-test\\target\\byte.buddy.test-1.0-SNAPSHOT.jar
     */
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        service.doSensitiveAction();
        Service1 service1=new Service1();
        service1.deleteDataBase();
    }

}