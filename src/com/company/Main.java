package com.company;


public class Main {

    public static void main(String[] args) {

        double a = 2.001;
        double b = 2.0012;
        double c = 2.001;

        double kilogram = 920.157; // масса динозавра в килограммах

        double r1 = 5.5; // внешний радиус кольца
        double r2 = 3.7; // внутренний радиус кольца

        int fourDigitNumber = 9531;

        int sixDigitNumber = 123456;

        int sevenDigitNumber = 4596846;

        int d = 1234;
        int e = 56789;

        checkNumbers(a,b,c); // проверка чисел на равенство
        dinosaurMass(kilogram); // конвертация массы динозавра
        ringArea(r1,r2); // нахождение площади кольца
        sequenceCheck(fourDigitNumber); // проверка чисел четырёхзначного числа на образование возрастающей (убывающей) последовательности
        arithmeticAndGeometricMean(sixDigitNumber); // расчёт арифметическое и геометрическое среднее цифр шестизначного числа
        reverseNumber(sevenDigitNumber); // выполняет реверсию семизначного числа
        changeValues(d,e); // выполняет замену содержимого двух целочисленных переменных "d" и "e"
    }

    public static void checkNumbers(double a, double b, double c){
        if(a==b && b==c){
            System.out.println("числа одинаковы");
        } else {
            System.out.println("числа различны");
        }
    }

    public static void dinosaurMass(double kilogram){

        double milligrams = kilogram * 1000_000;
        double grams = kilogram * 1000;
        double tons = kilogram / 1000;

        System.out.println("масса дино: милиграмм = "+milligrams+", грамм = "+grams+", тонн = "+tons);
    }

    public static void  ringArea(double r1, double r2){

        double area;

        if(r1>r2){
            area = Math.PI * (Math.pow(r1,2) - Math.pow(r2,2));
            System.out.println("площадь кольца = "+area);
        } else {
            System.out.println("r2 должен быть меньше r1,т.к. внутренний радиус не может быть больше внешнего");
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
                System.out.println("цифры числа " + s + " образуют возрастающую последовательность");
            } else if (firstDigit > secondDigit && secondDigit > thirdDigit && thirdDigit > fourthDigit) {
                System.out.println("цифры числа " + s + " образуют убывающую последовательность");
            } else {
                System.out.println("цифры числа " + s + " не образуют убывающую или возрастающую последовательности");
            }
        } else {
            System.out.println("введённое число не является четырёхзначным");
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

            System.out.println("среднее арифметическое цифр шестизначного числа "+s+" = "+arithmeticMean);
            System.out.println("среднее геометрическое цифр шестизначного числа "+s+" = "+geometricMean);
        } else {
            System.out.println("введённое число не является шестизначным");
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
            System.out.println("реверсия семизначного числа "+s+" = "+newNumber);
        } else {
            System.out.println("введённое число не является семизначным");
        }
    }

    public static void changeValues(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = "+a+"; b = "+b);
    }
}
