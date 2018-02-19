package com.company.kwonhyunwoo.Generics;

public class F_Bounded_Type_Parameters {

	/**
	 * There may be times when you want to restrict the types that can be used 
	 * as type arguments in a parameterized type. For example, a method that operates
	 * 	 on numbers might only want to accept instances of Number or its subclasses. 
	 * This is what bounded type parameters are for.
	 * 
	 * 	bounded type parameters allow you to invoke methods defined in the bounds
	 * 		For example extends Comparable -> we can use compareTo() method to compare items !!!
	 * 
	 * Type parameter can have multiple bounds:
				<T extends B1 & B2 & B3>
				
				Important for algorithms !!!
				
						for example we cant use ' > ; < ; == ' operators on T we have to make sure they are numbers
							or compare two strings we have to make sure they are strings !!!
	 * 
	 */


//	class Person implements Comparable<Person> {
//        @Override
//        public int compareTo(Person o) {
//            return 0;
//        }
//    }
//    Comparable 구현 방식...

	public static <T extends Comparable<T>> T calculateMin(T t1, T t2) { 	    // going to accept everything that implements Comparable<T> Interface
        if (t1.compareTo(t2) < 0) return t1; // compareTo method는 Comparable interface에 구현하도록 되어있는 함수이다. ( a.compareTo(b) 에서 a가 b보다 크면 양수 / a가 b보다 작으면 음수 / 같으면 0 반환 )
        return t2;
    }

	public static void main(String[] args) {
        System.out.println(calculateMin('v', 'h'));
        System.out.println(calculateMin("Joe", "Adam"));
        System.out.println(calculateMin(14, 22));
    }
}
