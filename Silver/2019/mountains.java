import java.util.*;
import java.io.*;

public class mountains {
    static class mountain implements Comparable<mountain> {
        long start, end;

        public mountain(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(mountain a) {
            long ans = this.start - a.start;
            if (ans == 0) {
                long ans2 = this.end - a.end;
                if (ans2 > 0) {
                    return -1;
                }
                return 1;
            }

            if (ans > 0) {
                return 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int numMountains = Integer.parseInt(br.readLine());

        mountain[] mountains = new mountain[numMountains];
        StringTokenizer st;
        for (int x = 0; x < numMountains; x++) {
            st = new StringTokenizer(br.readLine());
            long xcoord = Long.parseLong(st.nextToken());
            long ycoord = Long.parseLong(st.nextToken());
            mountains[x] = new mountain((xcoord - ycoord), (xcoord + ycoord));
        }
        Arrays.sort(mountains);

        int ans = 0;
        long rightMost = -1;

        for (mountain a : mountains) {
            if (a.end > rightMost) {
                ans++;
                rightMost = a.end;
            }
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
        br.close();
    }
}
