package Lavel2.Lesson03.home;



public class Main {
    public static void main(String[] args) {
        int length = getRandom(3, 10);
        String[] taskArray = new String[length];
        writeArray(length, taskArray);
        printArray(taskArray);
        System.out.println("");
        changePlaces(taskArray);
        printArray(taskArray);

        Box<Apple> appleBox = new Box<>(new Apple(1.0f), 15);
        Box<Apple> appleBox2 = new Box<>(new Apple(1.0f), 10);
        Box<Orange> orangeBox = new Box<>(new Orange(1.5f), 10);

        //System.out.println(appleBox.getCurrentItemsCount());
        System.out.println("\nИзначальный вес коробок");
        System.out.printf("Коробка с яблоками весит: %.2f \r\n", appleBox.getWeight());
        System.out.printf("Коробка с яблоками № 2 весит: %.2f \r\n", appleBox2.getWeight());
        System.out.printf("Коробка с апельсинами весит: %.2f \r\n", orangeBox.getWeight());

        System.out.println("В корбку с яблоками добавили фруктов");
        appleBox.addFruits(10);
        System.out.printf("Коробка с яблоками весит: %.2f \r\n", appleBox.getWeight());

        appleBox2.unite(appleBox);
        System.out.println("\nПересыпаем яблоки из первой коробки во вторую");
        System.out.printf("Коробка с яблоками весит: %.2f \r\n", appleBox.getWeight());
        System.out.printf("Коробка с яблоками № 2 весит: %.2f \r\n", appleBox2.getWeight());
        System.out.printf("Коробка с апельсинами весит: %.2f \r\n", orangeBox.getWeight());

        System.out.println("\nСравниваем коробки");
        if (appleBox2.compare(orangeBox)) {
            System.out.println("Коробки одинакового веса");
        } else {
            System.out.println("Коробка разного веса");
        }



    }

    public static void changePlaces(String[] strArray) {
        int index1 = getRandom(0, strArray.length-1);
        int index2;
        String a = strArray[index1];
        do {
            index2 = getRandom(0, strArray.length-1);
        }while (index2 == index1);
        strArray[index1] =  strArray[index2];
        strArray[index2] = a;
    }

    public static int getRandom(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    public static void writeArray(int length, String[] strArray) {
        for (int i = 0; i < length; i++) {
            strArray[i] = "value_"+i;
        }
    }

    public static void printArray(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            if (i != strArray.length-1) {
                System.out.print(strArray[i] + ", ");
            } else{
                System.out.print(strArray[i]+";");
            }
        }
    }


}
