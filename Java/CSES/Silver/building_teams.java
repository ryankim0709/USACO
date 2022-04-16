import java.util.*;
import java.io.*;

class building_teams {
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int[] ans;
    static boolean imposs = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ans = new int[n + 1];

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (!graph.containsKey(first))
                graph.put(first, new HashSet<>());
            if (!graph.containsKey(second))
                graph.put(second, new HashSet<>());

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for (int x = 1; x <= n; x++) {
            if (ans[x] == 0) {
                dfs(x, 1, 0);
            }
        }
        for (int x = 1; x <= n; x++) {
            System.out.print(ans[x] + " ");
        }
    }

    public static void dfs(int current, int currentAns, int beforeAns) {
        if (currentAns == beforeAns) {
            imposs = true;
            return;
        }

        if (ans[current] != 0) {
            return;
        }

        ans[current] = currentAns;
        if (!graph.containsKey(current))
            graph.put(current, new HashSet<>());

        for (int x : graph.get(current)) {
            int next = 0;
            if (currentAns == 1)
                next = 2;
            else
                next = 1;
            dfs(x, next, currentAns);
        }
    }
}