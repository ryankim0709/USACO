package Java;
import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    static HashMap<Integer, Integer> info = new HashMap<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
            info.put(i, 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
            System.out.println((info.size() - 1) + " " + max);
        }
    }

    public static void union(int x, int y) {
        int c = find(x);
        int d = find(y);

        if (c != d) {
            int val = Math.min(c, d);
            parents[c] = val;
            parents[d] = val;
            info.put(val, info.get(val) + info.get(Math.max(c, d)));
            info.remove(Math.max(c, d));
            if (info.get(val) > max) {
                max = info.get(val);
            }
        }
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        else {
            return parents[x] = find(parents[x]);
        }
    }
}