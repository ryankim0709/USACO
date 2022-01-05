import java.util.*;
import java.io.*;

public class tree_diam {
    static HashSet<Integer> visited;
    static HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();

    static int furthest = 0;
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int branches = Integer.parseInt(br.readLine());

        int start = 0;
        for (int x = 0; x < branches - 1; x++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (!tree.containsKey(start))
                tree.put(start, new HashSet<>());
            if (!tree.containsKey(second))
                tree.put(second, new HashSet<>());

            tree.get(start).add(second);
            tree.get(second).add(start);
        }

        visited = new HashSet<>();
        dfsmax(start, 0);
        maxDist = 0;
        visited = new HashSet<>();
        dfsmax(furthest, 0);
        System.out.println(maxDist);
    }

    public static void dfsmax(int current, int distance) {
        if (visited.contains(current))
            return;

        visited.add(current);
        if (distance > maxDist) {
            maxDist = distance;
            furthest = current;
        }
        if (!tree.containsKey(current))
            tree.put(current, new HashSet<>());
        for (int x : tree.get(current))
            dfsmax(x, distance + 1);
    }
}
