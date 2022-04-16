import java.util.*;
import java.io.*;

public class tree_diam {
    static HashSet<Integer> visited = new HashSet<>();

    static int maxOne = 0;
    static int maxStepOne = 0;
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(first, new HashSet<>());
            graph.putIfAbsent(second, new HashSet<>());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        dfs(1, 0);
        int temp = maxOne;
        maxOne = 0;
        maxStepOne = 0;
        visited = new HashSet<>();
        dfs(temp, 0);
        System.out.println(maxStepOne);
    }
    public static void dfs(int current, int steps) {
        if(visited.contains(current)) {
            return;
        }
        if(steps > maxStepOne) {
            maxStepOne = steps;
            maxOne = current;
        }
        visited.add(current);

        graph.putIfAbsent(current, new HashSet<>());
        for(int i:graph.get(current)) {
            dfs(i, steps + 1);
        }
    }
}