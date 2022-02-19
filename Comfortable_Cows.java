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

    static LinkedList<Cow> q = new LinkedList<>();
    static boolean[][] present = new boolean[3000][3000];
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y);
        }
        ArrayList<Integer> result = comfortable(cows);
        for (int i = 0; i < N - 1; i++) {
            System.out.println(result.get(i));
        }
        System.out.print(result.get(N - 1));
    }

    public static ArrayList<Integer> comfortable(Cow[] cows) {
        int total_cows = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            Cow a = cows[i - 1];
            int x = a.x + 1000;
            int y = a.y + 1000;
            q.add(new Cow(x, y));

            while (q.size() > 0) {
                Cow b = q.poll();

                int bx = b.x;
                int by = b.y;

                if (present[bx][by])
                    continue;

                total_cows += 1;
                present[bx][by] = true;
                ff_evaluate(bx, by);

                int[] xAction = { 1, -1, 0, 0 };
                int[] yAction = { 0, 0, 1, -1 };
                for (int j = 0; j < 4; j++) {
                    int nx = bx + xAction[j];
                    int ny = by + yAction[j];
                    ff_evaluate(nx, ny);
                }
            }
            ans.add(total_cows - i);
        }
        return ans;
    }
    
    public static void ff_evaluate(int x, int y) {
        if (!present[x][y])
            return;
        
        int num_adj = 0;

        int[] xAction = { 1, -1, 0, 0 };
        int[] yAction = { 0, 0, 1, -1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + xAction[i];
            int ny = y + yAction[i];

            if (present[nx][ny])
                num_adj++;
        }

        if (num_adj == 3) {
            for (int i = 0; i < 4; i++) {
            int nx = x + xAction[i];
            int ny = y + yAction[i];

            if (!present[nx][ny])
                q.add(new Cow(nx, ny));
            }
        }
    }
}