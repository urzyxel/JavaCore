package Lavel2.lesson02.home;

public class Practical02 {

    public static void main(String[] args) {
        int size = 4;
        String[][] strArray = new String[size][size];

        System.out.println("На вход подаем массив из чисел и символов:");
        Go(strArray, 1);
        System.out.println("********************" + "\n");

        System.out.println("На вход подаем массив только из чисел:");
        Go(strArray, 0);

    }

    public static void Go(String[][] strArray, int fl) {
        try {
            writeArray(strArray, fl);
            System.out.println("Сумма элементов массив: " + summarizeArray(strArray));
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int summarizeArray(String[][] strArray) throws MyArraySizeException {
        if (strArray[0].length != 4 | strArray[1].length != 4) {
            throw new MyArraySizeException("Не верные границы массива");
        }
        int result = 0;
        for (int i = 0; i < strArray[0].length; i++) {
            for (int j = 0; j < strArray[1].length; j++) {
                try {
                    result += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException ex) {
                    try {
                        throw new MyArrayDataException("Ошибка преобразования в ячейке: [" + i + ", " + j + "]");
                    } catch (MyArrayDataException e) {
                        System.err.println(e.getMessage());
                        result += 0;
                    }
                }

            }
        }
        return result;
    }

    public static void writeArray(String[][] strArray, int fl) {
        for (int i = 0; i < strArray[0].length; i++) {
            for (int j = 0; j < strArray.length; j++) {
                if (fl == 1) {
                    if (getRandom(0, 1000) <= 500) {
                        strArray[i][j] = String.valueOf(getRandom(0, 500));
                        System.out.print(strArray[i][j] + "\t");
                    } else {
                        strArray[i][j] = String.valueOf((char) (getRandom(0, 500)));
                        System.out.print(strArray[i][j] + "\t");
                    }
                }
                if (fl == 0) {
                    strArray[i][j] = String.valueOf(getRandom(0, 500));
                    System.out.print(strArray[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
