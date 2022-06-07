package programs;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 3; i <= 9; i++) {
            for (int j = 6; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}