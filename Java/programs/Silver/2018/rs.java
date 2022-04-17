import java.util.*;
import java.io.*;

public class rs {
    static class trade implements Comparable<trade> {
        long cap, price;

        public trade(long cap, long price) {
            this.cap = cap;
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

    static ArrayList<trade> trades;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int markets = Integer.parseInt(st.nextToken());
        int farms = Integer.parseInt(st.nextToken());

        ArrayList<Integer> production = new ArrayList<>();
        trades = new ArrayList<>();
        ArrayList<Long> rentals = new ArrayList<>();

        for (int x = 0; x < cows; x++)
            production.add(Integer.parseInt(br.readLine()));
        for (int x = 0; x < markets; x++) {
            st = new StringTokenizer(br.readLine());
            trades.add(new trade(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        for (int x = 0; x < farms; x++)
            rentals.add(Long.parseLong(br.readLine()));

        Collections.sort(production, Collections.reverseOrder());
        Collections.sort(trades);
        Collections.sort(rentals, Collections.reverseOrder());

        int ind1 = 0;
        int ind2 = cows - 1;

        int rentalIndex = 0;
        int farmIndex = 0;

        long ans = 0;

        long ifTraded, ifRented;
        while (ind1 <= ind2) {
            ifRented = -1;
            if (rentalIndex < farms) {
                ifRented = rentals.get(0);
            }

            ifTraded = simulate(production.get(ind1));

            if (ifRented > ifTraded) {
                ans += ifRented;
                production.remove(production.get(ind2));
            } else { // ifRented <= ifTraded

            }
        }
    }

    public static long simulate(long gallons) {
        long gallonsGotton = 0;
        long obtained = 0;

        int index = 0;

        try {
            while (gallonsGotton != gallons) {
                long left = trades.get(index).cap;

                if (left <= gallons - gallonsGotton) {
                    gallonsGotton += left;
                    obtained += left * trades.get(index).price;
                    index++;
                } else { // left > gallons - gallonsGotton
                    obtained = (gallons - gallonsGotton) * trades.get(index).price;
                    gallonsGotton = gallons;
                }
            }

            return obtained;
        } catch (Error e) {
            return obtained;
        }
    }
}
