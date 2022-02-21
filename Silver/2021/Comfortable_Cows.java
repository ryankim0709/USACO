import java.util.*;
import java.io.*;

public class Comfortable_Cows {
    static class Cow {
        int x, y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] graph = new boolean[3000][3000];
    static Cow[] cows;
    static int N;
    static LinkedList<Cow> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> ans = simulate();
        for (int i = 0; i < N - 1; i++) {
            System.out.println(ans.get(i));
        }
        System.out.print(ans.get(N - 1));
    }
    
    public static ArrayList<Integer> simulate() {
        ArrayList<Integer> ans = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            Cow a = cows[i];
            int x = a.x + 1000;
            int y = a.y + 1000;
            q.add(new Cow(x, y));

            while (q.size() > 0) {
                Cow b = q.poll();
                x = b.x;
                y = b.y;

                if (graph[x][y]) {
                    continue;
                }

                graph[x][y] = true;
                total++;
                flood(x, y);
                flood(x + 1, y);
                flood(x - 1, y);
                flood(x, y + 1);
                flood(x, y - 1);
            }
            ans.add(total - i - 1);
        }
        return ans;
    }

    public static void flood(int x, int y) {
        if (graph[x][y] == false) {
            return;
        }
        int[] xAction = { 1, -1, 0, 0 };
        int[] yAction = { 0, 0, 1, -1 };

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + xAction[i];
            int ny = y + yAction[i];

            if (graph[nx][ny]) {
                count++;
            }
        }

        if (count == 3) {
            for (int i = 0; i < 4; i++) {
            int nx = x + xAction[i];
            int ny = y + yAction[i];

            if (!graph[nx][ny]) {
                q.add(new Cow(nx, ny));
                return;
            }
        }
        }
    }
}