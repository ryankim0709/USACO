import java.util.*;
import java.io.*;

public class connecting_two_barns {
    static HashMap<Integer, HashSet<Integer>> paths = new HashMap<>();
    static int maxNum = 0;
    static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            paths = new HashMap<>();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int loc1 = Integer.parseInt(st.nextToken());
                int loc2 = Integer.parseInt(st.nextToken());
                paths.putIfAbsent(loc1, new HashSet<>());
                paths.putIfAbsent(loc2, new HashSet<>());
                paths.get(loc1).add(loc2);
                paths.get(loc2).add(loc1);
            }

            max = new int[N + 1];

            int leftGoal = 0;
            int rightGoal = Integer.MAX_VALUE;

            for (int j = N; j >= 1; j--) {
                maxNum = j;
                dfs(j, j);
                if (max[j] == N) {
                    rightGoal = Math.min(rightGoal, j);
                }
            }
            leftGoal = max[1];

            long ans = Integer.MAX_VALUE;
            for (int j = leftGoal; j <= rightGoal; j++) {
                long left = j;
                long right = max[j];

                long leftCost = (left - leftGoal) * (left - leftGoal);
                long rightCost = (rightGoal - right) * (rightGoal - right);
                ans = Math.min(ans, leftCost + rightCost);
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int current, int min) {
        max[current] = Math.max(max[current], min);

        paths.putIfAbsent(current, new HashSet<>());
        for (int i : paths.get(current)) {
            if (max[i] < min) {
                dfs(i, min);
            }
        }
    }
}
