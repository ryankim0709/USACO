import java.util.*;
import java.io.*;

public class revegetation {
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();
    static HashMap<Integer, HashMap<Integer, Character>> graph1 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pastures = Integer.parseInt(st.nextToken());
        int cows = Integer.parseInt(st.nextToken());

        // scanning
        for (int x = 0; x < cows; x++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (!graph.containsKey(first))
                graph.put(first, new HashSet<>());
            if (!graph.containsKey(second))
                graph.put(second, new HashSet<>());

            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        br.close();
        // find the number of "unbroken pastures"

        String ans = "1";
        for (int x = 1; x <= pastures; x++) {
            if (!visited.contains(x)) {
                dfs(x);
                ans = ans + "0";
            }
            if (visited.size() == pastures) {
                break;
            }
        }

        pw.print(ans);
        pw.close();
    }

    public static void dfs(int current) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);

        if (!graph.containsKey(current))
            graph.put(current, new HashSet<>());
        for (int x : graph.get(current))
            dfs(x);
    }
}
