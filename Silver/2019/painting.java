import java.util.*;
import java.io.*;

public class painting {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rects = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] orig = new int[1001][1001];
        for (int x = 0; x < rects; x++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            orig[x1][y1]++;
            orig[x2][y1]--;
            orig[x1][y2]--;
            orig[x2][y2]++;
        }
        br.close();
        int ans = 0;

        int[][] prefix = new int[1001][1001];
        for (int x = 0; x <= 1000; x++) {
            for (int y = 0; y <= 1000; y++) {
                prefix[x][y] = orig[x][y];
                if (x == 0 && y == 0)
                    continue;
                else if (x == 0)
                    prefix[x][y] += prefix[x][y - 1];
                else if (y == 0)
                    prefix[x][y] += prefix[x - 1][y];
                else
                    prefix[x][y] += prefix[x - 1][y] + prefix[x][y - 1] - prefix[x - 1][y - 1];

                if (prefix[x][y] == k)
                    ans++;
            }
        }
        pw.print(ans);
        pw.close();
    }
}