import java.io.*;
import java.util.*;

public class the_lazy_cow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < n; y++) {
                grid[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefix = new int[n][n];
        prefix[0][0] = grid[0][0];

        for (int x = 1; x < n; x++) {
            prefix[0][x] = prefix[0][x - 1] + grid[0][x];
        }

        for (int x = 1; x < n; x++) {
            prefix[x][0] += prefix[x - 1][0] + grid[x][0];
        }

        for (int x = 1; x < n; x++) {
            for (int y = 1; y < n; y++) {
                prefix[x][y] = grid[x][y] + prefix[x - 1][y] + prefix[x][y - 1] - prefix[x - 1][y - 1];
            }
        }

        for (int[] x : grid) {
            System.out.println();
            for (int y : x) {
                System.out.print(y + " ");
            }
        }
        System.out.println();
        for (int[] x : prefix) {
            System.out.println();
            for (int y : x) {
                System.out.print(y + " ");
            }
        }

        int max = 0;
        int sum = 0;
        for (int x = k; x < n - k; x++) {
            for (int y = k; y < n - k; y++) {
                sum = findStar(x, y, k, prefix, grid);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println();
        System.out.println(max);
    }

    public static int findStar(int x, int y, int k, int[][] prefix, int[][] grid) {
        int tlrow = x - k + 1;
        int tlcolumn = y - k + 1;

        int brrow = x + k - 1;
        int brcolumn = y + k - 1;

        int sum = prefix[brrow][brcolumn] - prefix[tlrow - 1][brcolumn] - prefix[brcolumn][tlcolumn - 1]
                + prefix[tlrow - 1][tlcolumn - 1] + grid[x][y - k] + grid[x][y + k] + grid[x - k][y] + grid[x + k][y];
        return sum;
    }
}
