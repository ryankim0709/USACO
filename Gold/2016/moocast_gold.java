import java.util.*;
import java.io.*;

public class moocast_gold {
    static class coordinate {
        double x;
        double y;

        public coordinate(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class edge {
        int to;
        double dist;

        public edge(int to, Double dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static int numCows;
    static coordinate[] coords;
    static HashSet<Integer> visited;
    static Map<Integer, Set<edge>> adjList = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        numCows = Integer.parseInt(br.readLine());
        coords = new coordinate[numCows];

        StringTokenizer st;

        for (int x = 0; x < numCows; x++) {
            st = new StringTokenizer(br.readLine());
            coords[x] = new coordinate(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int x = 0; x < numCows; x++) {
            adjList.put(x, new HashSet<>());
            for (int y = 0; y < numCows; y++) {
                if (x == y)
                    continue;
                Double xDiff = Math.abs(coords[x].x - coords[y].x);
                Double yDiff = Math.abs(coords[x].y - coords[y].y);
                Double dist = xDiff * xDiff + yDiff * yDiff;
                adjList.get(x).add(new edge(y, dist));
            }
        }

        // for (int x = 0; x < numCows; x++) {
        // System.out.print(x + ": ");
        // for (edge a : adjList.get(x)) {
        // System.out.print("(To: " + a.to + ", dist: " + a.dist + ")");
        // }
        // }

        int lo = 0;
        int hi = 625000000;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            visited = new HashSet<>();
            if (canDo(mid)) {
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

    public static boolean canDo(int max) {
        dfs(0, max);

        if (visited.size() == numCows) {
            return true;
        }
        return false;
    }

    public static void dfs(int current, int max) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);

        for (edge a : adjList.get(current)) {
            if (a.dist <= max) {
                dfs(a.to, max);
            }
        }
    }
}
