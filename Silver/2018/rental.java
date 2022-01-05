import java.util.*;
import java.io.*;

public class rental {
    static class trade implements Comparable<trade> {
        long max, price;

        public trade(long max, long price) {
            this.max = max;
            this.price = price;
        }

        public int compareTo(trade a) {
            long ans = this.price - a.price;
            if (ans > 0) {
                return 1;
            }
            return -1;
        }
    }

    static ArrayList<trade> trades;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int markets = Integer.parseInt(st.nextToken());
        int rents = Integer.parseInt(st.nextToken());

        ArrayList<Long> change = new ArrayList<>();

        // Scanning
        for (int x = 0; x < cows; x++) {
            change.add(Long.parseLong(br.readLine()));
        }

        trades = new ArrayList<>();

        for (int x = 0; x < markets; x++) {
            st = new StringTokenizer(br.readLine());
            trades.add(new trade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ArrayList<Long> rentPrice = new ArrayList<>();
        for (int x = 0; x < rents; x++)
            rentPrice.add(Long.parseLong(br.readLine()));
        // Scanning Complete
        // Sort the arrays
        Collections.sort(rentPrice, Collections.reverseOrder()); // backwards
        Collections.sort(trades, Collections.reverseOrder());

        long diff = (long) 0;
        long cow = 0;
        char type = 'R';

        long ans = 0;
        for (int x = 0; x < cows; x++) {
            diff = (long) -1;
            type = 'R';
            for (Long y : change) {
                long ifRent = rentPrice.get(0);
                long ifTraded = priceIfTraded(y);

                if (Math.abs(ifRent - ifTraded) > diff) {
                    diff = Math.abs(ifRent - ifTraded);
                    cow = y;
                    if (ifRent - ifTraded < 0)
                        type = 'T';
                }
            }

            if (type == 'R') {
                System.out.println("Type: " + type + " Num: " + cow + " Rent Price: " + rentPrice.get(0));
                ans += rentPrice.get(0);
                rentPrice.remove(0);
                change.remove(cow);
            } else {
                ans += priceIfTraded((long) cow);
                System.out.println("Type: " + type + " Num: " + cow + " Rent Price: " + priceIfTraded((long) cow));
                cleanUp((long) cow);
                change.remove(cow);
            }
        }
        System.out.println(ans);
    }

    public static long priceIfTraded(Long gallons) {
        long totalSold = 0;
        long obtained = 0;
        int index = 0;

        while (totalSold != gallons) {
            long left = trades.get(index).max;
            long ppg = trades.get(index).price;

            if (left <= gallons - totalSold) {
                obtained += left * ppg;
                totalSold += left;
                index++;
            } else { // left > gallons - totalSold
                obtained = obtained + ppg * (gallons - totalSold);
                totalSold = gallons;
            }
        }
        return obtained;
    }

    public static void cleanUp(Long gallons) {
        long totalSold = 0;

        while (totalSold != gallons) {
            long left = trades.get(0).max;

            if (left <= gallons - totalSold) {
                totalSold += left;
                trades.remove(0);
            } else { // left > gallons - totalSold
                trades.get(0).max = gallons - totalSold;
                totalSold = gallons;
            }
        }
    }
}