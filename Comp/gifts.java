import java.util.*;
import java.io.*;

public class gifts {
    static HashMap<Integer, int[]> list = new HashMap<>();
    static boolean[] test;
    static int[] in;
    static int n;
    static HashMap<Integer, Integer> ans = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        test = new boolean[n];
        in = new int[n];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.put(i, new int[n]);

            for (int j = 0; j < n; j++) {
                list.get(i)[j] = Integer.parseInt(st.nextToken());
                if (list.get(i)[j] == i) {
                    break;
                }
            }
        }
        dfs(1);
        for (int i : ans.values()) {
            System.out.println(i);
        }
    }

    public static void dfs(int cow) {
        if (cow == n + 1) {
            for (int i = 0; i < n; i++) {
                ans.putIfAbsent(i, 0);
                ans.put(i, higher(in[i], ans.get(i), i));
            }
            return;
        }

        for (int i : list.get(cow)) {
            if (i == 0) {
                continue;
            }

            if (!contains(i)) {
                in[cow - 1] = i;
                dfs(cow + 1);
                in[cow - 1] = 0;
            }
        }
    }
    
    public static boolean contains(int x) {
        for (int i : in) {
            if (x == i) {
                return true;
            }
        }
        return false;
    }

    public static int higher(int x, int y, int cow) {
        for (int i : list.get(cow + 1)) {
            if (i == x)
                return x;
            if (i == y)
                return y;
        }
        return 0;
    }
}
