import java.util.*;
import java.io.*;

public class rooms {
    static class Customer implements Comparable<Customer> {
        int start, end, idx;

        public Customer(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        public int compareTo(Customer a) {
            return this.start - a.start;
        }
    }

    static class Pair {
        int leaving, room;

        public Pair(int leaving, int room) {
            this.leaving = leaving;
            this.room = room;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Customer[] customers = new Customer[N];

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            customers[x] = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), x);
        }
        Arrays.sort(customers);

        PriorityQueue<Pair> leaving = new PriorityQueue<>(
                Comparator.comparingInt(r -> r.leaving));

        int[] ans = new int[N];
        int rooms = 1;

        // Do first one by hand
        leaving.add(new Pair(customers[0].end, rooms));
        ans[customers[0].idx] = 1;

        for (int x = 1; x < N; x++) {
            Pair min = leaving.peek();

            if (min.leaving < customers[x].start) {
                leaving.remove();
                leaving.add(new Pair(customers[x].end, min.room));
                ans[customers[x].idx] = min.room;
            } else {
                rooms++;
                leaving.add(new Pair(customers[x].end, rooms));
                ans[customers[x].idx] = rooms;
            }
        }
        System.out.println(rooms);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        // for (Customer i : customers) {
        // int arrival = i.start;
        // // Clean up
        // while (leaving.peek() != null && leaving.peek().leaving < arrival) {
        // available.add(leaving.peek().room);
        // leaving.poll();
        // }

        // // Guarantee at least one room
        // if (available.size() == 0) {
        // rooms++;
        // available.add(rooms);
        // }
        // // Allocation
        // int room = available.poll();
        // leaving.add(new Pair(i.end, room));
        // ans[i.idx] = room;
        // }
    }
}