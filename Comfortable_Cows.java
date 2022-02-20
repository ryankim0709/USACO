import java.util.*;
import java.io.*;

public class Comfortable_Cows {
    /*
    Get all of the cows in an array
    
    flood() function : Figure out how many cows you need to add after each addition of a cow
    - Check if cow is present
    - Check neighbors
        - If there are three
            - Find the fourth one
            - Add to queue
        - else return
    
    simulate()
    - Add cows one by one
        - BFS after adding every cow
            - Use BFS because easier to code
            - Works better with matrix
    
            get the cow queue.poll()
            is present ? continue : checkAround
            add one to total
            presnet = true
            call flood() w/ curr pos
            Check the neighbors as well because the new point could influence the points around it
                - call flood() with neighboring coordinates
    
    */
    static class Cow {
        int x, y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Cow[] cows;
    static boolean[][] present = new boolean[3000][3000];
    static LinkedList<Cow> d = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y);
        }

        ArrayList<Integer> result = simulate();
        for (int i = 0; i < N - 1; i++) {
            System.out.println(result.get(i));
        }
        System.out.print(result.get(N - 1));
    }
    
    public static ArrayList<Integer> simulate() {
        ArrayList<Integer> ans = new ArrayList<>();
        int total = 0;

        for (int i = 1; i <= N; i++) {
            int x = cows[i - 1].x + 1000;
            int y = cows[i - 1].y + 1000;
            d.add(new Cow(x, y));

            while (d.size() > 0) {
                Cow a = d.poll();
                x = a.x;
                y = a.y;

                if (present[x][y])
                    continue;

                total++;
                present[x][y] = true;
                ff(x, y);
                ff(x - 1, y);
                ff(x + 1, y);
                ff(x, y - 1);
                ff(x, y + 1);
            }
            ans.add(total - i);
        }
        return ans;
    }
    
    public static void ff(int x, int y) {
        if (present[x][y] == false) {
            return;
        }
        int[] xAction = { 1, -1, 0, 0 };
        int[] yAction = { 0, 0, 1, -1 };

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + xAction[i];
            int ny = y + yAction[i];
            if (present[nx][ny]) {
                count++;
            }
        }

        if (count == 3) {
            for (int i = 0; i < 4; i++) {
                int nx = x + xAction[i];
                int ny = y + yAction[i];
                
                if (!present[nx][ny]) {
                    d.add(new Cow(nx, ny));
                }
            }
        }
    }
}