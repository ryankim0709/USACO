import java.util.*;
import java.io.*;

public class mv {
    static class mountain implements Comparable<mountain> {
        long x, y;

        public mountain(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(mountain a) {
            if (this.x == a.x) {
                long ans = this.y - a.y;

                if (ans > 0) {
                    return -1;
                }
                return 1;
            }
            long ans = this.x - a.x;
            if (ans > 0) {
                return 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        // BufferedReader br = new BufferedReader(new
        // FileReader("/Users/ryan/Desktop/mountains_silver_jan19/2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int peaks = Integer.parseInt(br.readLine());

        StringTokenizer st;

        mountain[] mountains = new mountain[peaks];

        Long xcoor, ycoor;
        for (int x = 0; x < peaks; x++) {
            st = new StringTokenizer(br.readLine());
            xcoor = Long.parseLong(st.nextToken());
            ycoor = Long.parseLong(st.nextToken());
            mountains[x] = new mountain((xcoor - ycoor), (xcoor + ycoor));
        }
        br.close();
        Arrays.sort(mountains);

        int ans = 0;

        long rightMost = -1;

        for (mountain b : mountains) {
            if (b.y > rightMost) {
                ans++;
                rightMost = b.y;
            }
        }
        // System.out.println(ans);
        pw.println(ans);
        pw.close();
    }
}
