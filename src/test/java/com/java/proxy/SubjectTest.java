package com.java.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class SubjectTest {

    Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader()
            , new Class[]{ Subject.class }
            , new InvocationHandler() {
                Subject subject = new RealSubject();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    if (method.getName().equals("result")) {
                        System.out.println("pre");
                        Object invoke = method.invoke(subject, args);
                        System.out.println("post");

                        return invoke;
                    }

                    return method.invoke(subject, args);
                }
            });

    @Test
    void proxy () {
        subject.result("dynamic proxy");
    }

    @Test
    void proxyClass () throws Exception {
        Class<? extends RealSubject> proxyClass = new ByteBuddy().subclass(RealSubject.class)
                .method(named("result")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    RealSubject realSubject = new RealSubject();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("class prev");
                        Object invoke = method.invoke(realSubject, args);
                        System.out.println("class post");

                        return invoke;
                    }
                }))
                .make().load(RealSubject.class.getClassLoader()).getLoaded();

        RealSubject realSubject = proxyClass.getConstructor(null).newInstance();

        realSubject.result("proxy class");
    }

}
