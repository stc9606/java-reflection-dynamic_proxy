package com.java.proxy;

public class RealSubject implements Subject {

    @Override
    public void result(String message) {
        System.out.println("message : " + message);
    }
}
