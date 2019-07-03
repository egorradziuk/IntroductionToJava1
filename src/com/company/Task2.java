package com.company;

public class Task2 {

    public static void main(String[] args) {
        //первая точка координат
        int ax = 1;
        int ay = 0;
        //вторая точка координат
        int bx = 3;
        int by = 0;
        //третья точка координат
        int cx = 5;
        int cy = 1;

        triangle(ax, ay, bx, by, cx, cy); /* Определение, являются ли данные точки вершинами треугольника
                                             и если да, то является ли данный треугольник прямоугольным.*/
        dragon(1000); // подсчёт голов и глаз дракона

    }

    public static void triangle(int ax, int ay, int bx, int by, int cx, int cy){

        double ab = Math.sqrt(Math.abs(Math.pow((ax-bx),2) + Math.pow((ay-by),2)));
        double bc = Math.sqrt(Math.abs(Math.pow((bx-cx),2) + Math.pow((by-cy),2)));
        double ac = Math.sqrt(Math.abs(Math.pow((ax-cx),2) + Math.pow((ay-cy),2)));

        if((ax!=bx && ax!=cx && bx!=cx) && (ay!=by && ay!=cy && by!=cy) /*&& (...)*/) { // не хватает ещё одного условия
            if (ab == (Math.sqrt(Math.pow(bc,2) + Math.pow(ac,2)))
                    || bc == (Math.sqrt(Math.pow(ab,2) + Math.pow(ac,2)))
                    || ac == (Math.sqrt(Math.pow(ab,2) + Math.pow(bc,2)))) {
                    System.out.println("The coordinate points are vertices of a triangle. This is right triangle.");
            } else {
                System.out.println("The coordinate points are vertices of a triangle. This is not right triangle.");
            }
        } else {
            System.out.println("The coordinate points are not vertices of a triangle.");
        }
    }

    public static void dragon(int age){

        int eyes = 6;
        int heads = 3;

        if(age > 300){
            heads += 200 * 3 + 100 * 2 + age - 300;
            eyes = heads * 2;
        } else if(age > 200){
            heads += 200 * 3 + age - 200;
            eyes = heads * 2;
        } else {
            heads += age * 3;
            eyes = heads * 2;
        }
        System.out.println("Number of heads "+heads+".");
        System.out.println("Number of eyes "+eyes+".");
    }

}
