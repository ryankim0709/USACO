import java.util.*;
import java.io.*;

public class mootube_object {
    public static HashMap<Integer, HashSet<node>> adjList = new HashMap<>();
    public static HashSet<Integer> visited = new HashSet<>();
    public static int ans = 0;

    public static class node {
        int to;
        int rel;

        public node(int to, int rel) {
            this.to = to;
            this.rel = rel;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int questions = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= cows; x++) {
            adjList.put(x, new HashSet<>());
        }

        int val1;
        int val2;
        int rel;

        for (int x = 0; x < cows - 1; x++) {
            st = new StringTokenizer(br.readLine());
            val1 = Integer.parseInt(st.nextToken());
            val2 = Integer.parseInt(st.nextToken());
            rel = Integer.parseInt(st.nextToken());
            adjList.get(val1).add(new node(val2, rel));
            adjList.get(val2).add(new node(val1, rel));
        }

        int start;
        int k;
        for (int x = 0; x < questions; x++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited = new HashSet<>();
            ans = 0;

            visited.add(start);

            for (node a : adjList.get(start)) {
                dfs(a.to, k, a.rel);
            }
            pw.println(ans);
        }
        pw.close();
        br.close();
    }

    public static void dfs(int current, int k, int currRel) {
        if (visited.contains(current)) {
            return;
        }

        visited.add(current);
        if (currRel >= k) {
            ans++;
        }
        for (node a : adjList.get(current)) {
            dfs(a.to, k, Math.min(currRel, a.rel));
        }
    }
}
