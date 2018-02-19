package com.company.kwonhyunwoo.Generics;


public class C_Generics_First {
    public static void main(String[] args) {

        Store store = new Store();
        store.setStoreItem("Hi");
        String item = (String) store.getItem(); // 명시적 형변환이 필요함..
        System.out.println(item + " << store");

        GenericStore<String> stringStore = new GenericStore<>();
        stringStore.setStoreItem("Hi");
        String item2 = stringStore.getItem(); // 명시적 형변환 필요가 없음.
        System.out.println(item2 + " << stringStore");

        GenericStore<Integer> integerStore = new GenericStore<>();
        integerStore.setStoreItem(45);
        Integer item3 = integerStore.getItem();
        System.out.println(item3 + " << integerStore");
    }
}


class Store {
    private Object item;

    public void setStoreItem(String item) {
        this.item = item;
    }

    public Object getItem() {
        return this.item;
    }
}

class GenericStore<T> {
    private T item;

    public void setStoreItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }
}