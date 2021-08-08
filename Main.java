package Lavel2.HW;

import Lavel2.HW.fruits.Apple;
import Lavel2.HW.fruits.Orange;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 1 задание



        String[] mamArr = {"мама", "мыла", "раму"};
        System.out.println(Arrays.toString(mamArr));
        changePlaces(mamArr, 0, 2);
        System.out.println(Arrays.toString(mamArr));

        // 2 задание
        Box<Apple> appleBox = new Box<>(new Apple(), 15);
        Box<Apple> appleBox2 = new Box<>(new Apple(), 10);
        Box<Orange> orangeBox = new Box<>(new Orange(), 25);

        appleBox.addFruits(15);

        System.out.println("\nИзначальный вес коробок");
        System.out.printf("Коробка с яблоками весит: %.2f \r\n", appleBox.getWeight());
        System.out.printf("Коробка с яблоками №2 весит: %.2f \r\n", appleBox2.getWeight());
        System.out.printf("Коробка с апельсинами весит: %.2f \r\n", orangeBox.getWeight());

        appleBox2.unite(appleBox);

        System.out.println("\nВес коробок после пересыпания яблок");
        System.out.printf("Коробка с яблоками весит: %.2f \r\n", appleBox.getWeight());
        System.out.printf("Коробка с яблоками №2 весит: %.2f \r\n", appleBox2.getWeight());
        System.out.printf("Коробка с апельсинами весит: %.2f \r\n", orangeBox.getWeight());

        System.out.println("\nСравниваем коробки через compare()");
        if (appleBox2.compare(orangeBox)) {
            System.out.println("Коробки одинакового веса");
        } else {
            System.out.println("Коробка разного веса");
        }

        System.out.println("\nСравниваем коробки через compareTo()");
        if (appleBox2.compareTo(orangeBox) == 0) {
            System.out.println("Коробки одинакового веса");
        } else if (appleBox2.compareTo(orangeBox) < 0) {
            System.out.println("Коробка яблок весит меньше чем коробка апельсинов");
        } else if (appleBox2.compareTo(orangeBox) > 0) {
            System.out.println("Коробка яблок весит больше коробки апельсинов");
        }

    }

    public static void changePlaces(String[] mamArr, int index1, int index2) {
        String a = mamArr[index1];
        mamArr[index1] = mamArr[index2];
        mamArr[index2] = a;
    }



}


