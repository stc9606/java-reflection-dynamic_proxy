package com.java.proxy;

public class SubjectProxy implements Subject {

    Subject subject;

    public SubjectProxy (Subject subject) {
        this.subject = subject;
    }

    @Override
    public void result(String message) {
        System.out.println("prev");
        subject.result(message);
        System.out.println("post");
    }
}
