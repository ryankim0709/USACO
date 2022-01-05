import java.util.*;
import java.io.*;

public class service {
    static class trade implements Comparable<trade> {
        long stock, price;

        public trade(long stock, long price) {
            this.stock = stock;
            this.price = price;
        }

        public int compareTo(trade a) {
            long ans = this.price - a.price;

            if (ans > 0) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int markets = Integer.parseInt(st.nextToken());
        int rentals = Integer.parseInt(st.nextToken());

        long[] production = new long[cows];
        for (int x = 0; x < cows; x++)
            production[x] = Long.parseLong(br.readLine());

        trade[] trades = new trade[markets];
        for (int x = 0; x < cows; x++) {
            st = new StringTokenizer(br.readLine());
            trades[x] = new trade(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        long[] rents = new long[rentals];
        for (int x = 0; x < rentals; x++)
            rents[x] = Long.parseLong(br.readLine());

        Arrays.sort(production);
        for (int x = 0; x < cows / 2; x++) {
            long first = production[x];
            long second = production[cows - x - 1];
            production[x] = second;
            production[cows - x - 1] = first;
        }
        Arrays.sort(trades);
        Arrays.sort(rents);
        for (int x = 0; x < rentals / 2; x++) {
            long first = rents[x];
            long second = rents[rentals - x - 1];
            rents[x] = second;
            rents[rentals - x - 1] = first;
        }

        int cowInd = 0;
        int shopInd = 0;
        int rentInd = 0;

        long ans = 0;

        while (cowInd < cows) {
            int shop = shopInd;
            long last = 0;
            long gallons = production[cowInd];
            long profit = 0;

            while (shop < markets) {
                long used = Math.min(gallons, trades[shop].stock);
                gallons -= used;
                profit += trades[shop].price * used;

                if (gallons == 0) {
                    last = used;
                    break;
                } else {
                    shop++;
                }
            }

            if (rentInd >= rentals || profit > rents[rentInd]) { // cell the milk
                ans += profit;
                shopInd = shop;
                if (shopInd < markets) {
                    trades[shopInd].stock -= last;
                }
                cowInd++;
            } else {
                ans += (long) rents[rentInd];
                cows--;
                rentInd++;
            }
        }
        System.out.println(ans);
    }
}
