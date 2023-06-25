package SeaBattle.Ocean;

public class Ocean {
    private int length;
    private int width;

    private char[][] ocean;

    public Ocean(int length, int width) {
        this.length = length;
        this.width = width;
        this.ocean = new char[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                ocean[i][j] = '_';
            }
        }
    }
    public void print(){
        System.out.printf("%3c",' ');
        for (int i = 0; i < width; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        for (int i = 0; i < length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < width; j++) {
                System.out.printf("%2c ", ocean[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] getOcean() {
        return ocean;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    public void clearOcean(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                ocean[i][j] = '_';
            }
        }
    }
}
