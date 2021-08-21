package Lavel2.lesson05.home;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(int i, String header) {
        this.header[i] = header;
    }

    public void setData(int i, int j, int value) {
        this.data[i][j] = value;
    }

    public void setInitialization(int countHeader, int countRow) {
        this.header = new String[countHeader];
        this.data = new int[countRow][countHeader];
    }

    public void deleteArray(){
        header = null;
        data = null;
    }
}
