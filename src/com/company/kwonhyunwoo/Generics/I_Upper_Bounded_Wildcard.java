package com.company.kwonhyunwoo.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I_Upper_Bounded_Wildcard {
    /**
     *
     * print(Collection<?> c)
     *   for i in c:
     *     print i
     *
     * 위 code의 문제 -> c에 대한 modification이 불가능 ( write / read... 왜냐하면 ?에 올 type이 정확히 뭔지 알 수가 없기 때문!! )
     * ==> BOUNDED WILDCARD의 등장.
     *
     * 2.) UPPER BOUNDED WILDCARDS	"? extends T" << extends >>

     We want to use the previous method in a generic form so for List<Rectangle> or for List<Circle>
     and want to make it work	// both of them extends Shape !!!

     drawAll(List<? extends Shape> list)

     Now this method accepts list of any subclass of Shape so
     we can use it for List<Circle> or List<Rectangle> as well

     Shape is the UPPER BOUND of the wildcard
     """"We can print BUT we CANNOT ADD for example Circle !!!""""

     이 메쏘드를 호출하는 시점을 생각해보자.
     인자로 List<Circle>이 들어올 수도 있다.
     그렇기 때문에 List<? extends Shape>로 선언된 변수에 Shape의 하위 클래스인 Rectangle을 넣을 수 없다.

     (왜냐하면 ?가 Shape를 상속한 무엇인가라는 것은 알게 되었지만 그 ?가 Circle이라는 보장이 없다.)
     (이와 같은 이유로 ?에 extends Shape가 없었다면 draw하는 것도 불가능하다. 왜냐하면 ?가 Shape를 구현한 무엇인가라는 보장이 없으므로.)

     list.add(new Circle()) compile time error !!! we can read but cannot add item because
     the ? extends Shape is ""UNKNOWN SUBTYPE"" of Shape
     Compiler does not know whether it is a Circle or a Rectangle

     + it is an upper bound

     List<? extends Number> l = new ArrayList<Integer>();
     List<? extends Number> l = new ArrayList<Double>();
     List<? extends Number> l = new ArrayList<Number>();
     All the subclasses are VALID here

     You can READ only List<""Number""> cannot read List<Double> because it may be a List<Integer>
     or List<Number> as well

     You can't add anything -> can't add double because it may be a List<Integer> !!!

     <<< 중요 포인트 >>>
     YOU CANT ADD ANY OBJECT TO A '? EXTENDS T' BECAUSE YOU CAN'T GUARANTEE WHAT KIND
     OF LIST IT IS REALLY POINTING TO
     *
     */
    public static void main(String[] args) {
        List<I_Shape> shapes = new ArrayList<>();
        shapes.add(new I_Circle());
        shapes.add(new I_Circle());
        shapes.add(new I_Circle());
        shapes.add(new I_Rectangle());
        shapes.add(new I_Rectangle());
        shapes.add(new I_Rectangle());

        drawAll(shapes); // OK!!
        System.out.println("********************************************");

        List<I_Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new I_Rectangle());
        rectangles.add(new I_Rectangle());
        rectangles.add(new I_Rectangle());
        rectangles.add(new I_Rectangle());

        drawAll(rectangles); // wildcard를 이용해서 I_Shape를 구현한 것도 받을 수 있게 됨.
        System.out.println("********************************************");

        sum(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        sum(Arrays.asList(1.1,2.2,3.3,4.4,5.5,6.1,7.2,8.3,9.4,10.5));
    }


    public static double sum(List<? extends  Number> list) { // using upper bound -> can read!! BUT NOT WRITE.... ~~ Lower bounded wildcard로 write 해결

        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        System.out.println(sum);
        return sum;
    }


    public static void drawAll(List<? extends I_Shape> list) {
        for (I_Shape i_shape : list) {
            i_shape.draw();
        }
    }
}

interface I_Shape {
    public void draw();
}

class I_Circle implements I_Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }
}

class I_Rectangle implements I_Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle...");
    }
}
