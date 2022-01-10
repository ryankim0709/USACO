import java.util.*;
import java.io.*;

public class rank {
<<<<<<< HEAD
=======
    static Map<Integer, Set<Integer>> graph = new HashMap<>();
>>>>>>> 5fe014103c4a5077641a9c9188842f6d51f4df3c
    // Key is winner and Value is loser
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int ans = 0;
    static Set<Integer> visited = new HashSet<>();
    static boolean cyclic = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int games = Integer.parseInt(st.nextToken());

        for (int x = 0; x < games; x++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken()); // Person 1
            int p2 = Integer.parseInt(st.nextToken()); // Person 2
            int p1s = Integer.parseInt(st.nextToken()); // Person 1 score
            int p2s = Integer.parseInt(st.nextToken()); // Person 2 score

            int winner;
            int loser;

            if (p1s > p2s) {
                winner = p1;
                loser = p2;
            } else {
                winner = p2;
                loser = p1;
            }
            if (!graph.containsKey(winner))
                graph.put(winner, new HashSet<>());
            // Graph should put an edge from winner -> loser
            graph.get(winner).add(loser);
        }

        for (int x = 1; x <= people; x++) {
            // Count cyclic nodes
            cyclic = false;
            visited = new HashSet<>();
            if (dfs(x, x)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean dfs(int current, int start) {
        if (visited.contains(current) && current == start) {
            // Is cyclic
            cyclic = true;
            return true;
        }
        if (visited.contains(current)) {
            // Visited but not cyclic
            return true;
        }
        visited.add(current);
        if (!graph.containsKey(current))
            graph.put(current, new HashSet<>());
        for (int x : graph.get(current))
            dfs(x, start);
        return cyclic;
    }
}