package org.example;

import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        // Создание объекта Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Вывод запроса на ввод сторон треугольника
        System.out.println("Введите стороны треугольника a, b и c:");
        // Считывание значений сторон треугольника
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Проверка, являются ли стороны прямоугольным треугольником
        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) || c * c + Math.pow(a, 2) == Math.pow(b, 2)) {
            System.out.println("a, b и c являются сторонами прямоугольного треугольника");
        } else if (a == b && b == c) { // Проверка, являются ли стороны равносторонним треугольником
            System.out.println("a, b и c являются сторонами равностороннего треугольника");
        } else if (a == b || b == c || c == a) { // Проверка, являются ли стороны равнобедренным треугольником
            System.out.println("a, b и c являются сторонами равнобедренного треугольника");
        } else if (a + b <= c || b + c <= a || c + a <= b) { // Проверка, могут ли стороны образовать треугольник
            System.out.println("a, b и c не являются сторонами треугольника");
        } else { // В остальных случаях
            System.out.println("a, b и c являются сторонами обычного треугольника");
        }
    }
}