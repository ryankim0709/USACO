import java.util.*;
import java.io.*;

public class wheres_bessie {
    static class pcl {
        int x1, x2, y1, y2;

        public pcl(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static ArrayList<pcl> total = new ArrayList<>();
    static char[][] graph;
    static char[][] cloned;
    static int N;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        for (int x = 0; x < N; x++) {
            String line = br.readLine();
            for (int y = 0; y < N; y++) {
                graph[x][y] = line.charAt(y);
            }
        }
        br.close();
        for (int x1 = 0; x1 < N; x1++) {
            for (int y1 = 0; y1 < N; y1++) {
                for (int x2 = 0; x2 < N; x2++) {
                    for (int y2 = 0; y2 < N; y2++) {
                        if (is_pcl(x1, y1, x2, y2)) {
                            total.add(new pcl(x1, y1, x2, y2));
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (pcl a : total) {
            if (is_max_pcl(a)) {
                ans++;
            }
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
    }

    public static boolean is_pcl(int x1, int y1, int x2, int y2) {
        cloned = new char[N][N];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                cloned[x][y] = graph[x][y];
            }
        }
        int color = 0;
        int[] colors = new int[26];

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (cloned[x][y] != '-') {
                    int c = (int) cloned[x][y] - (int) 'A';
                    if (colors[c] == 0) {
                        color++;
                    }
                    colors[c] += 1;
                    dfs(x, y, graph[x][y]);
                }
            }
        }
        if (color != 2) {
            return false;
        }
        boolean one = false;
        boolean multiple = false;
        for (int x : colors) {
            if (x == 1) {
                one = true;
            }
            if (x > 1) {
                multiple = true;
            }
        }
        return one && multiple;
    }

    public static void dfs(int x, int y, char color) {
        if (x < 0 || y < 0 || x >= N || y >= N || cloned[x][y] != color) {
            return;
        }
        cloned[x][y] = '-';
        dfs(x - 1, y, color);
        dfs(x + 1, y, color);
        dfs(x, y - 1, color);
        dfs(x, y + 1, color);
    }

    public static boolean is_max_pcl(pcl a) {
        for (pcl b : total) {
            if (a == b)
                continue;
            if (inside(a, b)) {
                return false;
            }
        }
        return true;
    }

    public static boolean inside(pcl a, pcl b) {
        return a.x1 >= b.x1 && a.y1 >= b.y1 && a.x2 <= b.x2 && a.y2 <= b.y2;
    }
}
