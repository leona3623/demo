package com.example.demo;

import java.util.Scanner;

public class DivisionDemo {

    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个数字：");
        int a = scanner.nextInt();

        System.out.print("请输入第二个数字：");
        int b = scanner.nextInt();

        // 在这里使用 try-catch 调用 divide()
        try {
            int ans = divide(a, b);
            System.out.println("结果：" + ans);
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }
    }
}
