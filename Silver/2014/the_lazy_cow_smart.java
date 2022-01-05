import java.util.*;
import java.io.*;

public class the_lazy_cow_smart {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lazy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lazy.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[2 * n + 1][2 * n + 1];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < n; y++) {
                grid[x + y][n - x + y - 1] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int[] x : grid) {
        // System.out.println();
        // for (int y : x) {
        // if (y < 10) {
        // System.out.print(" " + y + " ");
        // } else {
        // System.out.print(y + " ");
        // }
        // }
        // }

        int ans = 0;
        int t = (n + 1) % 2;
        n = 2 * n - 1;
        int sum;
        for (int a = 0; a < n; a++, t = 1 - t) {
            sum = 0;

            // starting square
            for (int x = Math.max(0, a - k); x <= a + k && x < n; x++) { // row
                for (int y = Math.max(0, t - k); y < n && y <= t + k; y++) { // column
                    sum += grid[x][y];
                }
            }
            ans = Math.max(sum, ans);

            for (int y = t + 1; y < n - k; y++) { // column
                for (int z = Math.max(0, a - k); z <= a + k && z < n; z++) { // row
                    sum += grid[z][y + k];
                    sum -= y - k - 1 >= 0 ? grid[z][y - k - 1] : 0;
                }
                if (y % 2 == t) {
                    ans = Math.max(sum, ans);
                }
            }
        }
        // System.out.println(ans);
        pw.print(ans);
        br.close();
        pw.close();
    }
}
