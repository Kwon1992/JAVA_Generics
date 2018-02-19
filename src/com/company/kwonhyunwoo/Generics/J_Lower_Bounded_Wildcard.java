package com.company.kwonhyunwoo.Generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class J_Lower_Bounded_Wildcard {
    /**
     *
     * 3.) LOWER BOUNDED WILDCARDS  "? super T"

     You can specify an upper bound or a lower bound but ""cannot specify both"" 동시에 upper bound 와 lower bound 사용은 불가능.

     If you use '? super Integer' -> you can use any super type of Integer so Number or Object as well (( Integer가 Object와 Number의 sub type이기 때문에 ))

     List<? super Integer> l = new ArrayList<Integer>();
     List<? super Integer> l = new ArrayList<Object>();
     List<? super Integer> l = new ArrayList<Number>();

     Reading --> not guaranteed an Integer because it may be pointing to a Number
                 The only guarantee is an Object or a subclass of object
                 ~ you can cast to Object !!!

     Writing --> you cannot add Object or Serializable to a List<? super Number> even though
                 Number extends Object and Serializable

                 You can add Integer or Double or ... but using List<Double> would
                                                                                    be too restrictive !!!
     */


//    EditorFactor - ViewerFactor extends AbstractFactory
//    public static void make(List<? super AbstractFactory> list {}
    public static void show (List<? super Number> list){
        for (Object o : list) { // ?가 Number의 super인 것은 알지만 정확히 어떤 type을 가지게 될지 모르므로 모든 class의 super인 Object로 순회함.
            System.out.println(o);
        }

//        list.add(new Object()); // write할 때는 Number의 super type은 불가능하다. 왜냐하면 Number의 super type으로  A와 B가 있다고 할 때, 인자로 받은 list의 generic이 A일지 B일지 알 수가 없기 때문에 막아버린다.
        list.add(new Integer(1)); // Number의 subtype은 write 가능하다. 왜냐하면 Number의 Subtype은 Number가 지금까지 상속/구현한 클래스/인터페이스들에 대해 모두 상속받은 상태이므로 Number보다 super의 어떤 것이 와도 지장이 없기 때문.
    }

    // http://ohgyun.com/51 참고


    public static void main(String[] args) {
        List<Serializable> list = new ArrayList<>();
        list.add("Adam");
        list.add("John");
        list.add("Daniel");

        show(list); // Number이 Serializable을 implements 하므로 ? super Number에 해당하므로 가능하다.
    }


}
