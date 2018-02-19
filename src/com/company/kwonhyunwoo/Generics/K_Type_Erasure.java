package com.company.kwonhyunwoo.Generics;

import java.io.Serializable;

public class K_Type_Erasure {
    /**
     * In order to implement generics, Java uses "type erasure" (type이 사라진다는 의미)
     * 		This is how generic Java code is handled !!!
     *
     * 		- replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded
     * 				So the final bytecode will contain "plain java objects/classes"
     *
     * 		- uses type casts if necessary
     *
     * 		- sometimes it generates extra methods: the so called bridge methods
     * 				in order to maintain polymorphism with generics types
     *
     * 		In the bytecode the following code is equivalent
     *
     * 			List<Integer> list = new ArrayList<>();
     * 			list.add(3);
     * 			Integer num = list.get(0);
     * 			------------>> Type Erasure <<------------
     * 			List list = new ArrayList(); (Object List)
     * 			list.add(3); (Add Integer which is the child of Object)
     * 			Integer num = (Integer) list.get(0)
     */

}

/** ------------------------------------------------------------------------ */

class FirstStore<T> { //generic class
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// 위의 클래스는 다음과 같이 변한다 (Type Erasure)

class FirstStore_ {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

/** ------------------------------------------------------------------------ */

class SecondStore<T extends Serializable> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// 위의 클래스는 다음과 같이 변한다.

class SecondStore_ {
    private Serializable item;

    public Serializable getItem() {
        return item;
    }

    public void setItem(Serializable item) {
        this.item = item;
    }
}
