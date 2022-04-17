import java.util.*;
import java.io.*;

public class fencing {
    static class cow {
        int x, y;

        public cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static cow[] loc;
    static HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();

    static HashSet<Integer> visited = new HashSet<>();
    static HashSet<Integer> vis1 = new HashSet<>();

    static int up, down, left, right;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coordinates = Integer.parseInt(st.nextToken());
        int pairs = Integer.parseInt(st.nextToken());

        loc = new cow[coordinates];

        for (int x = 0; x < coordinates; x++) {
            connections.put(x + 1, new HashSet<>());
            st = new StringTokenizer(br.readLine());
            loc[x] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int x = 0; x < pairs; x++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            connections.get(first).add(second);
            connections.get(second).add(first);
        }
        // System.out.println(connections);

        int ans = Integer.MAX_VALUE;

        for (int x = 1; x <= coordinates; x++) {
            if (!vis1.contains(x)) {
                visited = new HashSet<>();
                up = 0;
                down = Integer.MAX_VALUE;
                left = Integer.MAX_VALUE;
                right = 0;

                dfs(x);

                ans = Math.min(ans, (2 * ((right - left) + (up - down))));
            }
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
        br.close();
    }

    public static void dfs(int current) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);
        vis1.add(current);
        cow a = loc[current - 1];

        up = Math.max(up, a.y);
        down = Math.min(down, a.y);
        right = Math.max(right, a.x);
        left = Math.min(left, a.x);

        for (int x : connections.get(current)) {
            dfs(x);
        }
    }
}
