package com.undergrowth.secure;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-10:13
 */
public class Service1 {

    @Secured(user = "guest")
    public void deleteDataBase() {
        // 运行敏感代码...
        System.out.println("dangerous deleteDataBase");
    }

}