package com.java.classloader;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {
        try {
            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit !"))
                    .make().saveIn(new File("C:\\scnoh\\dev\\study\\java\\classloader-sample\\target\\classes\\org\\example\\Masulsa.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
