package com.company.kwonhyunwoo.Generics;

public class B_No_Generics {


    // No Generics..
    public static void add(int num1, int num2) {
        System.out.println("The sum is: " + (num1 + num2));
    }

    public static void add(double num1, double num2) {
        System.out.println("The sum is: " + (num1 + num2));
    }

    public static void add(float num1, float num2) {
        System.out.println("The sum is: " + (num1 + num2));
    }

    public static void main(String[] args) {
        add(1,3);
        add(1.1,2.5);
        add(1.59f,2.65f);
    }

    // Generic을 사용하면 이런 같은 모양의 code의 method들을 하나로 나타낼 수 있다.

}
