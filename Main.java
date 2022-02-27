import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();
    static int ans = 0;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        counts = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.putIfAbsent(x, new HashSet<>());
            tree.putIfAbsent(y, new HashSet<>());

            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        //System.out.println(tree);
        dfs(1, 0);
        // for (int i : counts) {
        //     System.out.println(i);
        // }
        dfsans(1, 0);
        System.out.println(ans);
    }
    
    public static void dfs(int curr, int prev) {
        tree.putIfAbsent(curr, new HashSet<>());

        for (int i : tree.get(curr)) {
            if(i != prev) {
                dfs(i, curr);
                counts[curr] = Math.max(counts[curr], counts[i] + 1);
            }
        }
    }

    public static void dfsans(int curr, int prev) {
        int[] greatest = new int[2];
        for (int i : tree.get(curr)) {
            if (counts[i] > greatest[0]) {
                greatest[0] = counts[i];
            } else if (counts[i] > greatest[1]) {
                greatest[1] = counts[i];
            }
        }
        ans = Math.max(ans, greatest[0] + greatest[1] + 2);

        for (int i : tree.get(curr)) {
            if (i != prev) {
                dfsans(i, curr);
            }
        }
    }
}
