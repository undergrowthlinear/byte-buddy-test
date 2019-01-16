package com.undergrowth.secure;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-10:13
 */
public class Service {

    @Secured(user = "ADMIN")
    public void doSensitiveAction() {
        // 运行敏感代码...
        System.out.println("dangerous doSensitiveAction");
    }

}