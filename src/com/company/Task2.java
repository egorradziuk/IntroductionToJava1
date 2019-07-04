package com.company;

public class Task2 {

    public static void main(String[] args) {
        //первая точка координат
        int ax = 1;
        int ay = 1;
        //вторая точка координат
        int bx = 3;
        int by = 3;
        //третья точка координат
        int cx = 5;
        int cy = 5;

        char ch = 'y';

        int day = 29;
        int month = 2;
        int year = -2400;

        triangle(ax, ay, bx, by, cx, cy); /* Определение, являются ли данные точки вершинами треугольника
                                             и если да, то является ли данный треугольник прямоугольным.*/
        dragon(1000); // подсчёт голов и глаз дракона
        checkSymbol(ch);
        calendar(day, month, year);
    }

    public static void triangle(int ax, int ay, int bx, int by, int cx, int cy){

        double ab = Math.sqrt(Math.pow((ax-bx),2) + Math.pow((ay-by),2));
        double bc = Math.sqrt(Math.pow((bx-cx),2) + Math.pow((by-cy),2));
        double ac = Math.sqrt(Math.pow((ax-cx),2) + Math.pow((ay-cy),2));
        System.out.println(ab+" | "+bc+" | "+ac);
        if((ab < (bc+ac)) && (bc < (ab+ac)) && (ac < (ab+bc))) {
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

    public static void checkSymbol(char ch){
        if("A, E, I, O, U, Y".indexOf(Character.toString(ch).toUpperCase()) > -1){
            System.out.println("The letter is a vowel.");
        } else if("B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Z".indexOf(Character.toString(ch).toUpperCase()) > -1){
            System.out.println("The letter is a consonant.");
        } else {
            System.out.println("Symbol is not a letter.");
        }
    }

    public static void calendar(int day, int month, int year) {
        int nextDay = day + 1;
        int days = 0; //number of days in a month
        if (year > 0) {
            if (month <= 12 && month > 0) {
                switch (month) {
                    case 1:
                        days = 31;
                        break;
                    case 2:
                        if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 4) == 0) && ((year % 100) == 0) && ((year % 400) == 0)) {
                            days = 29;
                        } else {
                            days = 28;
                        }
                        break;
                    case 3:
                        days = 31;
                        break;
                    case 4:
                        days = 30;
                        break;
                    case 5:
                        days = 31;
                        break;
                    case 6:
                        days = 30;
                        break;
                    case 7:
                        days = 31;
                        break;
                    case 8:
                        days = 31;
                        break;
                    case 9:
                        days = 30;
                        break;
                    case 10:
                        days = 31;
                        break;
                    case 11:
                        days = 30;
                        break;
                    case 12:
                        days = 31;
                        break;
                }

                if (days > day && day > 0) {
                    System.out.println("Next date: " + nextDay + "." + month + "." + year + "(format - dd.MM.yyyy)");
                } else if (days == day && month < 12) {
                    nextDay = 1;
                    month += 1;
                    System.out.println("Next date: " + nextDay + "." + month + "." + year + "(format - dd.MM.yyyy)");
                } else if (days == day && month == 12) {
                    nextDay = 1;
                    month = 1;
                    year += 1;
                    System.out.println("Next date: " + nextDay + ".0" + month + "." + year + "(format - dd.MM.yyyy)");
                } else {
                    System.out.println("The day was specified incorrectly, try again please.");
                }

            } else {
                System.out.println("The month was specified incorrectly, try again please.");
            }
        } else {
            System.out.println("The year was specified incorrectly, try again please.");
        }
    }


}
