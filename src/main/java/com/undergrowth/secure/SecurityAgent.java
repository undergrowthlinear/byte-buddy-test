package com.undergrowth.secure;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-11:01
 */
public class SecurityAgent {

    public static void premain(String arg, Instrumentation inst) {
        new AgentBuilder.Default()
            .type(ElementMatchers.any())
            .transform((builder, type, classLoader, module) -> builder
                .method(ElementMatchers.isAnnotatedWith(Secured.class))
                .intercept(MethodDelegation.to(new SecurityInterceptor())
                    .andThen(SuperMethodCall.INSTANCE)))
            .installOn(inst);
    }

}