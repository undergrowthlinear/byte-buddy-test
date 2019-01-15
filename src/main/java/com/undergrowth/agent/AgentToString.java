package com.undergrowth.agent;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-10:45
 */
public class AgentToString {
    public static void premain(String arguments, Instrumentation instrumentation) {
        new AgentBuilder.Default()
            .type(ElementMatchers.isAnnotatedWith(ToString.class))
            .transform(new AgentBuilder.Transformer() {
                @Override
                public Builder<?> transform(Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
                    return builder.method(named("toString"))
                        .intercept(FixedValue.value("transformed"));
                }
            }).installOn(instrumentation);
    }
}