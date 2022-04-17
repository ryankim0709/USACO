import java.util.*;
import java.io.*;

public class painting_the_barn {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int squares = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int x1, y1, x2, y2;

        int[][] grid = new int[1001][1001];
        for (int x = 0; x < squares; x++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            grid[x1][y1]++;
            grid[x1][y2]--;
            grid[x2][y1]--;
            grid[x2][y2]++;
        }

        int[][] prefix = new int[1001][1001];

        int ans = 0;
        for (int x = 0; x < 1001; x++) {
            for (int y = 0; y < 1001; y++) {
                if (x != 0) {
                    prefix[x][y] = prefix[x - 1][y];
                }
                if (y != 0) {
                    prefix[x][y] += prefix[x][y - 1];
                }
                if (x != 0 && y != 0) {
                    prefix[x][y] -= prefix[x - 1][y - 1];
                }
                prefix[x][y] += grid[x][y];
                if (prefix[x][y] == k) {
                    ans++;
                }
            }
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
        br.close();
    }
}
