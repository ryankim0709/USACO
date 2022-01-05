import java.util.*;
import java.io.*;

public class concert_tickets {
    public static void main(String[] args) throws IOException {
        /*
         * Hash VS Tree
         * 
         * Tree Set/Map: Sortedness, log(n) for insertion, lookup, deletion
         * 
         * Hash Set/Map: Not sorted, O(1) for insertion, lookup, deletion
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tickets = Integer.parseInt(st.nextToken());
        int customers = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> prices = new HashMap<>();
        TreeSet<Integer> prices2 = new TreeSet<>();
        prices.put(-1, 0);
        prices.put(10 ^ 9 + 1, 0);

        st = new StringTokenizer(br.readLine());

        int price;
        for (int x = 0; x < tickets; x++) {
            price = Integer.parseInt(st.nextToken());
            prices2.add(price);

            if (prices.containsKey(price)) {
                prices.put(price, prices.get(price) + 1);
            }

            else {
                prices.put(price, 1);
            }
        }
        // System.out.println(prices);

        st = new StringTokenizer(br.readLine());

        int customerPrice;
        for (int x = 0; x < customers; x++) {
            customerPrice = prices2.floor(Integer.parseInt(st.nextToken()));

            if (customerPrice == (10 ^ 9 + 1) || customerPrice == -1) {
                System.out.println(-1);
            } else {
                System.out.println(customerPrice);

                if (prices.get(customerPrice) == 1) {
                    prices.remove(customerPrice);
                } else {
                    prices.put(customerPrice, prices.get(customerPrice) - 1);
                }
            }
        }

    }
}
