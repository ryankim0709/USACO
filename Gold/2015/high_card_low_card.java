import java.util.*;
import java.io.*;

public class high_card_low_card {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));

        int totalCards = Integer.parseInt(br.readLine());

        int[] elsieCards = new int[totalCards];
        int[] bessieCards = new int[totalCards];

        int[] used = new int[totalCards * 2 + 1];

        int num;
        for (int x = 0; x < totalCards; x++) {
            num = Integer.parseInt(br.readLine());
            elsieCards[x] = num;
            used[num] = 1;
        }

        int counter = 0;
        for (int x = 1; x <= totalCards * 2; x++) {
            if (used[x] != 1) {
                bessieCards[counter] = x;
                counter++;
            }
        }

        int[] elsieLower = new int[totalCards / 2];
        int[] elsieHigher = new int[totalCards / 2];
        int[] bessieLower = new int[totalCards / 2];
        int[] bessieHigher = new int[totalCards / 2];

        for (int x = 0; x < totalCards / 2; x++) {
            elsieHigher[x] = elsieCards[x];
            bessieLower[x] = bessieCards[x];
        }

        for (int x = 0; x < totalCards / 2; x++) {
            elsieLower[x] = elsieCards[x + totalCards / 2];
            bessieHigher[x] = bessieCards[x + totalCards / 2];
        }

        Arrays.sort(elsieLower);
        Arrays.sort(elsieHigher);

        int ans = 0;

        // Greater game. Use index to start from the biggest one and keep going backwards so that you win as many times as possible
        // Once we find the maximum number of times we can win, we can rearrange in any order
        int index = totalCards/2 - 1;

        //Start from backwards to process elsie's cards backward

        for(int x = totalCards/2 - 1; x >= 0; x--) {
            if(bessieHigher[index] > elsieHigher[x]) {
                index --;
                ans ++;
            }
        }

        // Lesser game. By the same logic, we can start the index at the smallest in order to find out the most number of times
        // Bessie can win. Once we find the most number of times Bessie can win, we can rearrange everything else in any order

        index = 0;

        for(int x = 0; x < totalCards/2; x++) {
            if(bessieLower[index] < elsieLower[x]) {
                ans ++;
                index ++;
            }
        }
        pw.println(ans);
        pw.close();
        br.close();
    }
}
