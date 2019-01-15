package com.undergrowth;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.takesArguments;

import com.undergrowth.create.First;
import com.undergrowth.create.Foo;
import com.undergrowth.create.Second;
import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.DefaultMethodCall;
import net.bytebuddy.implementation.FixedValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-17:53
 */
public class CreateByteCodeSomeTest {

    DynamicType.Unloaded unloadedDynamicType;

    @Before
    public void before() {
        unloadedDynamicType = new ByteBuddy(ClassFileVersion.JAVA_V8)
            .subclass(Object.class)
            .name("test.Test")
            .implement(First.class)
            .implement(Second.class)
            .method(named("qux")).intercept(DefaultMethodCall.prioritize(First.class))
            .make();
    }

    @Test
    public void implemetentTest() throws IOException {
        unloadedDynamicType.saveIn(new File("./target"));
    }

    @Test
    public void implemetent2Test() throws IOException, IllegalAccessException, InstantiationException {
        Class<First> cls = unloadedDynamicType.load(getClass().getClassLoader()).getLoaded();
        String str = cls.newInstance().qux();
        System.out.println(str);
        Assert.assertEquals("bar方法改写错误", str, "FOO");
    }

    @Test
    public void createMultiTest() throws IllegalAccessException, InstantiationException {
        Foo dynamicFoo = new ByteBuddy()
            .subclass(Foo.class)
            .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
            .method(named("foo")).intercept(FixedValue.value("Two!"))
            .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .newInstance();
        System.out.println(dynamicFoo.bar());
        System.out.println(dynamicFoo.foo());
        System.out.println(dynamicFoo.foo("a"));
        Assert.assertEquals("bar方法改写错误", dynamicFoo.bar(), "One!");
        Assert.assertEquals("foo方法改写错误", dynamicFoo.foo(), "Two!");
        Assert.assertEquals("foo方法改写错误", dynamicFoo.foo("a"), "Three!");
    }



}