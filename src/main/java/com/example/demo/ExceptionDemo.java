package com.example.demo;

public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            int a = 10;
            int b = 0;
            int result = a / b;

            System.out.println(result);
        } catch (Exception e) {
            System.out.println("发生异常了");
        } finally {
            System.out.println("finally执行了");
        }

        System.out.println("程序继续执行");
    }
}
