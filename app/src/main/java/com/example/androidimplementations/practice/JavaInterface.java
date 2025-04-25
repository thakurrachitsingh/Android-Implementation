package com.example.androidimplementations.practice;

public interface JavaInterface {
    int a = 0;
    int b = 1;
    abstract void method1();
    default void method2() {
        System.out.println("This is a default method in an interface.");
    }
    static void method3() {
        System.out.println("This is a static method in an interface.");
    }
}
