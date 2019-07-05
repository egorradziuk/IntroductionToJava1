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

        char vowel = 'y';
        char digit = '2';
        char consonant = 'W';
        char symbol = '$';

        int dragonAge = 1000; // значение 0 допустимо, т.к. будет имметься ввиду рождение дракона

        int day = 29;
        int month = 2;
        int year = 2400;

        triangleOrSegment(ax, ay, bx, by, cx, cy); /* Определение, являются ли данные точки вершинами треугольника
                                             и если да, то является ли данный треугольник прямоугольным.*/
        partsOfDragon(dragonAge); // подсчёт голов и глаз дракона
        checkOnVowel(vowel); // проверка символа на гласную букву(является или нет)
        checkOnVowel2(digit); // аналогично предыдущему, но другими способами (включая следующие две строки)
        checkOnVowel3(consonant);
        checkOnVowel4(symbol);
        findNextDate(day, month, year); // поиск следующего дня от введёной даты
    }

    public static void triangleOrSegment(int ax, int ay, int bx, int by, int cx, int cy){

        double ab = Math.sqrt(Math.pow((ax-bx),2) + Math.pow((ay-by),2)); // отрезок от точки "a" до "b"
        double bc = Math.sqrt(Math.pow((bx-cx),2) + Math.pow((by-cy),2)); // отрезок от точки "b" до "c"
        double ac = Math.sqrt(Math.pow((ax-cx),2) + Math.pow((ay-cy),2)); // отрезок от точки "a" до "c"

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

    public static void partsOfDragon(int age){

        if(age >= 0) {
            int eyes = 6;
            int heads = 3;

            if (age > 300) {
                heads += 200 * 3 + 100 * 2 + age - 300;
                eyes = heads * 2;
            } else if (age > 200) {
                heads += 200 * 3 + age - 200;
                eyes = heads * 2;
            } else {
                heads += age * 3;
                eyes = heads * 2;
            }
            System.out.println("Number of heads " + heads + ".");
            System.out.println("Number of eyes " + eyes + ".");
        } else {
            System.out.println("The age isn't correct.");
        }
    }

    public static void checkOnVowel(char ch){
        if("A, E, I, O, U, Y".indexOf(Character.toString(ch).toUpperCase()) > -1){
            System.out.println("The letter is a vowel.");
        } else {
            System.out.println("Symbol is not a vowel letter.");
        }
    }

    public static void checkOnVowel2(char ch){
        String[] vowels = {"a","e","i","o","u","y"};
        int detectionFlag = 0;
        for(int i = 0; i < vowels.length; i++){
            if(vowels[i].equals(Character.toString(ch).toLowerCase())){
                detectionFlag = 1;
                System.out.println("The letter is a vowel.");
                break;
            }
        }
        if(detectionFlag == 0){
            System.out.println("Symbol is not a vowel letter.");
        }
    }

    public static void checkOnVowel3(char ch){
        String vowel = "The letter is a vowel.";
        switch(Character.toString(ch).toLowerCase()){
            case "a":
                System.out.println(vowel);
                break;
            case "e":
                System.out.println(vowel);
                break;
            case "i":
                System.out.println(vowel);
                break;
            case "o":
                System.out.println(vowel);
                break;
            case "u":
                System.out.println(vowel);
                break;
            case "y":
                System.out.println(vowel);
                break;
            default: System.out.println("Symbol is not a vowel letter.");
        }
    }

    public static void checkOnVowel4(char ch){
        String regex ="[aeiouyAEIOUY]";
        String result = Character.toString(ch).replaceAll(regex, "vowel");
        if(result.equals("vowel")){
            System.out.println("The letter is a vowel.");
        } else {
            System.out.println("Symbol is not a vowel letter.");
        }
    }

    public static void findNextDate(int day, int month, int year) {
        int nextDay = day + 1;
        int amountOfDays = 0; //number of days in a month

        if (month <= 12 && month > 0 && year > 0 && day > 0 && day <= 31) {
            switch (month) {
                case 1:
                    amountOfDays = 31;
                    break;
                case 2:
                    if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 4) == 0) && ((year % 100) == 0) && ((year % 400) == 0)) {
                        amountOfDays = 29;
                    } else {
                        amountOfDays = 28;
                    }
                    break;
                case 3:
                    amountOfDays = 31;
                    break;
                case 4:
                    amountOfDays = 30;
                    break;
                case 5:
                    amountOfDays = 31;
                    break;
                case 6:
                    amountOfDays = 30;
                    break;
                case 7:
                    amountOfDays = 31;
                    break;
                case 8:
                    amountOfDays = 31;
                    break;
                case 9:
                    amountOfDays = 30;
                    break;
                case 10:
                    amountOfDays = 31;
                    break;
                case 11:
                    amountOfDays = 30;
                    break;
                case 12:
                    amountOfDays = 31;
                    break;
            }

            if (amountOfDays > day && day > 0) {
                System.out.println("Next date: " + nextDay + "." + month + "." + year + "(format - dd.MM.yyyy)");
            } else if (amountOfDays == day && month < 12) {
                nextDay = 1;
                month += 1;
                System.out.println("Next date: " + nextDay + "." + month + "." + year + "(format - dd.MM.yyyy)");
            } else if (amountOfDays == day && month == 12) {
                nextDay = 1;
                month = 1;
                year += 1;
                System.out.println("Next date: " + nextDay + "." + month + "." + year + "(format - dd.MM.yyyy)");
            } else {
                System.out.println("The day was specified incorrectly, try again please.");
            }
        } else {
            System.out.println("The month, year or day were specified incorrectly, try again please.");
        }
    }


}