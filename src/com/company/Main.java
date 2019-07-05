package com.company;


public class Main {

    public static void main(String[] args) {

        double a = 2.001;
        double b = 2.0012;
        double c = 2.001;

        double kilogram = 920.157; // масса динозавра в килограммах

        double outerRadius = 5.5; // внешний радиус кольца
        double innerRadius = 3.7; // внутренний радиус кольца

        int fourDigitNumber = 9531;

        int sixDigitNumber = 123456;

        int sevenDigitNumber = 4596846;

        int d = 1234;
        int e = -56789;

        checkNumbers(a,b,c); // проверка чисел на равенство
        massConverter(kilogram); // конвертация массы динозавра
        ringArea(outerRadius, innerRadius); // нахождение площади кольца
        sequenceCheck(fourDigitNumber); // проверка чисел четырёхзначного числа на образование возрастающей (убывающей) последовательности
        arithmeticAndGeometricMean(sixDigitNumber); // расчёт арифметическое и геометрическое среднее цифр шестизначного числа
        reverseNumber(sevenDigitNumber); // выполняет реверсию семизначного числа
        changeValues(d,e); // выполняет замену содержимого двух целочисленных переменных "d" и "e"
    }

    public static void checkNumbers(double a, double b, double c) {
        if (a == b && b == c) {
            System.out.println("The numbers are the same.");
        } else if(a == b || b == c || a == c){
            System.out.println("Only two of three numbers are the same.");
        } else {
            System.out.println("The numbers are the different.");
        }
    }

    public static void massConverter(double kilogram){
        if(kilogram > 0) {
            double milligrams = kilogram * 1000_000;
            double grams = kilogram * 1000;
            double tonnes = kilogram / 1000;
            System.out.println("Mass dinosaur: milligram = " + milligrams + ", gram = " + grams + ", tonnes = " + tonnes);
        } else {
            System.out.println("The mass can't be negative.");
        }
    }

    public static void  ringArea(double outerRadius, double innerRadius){

        double area;

        if(outerRadius > innerRadius && innerRadius > 0){
            area = Math.PI * (Math.pow(outerRadius,2) - Math.pow(innerRadius,2));
            System.out.println("ring area = "+area);
        } else {
            System.out.println("The inner radius must be less than the outer radius." +
                    " And the radius must be greater than zero.");
        }
    }

    public static void sequenceCheck(int number){
        String s = String.valueOf(number);
        if(s.length()==4) {
            int firstDigit = 0;
            int secondDigit = 0;
            int thirdDigit = 0;
            int fourthDigit = 0;

            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    fourthDigit = number % 10;
                    number = number / 10;
                } else if (i == 1) {
                    thirdDigit = number % 10;
                    number = number / 10;
                } else if (i == 2) {
                    secondDigit = number % 10;
                    number = number / 10;
                } else if (i == 3) {
                    firstDigit = number % 10;
                }
            }

            if (firstDigit < secondDigit && secondDigit < thirdDigit && thirdDigit < fourthDigit) {
                System.out.println("The digits of the number " + s + " form an increasing sequence.");
            } else if (firstDigit > secondDigit && secondDigit > thirdDigit && thirdDigit > fourthDigit) {
                System.out.println("The digits of the number " + s + " form a decreasing sequence.");
            } else {
                System.out.println("The digits of the number " + s + " do not form decreasing sequence and increasing sequence.");
            }
        } else {
            System.out.println("The number entered is not a four-digit.");
        }
    }

    public static void arithmeticAndGeometricMean(int number){

        String s = String.valueOf(number);

        if(s.length() == 6) {

            double sum = 0;

            for (int i = 0; i < 6; i++) {
                sum += number % 10;
                number /= 10;
            }

            double arithmeticMean = sum / s.length();
            double geometricMean = Math.pow(sum, 1.0/s.length());

            System.out.println("The arithmetic mean of six-digit number "+s+" = "+arithmeticMean);
            System.out.println("The geometric mean of six-digit number "+s+" = "+geometricMean);
        } else {
            System.out.println("The entered number is not a six-digit.");
        }

    }

    public static void reverseNumber(int number){

        String s = String.valueOf(number);
        if(s.length() == 7) {

            int newNumber = 0;

            for (int i = 0; i < s.length(); i++) {
                newNumber += number % 10;
                number /= 10;
                if ((s.length() - i) != 1) {
                    newNumber *= 10;
                }
            }
            System.out.println("Reversal of a seven-digit number "+s+" = "+newNumber);
        } else {
            System.out.println("The entered number is not seven-digit.");
        }
    }

    public static void changeValues(int a, int b){
        System.out.println("before: a = "+a+"; b = "+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after: a = "+a+"; b = "+b);
    }
}
