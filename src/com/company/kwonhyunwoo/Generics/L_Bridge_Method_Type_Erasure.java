package com.company.kwonhyunwoo.Generics;

public class L_Bridge_Method_Type_Erasure {
    /**
     * Bridge methods are usually occur when inheritance is used
     * 	~ it is an additional method added during type erasure in order to avoid
     * 			ambiguous situations !!!
     *
     */


    public static void main(String[] args) {

    }
}

// ------------- BEFORE TYPE ERASURE ---------------- << Programmer's Perspective >>

//class Node<T> {
//
//	private T data;
//
//	public Node(T data) {
//		this.data = data;
//	}
//
//	public void setData(T data) {
//		this.data = data;
//	}
//}
//
//class MyNode extends Node<Integer> {
//
//	public MyNode(Integer data) {
//		super(data);
//	}
//
//	public void setData(Integer data) {
//		super.setData(data);
//	}
//}

// --------------------  AFTER TYPE ERASURE -----------------

//class Node {
//
//	private Object data;
//
//	public Node(Object data) {
//		this.data = data;
//	}
//
//	public void setData(Object data) {
//		this.data = data;
//	}
//}
//
//class MyNode extends Node {
//
//	public MyNode(Integer data) {
//		super(data);
//	}
//
//	public void setData(Integer data) {
//		super.setData(data);
//	}
//}

// -------------------------------------------------------------

// as you can see after type erasure there is a Problem :  the setData() method arguments do ""NOT MATCH !!"""
//                                                         (super에서는 Object를 parameter로 받는데 Child는 Integer를 parameter로 받아서 기존 Object에 더해 하나의 method가 overloading 되는 모습)
//
//		Java compiler is going to create an additional  method in order to solve this problem --> this is the ""bridge method""

//class MyNode extends Node {
//
//	public MyNode(Integer data) {
//		super(data);
//	}
//
//	public void setData(Object o) {
//		setData((Integer) o);						<----- THIS IS THE BRIDGE METHOD !!! ((JAVA COMPILER에 의해 자동적으로 생기는 bridge method))
//	}
//
//	public void setData(Integer data) {
//		super.setData(data);
//	}
//}