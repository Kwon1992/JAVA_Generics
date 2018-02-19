package com.company.kwonhyunwoo.Generics;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class G_Type_Inference {
    /**
     * - compiler's ability to look at each method invocation and corresponding declaration to
     * determine the type argument/arguments ( such as T ) that make the invocation applicable
     * <p>
     * - the inference algorithm determines: the types of the arguments
     * + the type that the result is being assigned or returned if available !!!
     * <p>
     * - the inference algorithm tries to """""FIND the MOST SPECIFIC type""""" that works with all of the arguments !!!
     * <p>
     * public <T> T getData(T t1, T t2){
     * return t2;
     * }
     * <p>
     * Serializable s = getData( "Hello world" , new ArrayList<String>() );   !!!
     * <p>
     * ==> "Hello world"는 String이고 ArrayList와 type이 다르다... 하지만 두 type 모두 공통적으로 "Serializable"을 구현하였으므로 T는 자동적으로 Serializable이 된다.
     * ==> String과 ArrayList 두 개 모두 받을 수 있도록 최대한 MOST SPECIFIC TYPE을 찾는다 (inference algorithm)
     * <p>
     * <p>
     * Because of the type inference algorithm, we can use instantiation like this:
     * <p>
     * List<String> list = new ArrayList<>();
     * <p>
     * Generic methods and type interference:
     * Enables us to invoke a generic method as you would an ordinary method,
     * without specifying a type between angle brackets
     */


    public static void main(String[] args) {
        List<Bucket<String>> list = new ArrayList<>(); // Bucket<T>를 element로 갖는 ArrayList 생성.

        G_Type_Inference.addStore("Adam", list);
        G_Type_Inference.<String>addStore("Dennis", list);
    }

    public static <T> void addStore(T t, List<Bucket<T>> list) {
        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list...");
    }
}

class Bucket<T> {
    private T item;

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}