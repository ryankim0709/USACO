import java.util.*;
import java.io.*;

public class rsElegant {
    static class trade implements Comparable<trade> {
        int max, price;

        public trade(int max, int price) {
            this.max = max;
            this.price = price;
        }

        public int compareTo(trade a) {
            return a.price - this.price;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int markets = Integer.parseInt(st.nextToken());
        int rentals = Integer.parseInt(st.nextToken());

        int[] production = new int[cows];

        for (int x = 0; x < cows; x++)
            production[x] = Integer.parseInt(br.readLine());

        trade[] trades = new trade[markets];
        for (int x = 0; x < markets; x++) {
            st = new StringTokenizer(br.readLine());
            trades[x] = new trade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] rents = new int[rentals];
        for (int x = 0; x < rentals; x++)
            rents[x] = Integer.parseInt(br.readLine());

        Arrays.sort(production);
        for (int x = 0; x < cows / 2; x++) {
            int first = production[x];
            int last = production[cows - 1 - x];
            production[x] = last;
            production[cows - 1 - x] = first;
        }
        Arrays.sort(trades);
        Arrays.sort(rents);
        for (int x = 0; x < rentals / 2; x++) {
            int first = rents[x];
            int last = rents[rentals - 1 - x];
            rents[x] = last;
            rents[rentals - 1 - x] = first;
        }

        int shopInd = 0;
        int rentInd = 0;
        int left = 0;
        long sol = 0;

        while (left < cows) {
            int gallons = production[left];
            int moneyTrade = 0;
            int curShopInd = shopInd;
            int last = 0; // how much was gotton from the last shop

            while (curShopInd < markets) {
                int rest = Math.min(gallons, trades[curShopInd].max);
                moneyTrade += trades[curShopInd].price * rest;
                gallons = gallons - rest;

                if (gallons == 0) {
                    last = rest;
                    break;
                } else {
                    curShopInd++;
                }
            }

            if (rentInd >= rentals || moneyTrade > rents[rentInd]) {
                sol += (long) moneyTrade;
                shopInd = curShopInd;
                if (shopInd < markets)
                    trades[shopInd].max -= last;
                left++;
            } else {
                sol += (long) rents[rentInd];
                cows--;
                rentInd++;
            }
        }
        pw.println(sol);
        pw.close();
        br.close();
    }
}
