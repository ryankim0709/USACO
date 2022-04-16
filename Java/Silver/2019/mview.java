import java.util.*;
import java.io.*;

public class mview {
    static class mountain implements Comparable<mountain> {
        int start, end;

        public mountain(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(mountain a) {
            if (this.start == a.start) {
                return a.end - this.end;
            }
            return this.start - a.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int numMountain = Integer.parseInt(br.readLine());

        mountain[] mountains = new mountain[numMountain];
        StringTokenizer st;
        for (int x = 0; x < numMountain; x++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            mountains[x] = new mountain((first - second), (first + second));
        }
        br.close();
        Arrays.sort(mountains);
        int rightmost = -1;
        int sol = 0;
        for (mountain x : mountains) {
            if (x.end > rightmost) {
                sol++;
                rightmost = x.end;
            }
        }
        pw.print(sol);
        pw.close();
    }
}
