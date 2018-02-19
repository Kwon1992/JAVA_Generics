package com.company.kwonhyunwoo.Generics;


public class D_Using_Multiple_Type_Parameters {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello !", 101);
        System.out.println(pair);
    }
}

class Pair<K, V> { // multiple type parameters.
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key.toString() + " : " + value.toString();
    }
}