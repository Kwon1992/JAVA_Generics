package com.company.kwonhyunwoo.Generics;

import java.util.ArrayList;
import java.util.List;

public class H_Unbounded_Wildcard {

    /**
     * 1.) WILDCARDS
     * <p>
     * The problems and the most important fact about generics
     * <p>
     * Collection<String> c1 = new ArrayList<>();
     * Collection<Object> c2 = c1  it is not valid !!!
     * String is an Object but a Collection<String> is not a Collection<Object> !!!
     * ==> "" Polymorphism이 적용되지 않는다. "" ~~ Wildcard가 생겨나게 된 이유.
     * <p>
     * <p>
     * So a List<Employee> is not a List<Person> even when the Employee class extends the Person class
     * """""THIS IS WHY WILDCARDS HAVE CAME TO BE"""""
     * <p>
     * -------------------------------------------------------------------------------------------------------------------
     * print(Collection<Object> c)
     *  for i in c
     *    print i
     * <p>
     * It is not generic in the sense that we can not print list of integers or list of doubles
     * or list of custom objects -> we have to cast them to Object before calling that method
     * <p>
     * COLLECTION OF OBJECT IS NOT A SUPERTYPE OF ALL KINDS OF COLLECTIONS !!!
     * The supertype of all kinds of collections -> wildcard
     * -------------------------------------------------------------------------------------------------------------------
     * <p>
     * -------------------------------------------------------------------------------------------------------------------
     * print(Collection<?> c)  "" ?(wildcard) 를 이용해 polymorphism 효과를 얻을 수 있다. ""
     *   for i in c:
     *     print i		we can do it we can print out whatever we want, but we cannot INSERT to that
     * collection whatever we want because we don't know what type will be passed in
     * Sole exception: NULL
     * <p>
     * """ c.add(new Object()) this will cause compile time error """
     * -------------------------------------------------------------------------------------------------------------------
     * <p>
     * <p>
     * -------------------------------------------------------------------------------------------------------------------
     * public interface Shape() {
     *   public void draw();
     * }
     *
     * class Circle extends Shape {
     *   draw:
     *     print "Drawing a circle...";
     * }
     *
     * class Rectangle extends Shape {
     *   draw:
     *     print "Drawing a rectangle...";
     * }
     *
     *
     * drawAll(List<Shape> l)
     *   for i in l
     *     i.draw()
     *
     * This is going to work ONLY FOR Shapes but not for classes that implements that given Shape interface
     * --> we cannot call this method(drawAll) on List<Rectangle> for example.
     * -------------------------------------------------------------------------------------------------------------------
     */

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Circle());
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Rectangle());
        shapes.add(new Rectangle());

        drawAll(shapes); // OK!!

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

//        drawAll(rectangles); // NO!!! (Rectangle이 Shape를 구현한 것임에도 불구하고 compile error -> wildcard의 등장.
    }


    public static void drawAll(List<Shape> list) {
        for (Shape shape : list) {
            shape.draw();
        }
    }
}

interface Shape {
    public void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle...");
    }
}

