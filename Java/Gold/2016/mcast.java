import java.util.*;
import java.io.*;

public class mcast {
    static class cow {
        int x, y;

        public cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static cow[] cows;
    static HashSet<Integer> visited = new HashSet<>();
    static int numCows;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        numCows = Integer.parseInt(br.readLine());
        cows = new cow[numCows];
        StringTokenizer st;
        for (int x = 0; x < numCows; x++) {
            st = new StringTokenizer(br.readLine());
            cows[x] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            visited = new HashSet<>();
            // System.out.println("Lo: " + lo + "hi: " + hi + " mid: " + mid);

            if (dfs(mid, 0)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        // System.out.println(hi);
        pw.print(hi);
        pw.close();
        br.close();
    }

    public static boolean dfs(int radius, int current) {
        if (visited.contains(current)) {
            return true;
        }

        visited.add(current);

        for (int x = 0; x < numCows; x++) {
            int xDiff = Math.abs(cows[current].x - cows[x].x);
            int yDiff = Math.abs(cows[current].y - cows[x].y);

            if ((xDiff * xDiff) + (yDiff * yDiff) <= radius) {
                dfs(radius, x);
            }
        }

        if (visited.size() == numCows) {
            return true;
        }
        return false;
    }
}
