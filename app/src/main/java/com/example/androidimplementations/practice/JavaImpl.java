package com.example.androidimplementations.practice;

public class JavaImpl implements JavaInterface {
    @Override
    public void method1() {
        System.out.println("This is an implementation of method1.");
    }

//    public static void main(String[] args) {
//        JavaImpl impl = new JavaImpl();
//        impl.method1(); // Calls the implemented method
//        impl.method2(); // Calls the default method from the interface
//        JavaInterface.method3(); // Calls the static method from the interface
//    }
}
