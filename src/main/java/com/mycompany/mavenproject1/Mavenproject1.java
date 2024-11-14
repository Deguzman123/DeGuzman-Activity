/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

public class Mavenproject1 {

    public static void main(String[] args) {
        double[][] temperatures = {
            {25.8, 31.4, 28.3, 22.5, 30.1},
            {24.2, 29.8, 26.9, 23.1, 31.8},
            {26.5, 30.6, 27.4, 21.8, 29.3},
            {27.9, 32.1, 29.5, 24.4, 31.2},
            {23.9, 29.2, 26.3, 22.9, 30.5},
            {25.4, 31.9, 28.8, 23.6, 32.0},
            {24.8, 30.3, 27.1, 21.4, 29.9}
        };

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] cities = {"Tacloban City", "Cebu City", "Davao city", "Quezon City", "Zamboanga City"};

        displayTemperatures(temperatures, days, cities);
        averageTemperaturePerCity(temperatures, cities);
        hottestDay(temperatures, days, cities);
        coldestDay(temperatures, days, cities);
    }

    public static void displayTemperatures(double[][] temperatures, String[] days, String[] cities) {
        System.out.println("Temperature Readings (°C)");
        System.out.println("---------------------------");
        System.out.printf("%-10s", "Day");
        for (int j = 0; j < 5; j++) {
            System.out.printf("%-10s", cities[j]);
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.printf("%-10s", days[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10.1f", temperatures[i][j]);
            }
            System.out.println();
        }
    }

    public static void averageTemperaturePerCity(double[][] temperatures, String[] cities) {
        System.out.println("\nAverage Temperature per City:");
        for (int j = 0; j < 5; j++) {
            double sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += temperatures[i][j];
            }
            double average = sum / 7;
            System.out.println(cities[j] + ": " + String.format("%.1f°C", average));
        }
    }

    public static void hottestDay(double[][] temperatures, String[] days, String[] cities) {
        double maxTemp = Double.MIN_VALUE;
        int maxDay = 0;
        int maxCity = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (temperatures[i][j] > maxTemp) {
                    maxTemp = temperatures[i][j];
                    maxDay = i;
                    maxCity = j;
                }
            }
        }

        System.out.println("\nHottest Day:");
        System.out.println("Day: " + days[maxDay]);
        System.out.println("City: " + cities[maxCity]);
        System.out.println("Temperature: " + String.format("%.1f°C", maxTemp));
    }

    public static void coldestDay(double[][] temperatures, String[] days, String[] cities) {
        double minTemp = Double.MAX_VALUE;
        int minDay = 0;
        int minCity = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (temperatures[i][j] < minTemp) {
                    minTemp = temperatures[i][j];
                    minDay = i;
                    minCity = j;
                }
            }
        }

        System.out.println("\nColdest Day:");
        System.out.println("Day: " + days[minDay]);
        System.out.println("City: " + cities[minCity]);
        System.out.println("Temperature: " + String.format("%.1f°C", minTemp));
    }
}