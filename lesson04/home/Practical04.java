package Lavel2.lesson04.home;

import java.util.*;

public class Practical04 {


    public static void main(String[] args) {
        System.out.println("Задание № 1:");
        task01();
        System.out.println("\nЗадание № 2:");
        HashMap<String, String> phoneBook = new HashMap<>();
        task02(phoneBook);
    }

    public static void task01() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Врач");
        words.add("Хулиган");
        words.add("Вокзал");
        words.add("Мошенник");
        words.add("Небеса");
        words.add("Врач");
        words.add("Сланцы");
        words.add("Вокзал");
        words.add("Апельсин");
        words.add("Ресторан");
        words.add("Небеса");
        words.add("Башка");
        words.add("Небеса");
        words.add("Ученик");
        words.add("Молоко");
        words.add("Хулиган");
        words.add("Башка");
        words.add("Вокзал");
        words.add("Апельсин");
        words.add("Ресторан");

        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            if (result.containsKey(words.get(i))) {
                result.computeIfPresent(words.get(i), (k, v) -> v + 1);
            } else result.put(words.get(i), 1);
        }
        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            System.out.println(pair.getKey() + "\t \t" + pair.getValue());
        }
    }

    public static void task02(HashMap phoneBook) {
        addPhone(phoneBook, "8-913-852-20-89", "Иванов");
        addPhone(phoneBook, "8-913-896-21-34", "Сидоров");
        addPhone(phoneBook, "8-913-006-29-75", "Петров");
        addPhone(phoneBook, "8-999-362-02-51", "Иванов");
        System.out.println(getPhone(phoneBook, "Иванов"));
        System.out.println(getPhone(phoneBook, "Есенин"));
        System.out.println(getPhone(phoneBook, "Петров"));
    }

    public static void addPhone(HashMap phoneBook, String phone, String surname) {
        phoneBook.put(phone, surname);
    }

    public static String getPhone(HashMap phoneBook, String surname) {
        String result = "Результат поиска:\n";
        boolean fl = false;
        Set<Map.Entry<String, String>> set;
        set = phoneBook.entrySet();
        for (Map.Entry<String, String> pair : set) {
            if (pair.getValue() == surname) {
                result = result + pair.getValue() + ": " + pair.getKey() + "\n";
                fl = true;
            }
        }
        if (!fl) {
            result = result + "По вашему запросу ничего не найдено!\n";
        }
        return result;
    }

}