//Ты можешь добавлять свои импорты
import java.io.IOException;
import java.util.*;

//решение должно содержать данный класс
class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение через пробел (доступны числа только от 1 до 10): ");
        String input = sc.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

    //Решение должно содержать данный метод
    public static String calc(String inputString) throws IOException {
        String[] vyrazhenie = inputString.split(" ");
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII",
                "XCIX", "C"};
        boolean isArabic = false;
        char operator = 0;

        if (vyrazhenie.length > 3) {
            throw new IOException();
        }

        switch (vyrazhenie[1]) {
            case "+":
                operator = '+';
                break;
            case "-":
                operator = '-';
                break;
            case "*":
                operator = '*';
                break;
            case "/":
                operator = '/';
                break;

        }
        if (vyrazhenie[0].matches("[1-9]+[\\.]?[1-9]*") ^ vyrazhenie[2].matches("[1-9]+[\\.]?[1-9]*")) {
            throw new IOException();
        }

        isArabic = vyrazhenie[0].matches("[1-9]+[\\.]?[1-9]*") && vyrazhenie[2].matches("[1-9]+[\\.]?[1-9]*");

        if (isArabic) {
            if (Integer.parseInt(vyrazhenie[0]) > 10 || Integer.parseInt(vyrazhenie[2]) > 10) {
                throw new IOException();
            }

            if (vyrazhenie[1].equals("+")) {
                return Integer.toString(Integer.parseInt(vyrazhenie[0]) + Integer.parseInt(vyrazhenie[2]));
            } else if (vyrazhenie[1].equals("-")) {
                return Integer.toString(Integer.parseInt(vyrazhenie[0]) - Integer.parseInt(vyrazhenie[2]));
            } else if (vyrazhenie[1].equals("*")) {
                return Integer.toString(Integer.parseInt(vyrazhenie[0]) * Integer.parseInt(vyrazhenie[2]));
            } else if (vyrazhenie[1].equals("/")) {
                return Integer.toString(Integer.parseInt(vyrazhenie[0]) / Integer.parseInt(vyrazhenie[2]));
            } else {
                throw new IOException();
            }
        } else {
            return calcRoman(vyrazhenie, operator, romanNumbers);
        }

    }

    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }

    private static String calcRoman(String[] vyrazhenie, char operator, String[] romanNumbers) throws IOException {
        if (romanToNumber(vyrazhenie[0]) != -1) {
            if (romanToNumber(vyrazhenie[2]) != -1) {
                int a = romanToNumber(vyrazhenie[0]);
                int b = romanToNumber(vyrazhenie[2]);

                switch (operator) {
                    case '+':
                        return romanNumbers[a + b - 1];

                    case '-':
                        return romanNumbers[a - b - 1];

                    case '*':
                        return romanNumbers[(a * b) - 1];

                    case '/':
                        return romanNumbers[a / b - 1];

                }
            } else {
                throw new IOException();
            }
        } else {
            throw new IOException();

        }
        return null;
    }
}