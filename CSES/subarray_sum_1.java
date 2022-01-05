import java.util.*;
import java.io.*;

public class subarray_sum_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputs = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] list = new int[inputs + 1];

        st = new StringTokenizer(br.readLine());

        for (int x = 1; x <= inputs; x++) {
            list[x] = list[x - 1] + Integer.parseInt(st.nextToken());
        }
        // for (int x : list) {
        // System.out.print(x + " ");
        // }
        // System.out.println();
        int ans = 0;
        for (int x = 1; x <= inputs; x++) {
            for (int y = 1; y <= x; y++) {
                // System.out.println("Start: " + x + " End: " + y);
                if (x == y && list[x] == goal) {
                    ans++;
                } else if (list[x] - list[y] == goal) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
