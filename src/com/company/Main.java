package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int r;
        int sumSq;
        List<Integer> listN = new ArrayList<>();

        for (int n = 100; n < 310; n++) {
            r = n % 11;
            //sumSq = sumOfSquareNumeric(n);
            sumSq = sumOfSquareNumeric2(n);

            if (r == sumSq) {
                listN.add(n);
                System.out.println("r == res : " + r + " == " + sumSq);
                System.out.println("----------------------");
            }

            System.out.println("==============================");
        }

        for (Integer idx : listN) {
// System.out.printf("%n ", idx);
            System.out.println(idx);
        }

    }

    /**
     * Метод получения суммы квадратов цифр составляющих трехзначное число
     * Вариант с промежуточным преобразованием в строку
     * @param n трехзначное число
     * @return целочисленная сумма квадратов цифр числа
     */
    public static int sumOfSquareNumeric(int n) {
        String N = Integer.toString(n);
        int res = 0;

        for (int i = 0; i < N.length(); i++) {
            res += Math.pow(Character.getNumericValue(N.charAt(i)), 2);
            System.out.println("char " + N.charAt(i) + " numeric " + Character.getNumericValue(N.charAt(i)) + " -> " + Math.pow(Character.getNumericValue(N.charAt(i)), 2) + " => " + res);
        }

        return res;
    }

    /**
     * Метод получения суммы квадратов цифр составляющих трехзначное число
     * Вариант с использованием своего, математического метода разбиения числа на цифры
     * @param n трехзначное число
     * @return целочисленная сумма квадратов цифр числа
     */
    public static int sumOfSquareNumeric2(int n) {
        List N = numDiv(n);
        int res = 0;

        for (int i = 0; i < N.size(); i++) {
            // TODO: ошибка приведения к типу Double - как-то надо переделать
            //res += Math.pow((Double)N.get(i), 2);
            int power2 = (int) N.get(i);
            res += (power2 * power2);
        }

        return res;
    }

    /**
     * Метод для разбиения числа на цифры
     * @param n число для разбиения
     * @return список цифр из которых состоит число
     */
    public static List numDiv(int n){
        List listNum = new ArrayList<>();
        int num = n;

        while (num != 0) {
            listNum.add(num % 10); // цифры числа идут в обратном порядке; надо переворачивать список
            num /= 10;
        }

        return listNum;
    }

}
