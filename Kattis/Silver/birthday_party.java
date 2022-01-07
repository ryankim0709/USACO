import java.util.*;
import java.io.*;

public class birthday_party {
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (p == 0 && c == 0) {
                break;
            }

            Edge[] edges = new Edge[c];
            graph = new HashMap<>();
            for (int x = 0; x < c; x++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                if (!graph.containsKey(first))
                    graph.put(first, new HashSet<>());
                if (!graph.containsKey(second))
                    graph.put(second, new HashSet<>());

                graph.get(first).add(second);
                graph.get(second).add(first);
                edges[x] = new Edge(first, second);
            }

            String changed = "No";
            for (Edge a : edges) {
                graph.get(a.a).remove(a.b);
                graph.get(a.b).remove(a.a);
                visited = new HashSet<>();
                dfs(0);

                if (visited.size() != p)
                    changed = "Yes";
                graph.get(a.a).add(a.b);
                graph.get(a.b).add(a.a);
            }
            System.out.println(changed);
        }
    }

    public static void dfs(int current) {
        visited.add(current);
        if (!graph.containsKey(current))
            graph.put(current, new HashSet<>());
        for (int x : graph.get(current)) {
            if (!visited.contains(x)) {
                dfs(x);
            }
        }
    }

    static class Edge {
        int a, b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}