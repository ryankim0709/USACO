import java.util.*;
import java.io.*;

public class rentals {
    static class trade implements Comparable<trade> {
        long amount, price;

        public trade(long amount, long price) {
            this.amount = amount;
            this.price = price;
        }

        public int compareTo(trade a) {
            long ans = a.price - this.price;
            if (ans > 0) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        BufferedReader br = new BufferedReader(new FileReader("/Users/ryan/Desktop/rental_silver_jan18/5.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCows = Integer.parseInt(st.nextToken());
        int markets = Integer.parseInt(st.nextToken());
        int numRents = Integer.parseInt(st.nextToken());

        long[] production = new long[numCows];
        for (int x = 0; x < numCows; x++)
            production[x] = Integer.parseInt(br.readLine());

        Arrays.sort(production);

        trade[] trades = new trade[markets];
        for (int x = 0; x < markets; x++) {
            st = new StringTokenizer(br.readLine());
            trades[x] = new trade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(trades);

        long[] rentals = new long[numRents];
        for (int x = 0; x < numRents; x++)
            rentals[x] = Long.parseLong(br.readLine());

        Arrays.sort(rentals);

        for (int x = 0; x < numCows / 2; x++) {
            long first = production[x];
            long second = production[numCows - x - 1];
            production[x] = second;
            production[numCows - x - 1] = first;
        }

        for (int x = 0; x < numRents / 2; x++) {
            long first = rentals[x];
            long second = rentals[numRents - x - 1];
            rentals[x] = second;
            rentals[numRents - x - 1] = first;
        }
        br.close();
        int cowInd = 0;
        int tradeInd = 0;
        int rentInd = 0;
        long sol = 0;

        while (cowInd < numCows) { // why < then and not <=
            int shopInd = tradeInd;
            long profit = 0;
            long gallons = production[cowInd];
            long last = 0;

            while (shopInd < markets) {
                Long left = Math.min(gallons, trades[shopInd].amount);
                profit += left * trades[shopInd].price;
                gallons -= left;

                if (gallons == 0) {
                    last = left;
                    break;
                } else {
                    shopInd++;
                }
            }

            if (rentInd >= numRents || profit > rentals[rentInd]) {
                sol += profit;
                cowInd++;
                tradeInd = shopInd;
                if (shopInd < markets) {
                    trades[shopInd].amount -= last;
                }
            } else {
                sol += rentals[rentInd];
                numCows--;
                rentInd++;
            }
        }
        // System.out.println(sol);
        pw.println(sol);
        pw.close();
    }
}
