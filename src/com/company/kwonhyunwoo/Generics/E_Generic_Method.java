package com.company.kwonhyunwoo.Generics;

public class E_Generic_Method {

    public static void main(String[] args) {
        showItem("String");
        showItem(314);
        showItem(3.14);

        E_Generic_Method.<String>showItem("Test"); // <String>은 생략가능 ... parameter를 통해 추정가능하므로
        // E_Generic_Method.<String>showItem(334); -- compile error _ type !!

        Integer[] integers = {1,2,3,4,5,6,7,8,9,10};
        String[] names = {"Adam", "Brian", "Clark", "Dennis"};
        showArray(integers);
        showArray(names);
    }

    public static <T> void showItem(T t) {
        System.out.println("The item is: " + t.toString());
    }

    public static <T> void showArray(T[] items) {
        for (T item : items) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }
}
