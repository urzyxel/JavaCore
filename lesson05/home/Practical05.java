package Lavel2.lesson05.home;

import java.io.*;
import java.util.ArrayList;


public class Practical05 {
    public static void main(String[] args){
        // параметры для сохранения файла cvc
        int countHeader = 9;
        int countRow = 15;

        AppData appData = new AppData();
        formingStructure(appData, countRow, countHeader);
        saveCVCFile(appData, countHeader, countRow);
        writeCVCFile(appData);
    }

    public static void saveCVCFile(AppData appData, int countHeader, int countRow) {
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < countHeader; i++) {
                sb.append(appData.getHeader()[i]);
                if (i + 1 < countHeader) {
                    sb.append(';');
                }
            }
            sb.append('\n');
            for (int i = 0; i < countRow; i++) {
                for (int j = 0; j < countHeader; j++) {
                    sb.append(appData.getData()[j][i]);
                    if (j + 1 < countHeader) {
                        sb.append(';');
                    }
                }
                sb.append('\n');
            }
            writer.write(sb.toString());
        } catch (Exception e) {
            System.err.println("Ошибка создния файла, " + e.getStackTrace());
        }
    }

    public static void writeCVCFile(AppData appData) {
        int countHeader = 0;
        int countRow = 0;
        try (BufferedReader bufReader = new BufferedReader(new FileReader("test.csv"))) {
            ArrayList<String> linesCVC = new ArrayList<>();
            String line = bufReader.readLine();
            while (line != null) {
                linesCVC.add(line);
                line = bufReader.readLine();
                countRow++;
            }
            bufReader.close();
            countHeader = linesCVC.get(1).split(";").length;
            appData.deleteArray();
            appData.setInitialization(countHeader, countRow);
            for (int i = 0; i < countHeader; i++) {
                appData.setHeader(i, linesCVC.get(0).split(";")[i]);
                System.out.print(appData.getHeader()[i] + " \t ");
            }
            System.out.println("");
            for (int i = 1; i < countRow; i++) {
                for (int j = 0; j < countHeader; j++) {
                    appData.setData(i - 1, j, Integer.parseInt(linesCVC.get(i).split(";")[j]));
                    System.out.print(appData.getData()[i - 1][j] + " \t\t ");
                }
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файля для загрузки не найден: " + e.getStackTrace());
        } catch (IOException e) {
            System.err.println("Ошибка загрузки файла: " + e.getStackTrace());
        }
    }

    public static void formingStructure(AppData appData, int countHeader, int countRow) {
        appData.setInitialization(countHeader, countRow);
        for (int i = 0; i < countHeader; i++) {
            appData.setHeader(i, "Value " + (i + 1));
        }
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countHeader; j++) {
                appData.setData(i, j, getRandom(100, 700));
            }
        }
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
