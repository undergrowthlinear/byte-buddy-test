package com.undergrowth.time;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-14:03
 */
public class TimerAgent {

    public static void premain(String arguments,
        Instrumentation instrumentation) {
        new AgentBuilder.Default()
            .type(ElementMatchers.nameEndsWith("Timed"))
            .transform((builder, type, classLoader, module) ->
                builder.method(ElementMatchers.any())
                    .intercept(MethodDelegation.to(TimingInterceptor.class))
            ).installOn(instrumentation);
    }

}