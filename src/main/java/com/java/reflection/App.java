package com.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("com.java.reflection.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("myBook");

        System.out.println(book);

        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null)); // static 이니까 그냥 가져와
        a.set(null, "AA");
        System.out.println(a.get(null)); // static 이니까 그냥 가져와
    }
}
