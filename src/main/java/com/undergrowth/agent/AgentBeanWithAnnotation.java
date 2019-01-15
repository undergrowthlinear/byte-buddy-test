package com.undergrowth.agent;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-10:55
 */
@ToString
public class AgentBeanWithAnnotation {

    private String name = "byte-buddy";
    private Integer age = 20;


    @Override
    public String toString() {
        return "AgentBean{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}