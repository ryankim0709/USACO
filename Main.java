import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        int n = io.nextInt();
        Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            int arrival = io.nextInt();
            int departure = io.nextInt();
            customers[i] = new Customer(arrival, departure, i);
        }

        // sort customers by arrival time
        Arrays.sort(customers, Comparator.comparingInt(c -> c.arrival));

        PriorityQueue<Room> pq = new PriorityQueue<>(
                // order rooms by departure
                Comparator.comparingInt(r -> r.departure));

        int k = 0;
        // the room numbers allocated to each customer
        int[] roomAllocations = new int[n];
        // the number of the last new room we've allocated
        int lastRoom = 1;

        // add the first customer to the priority queue
        pq.add(new Room(customers[0].departure, lastRoom));
        roomAllocations[customers[0].index] = lastRoom;

        for (int i = 1; i < n; i++) {
            // find the minimum departure time
            Room min = pq.peek();

            if (min.departure < customers[i].arrival) {
                pq.remove();
                pq.add(new Room(customers[i].departure, min.number));
                roomAllocations[customers[i].index] = min.number;
            } else {
                lastRoom++;
                pq.add(new Room(customers[i].departure, lastRoom));
                roomAllocations[customers[i].index] = lastRoom;
            }
        }

        io.println(lastRoom);
        // use StringBuilder to speed up output
        StringBuilder str = new StringBuilder();
        for (int allocation : roomAllocations) {
            str.append(allocation).append(" ");
        }
        io.println(str);
        io.close();
    }

    static class Customer {
        int arrival, departure, index;

        Customer(int arrival, int departure, int index) {
            this.arrival = arrival;
            this.departure = departure;
            this.index = index;
        }
    }

    static class Room {
        // departure: the time that the customer occupying the room leaves
        // number: the number of the room
        int departure, number;

        Room(int departure, int number) {
            this.departure = departure;
            this.number = number;
        }
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // standard input
        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() { // nextLong() would be implemented similarly
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}