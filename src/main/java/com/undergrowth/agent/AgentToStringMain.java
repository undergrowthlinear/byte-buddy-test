package com.undergrowth.agent;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-11:15
 */
public class AgentToStringMain {

    /**
     * -javaagent:E:\\code\\github\\bigdata\\byte-buddy-test\\target\\byte.buddy.test-1.0-SNAPSHOT.jar
     * @param args
     */
    public static void main(String[] args) {
        AgentBean agentBean=new AgentBean();
        AgentBeanWithAnnotation agentBeanWithAnnotation=new AgentBeanWithAnnotation();
        System.out.println(agentBean);
        System.out.println(agentBeanWithAnnotation);
    }

}