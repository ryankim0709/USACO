import java.util.*;
import java.io.*;

public class bipartiteness {
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int[] coloring;
    static long one = 0;
    static long two = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        coloring = new int[n + 1];

        for (int x = 0; x < n - 1; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (!graph.containsKey(first))
                graph.put(first, new HashSet<>());
            if (!graph.containsKey(second))
                graph.put(second, new HashSet<>());

            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        dfs(1, 1);

        long ans = one * two;
        ans -= (long) (n - 1);
        System.out.println(ans);
    }

    public static void dfs(int current, int color) {
        coloring[current] = color;
        if (color == 1) {
            one++;
        } else {
            two++;
        }

        if (!graph.containsKey(current))
            graph.put(current, new HashSet<>());
        for (int x : graph.get(current)) {
            if (coloring[x] == 0) {
                dfs(x, color == 1 ? 2 : 1);
            }
        }
    }
}