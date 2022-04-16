import java.util.*;
import java.io.*;

public class moocast {

    public static class cow {
        int x;
        int y;
        int radius;

        public cow(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }

    public static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        // BufferedReader br = new BufferedReader(new
        // FileReader("/Users/ryan/Desktop/moocast_silver_dec16/2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int cows = Integer.parseInt(br.readLine());

        cow[] cowsArr = new cow[cows];
        HashMap<Integer, HashSet<Integer>> cowAdjListDist = new HashMap<>();

        StringTokenizer st;

        for (int x = 0; x < cows; x++) {
            st = new StringTokenizer(br.readLine());
            cowsArr[x] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            cowAdjListDist.put(x, new HashSet<>());
        }

        for (int x = 0; x < cows; x++) {
            for (int y = 0; y < cows; y++) {
                if (x == y) {
                    continue;
                }
                if (canCommunicateRadius(cowsArr[x], cowsArr[y])) {
                    cowAdjListDist.get(x).add(y);
                }
            }
        }
        // System.out.println(cowAdjListDist);

        int ans = 0;
        for (int x : cowAdjListDist.keySet()) {
            visited = new HashSet<>();
            ans = Math.max(ans, dfs(x, cowAdjListDist.get(x), cowAdjListDist));
            System.out.println(x + " " + visited);
            // ans = Math.max(ans, cowAdjListDist.get(x).size());
        }
        // System.out.println();
        // System.out.println(ans);
        pw.println(ans);
        pw.close();
    }

    public static boolean canCommunicateRadius(cow from, cow to) {
        double xDiff = Math.abs(from.x - to.x);
        double yDiff = Math.abs(from.y - to.y);
        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return distance <= from.radius;
    }

    public static int dfs(int where, HashSet<Integer> set, HashMap<Integer, HashSet<Integer>> cowAdjList) {
        if (visited.contains(where)) {
            return visited.size();
        }

        visited.add(where);
        for (int x : set) {
            dfs(x, cowAdjList.get(x), cowAdjList);
        }
        return visited.size();
    }
}
