 package org.example; // Объявление пакета org.example

import java.util.Scanner; // Импорт класса Scanner из пакета java.util

public class Main { // Объявление класса Main

    private static final double EARTH_RADIUS = 6371.0; // Объявление константы EARTH_RADIUS и присвоение ей значения 6371.0

    public static void main(String[] args) { // Объявление метода main

        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для ввода с клавиатуры

        System.out.println("Введите координаты первой точки:"); // Вывод на экран запроса на ввод координат первой точки
        double lat1 = getCoordinate("широту"); // Вызов метода getCoordinate для получения значения широты первой точки
        double lon1 = getCoordinate("долготу"); // Вызов метода getCoordinate для получения значения долготы первой точки

        System.out.println("Введите координаты второй точки:"); // Вывод на экран запроса на ввод координат второй точки
        double lat2 = getCoordinate("широту"); // Вызов метода getCoordinate для получения значения широты второй точки
        double lon2 = getCoordinate("долготу"); // Вызов метода getCoordinate для получения значения долготы второй точки

        double distance = calculateDistance(lat1, lon1, lat2, lon2); // Вычисление расстояния между точками

        System.out.println("Расстояние между точками: " + distance + " км"); // Вывод на экран расстояния между точками
    }

    private static double getCoordinate(String coordinateType) { // Объявление метода getCoordinate

        System.out.print("Введите " + coordinateType + ": "); // Вывод на экран запроса на ввод координаты
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для ввода с клавиатуры
        return scanner.nextDouble(); // Возвращение введенного пользователем значения координаты
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) { // Объявление метода calculateDistance для вычисления расстояния между точками

        lat1 = Math.toRadians(lat1); // Преобразование широты первой точки в радианы
        lon1 = Math.toRadians(lon1); // Преобразование долготы первой точки в радианы
        lat2 = Math.toRadians(lat2); // Преобразование широты второй точки в радианы
        lon2 = Math.toRadians(lon2); // Преобразование долготы второй точки в радианы

        double dLat = lat2 - lat1; // Вычисление разницы широт между точками
        double dLon = lon2 - lon1; // Вычисление разницы долгот между точками

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + // Вычисление части формулы для расчета расстояния
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // Вычисление угла между точками

        return EARTH_RADIUS * c; // Возвращение вычисленного расстояния между точками на поверхности Земли
    }
}