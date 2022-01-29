import java.util.*;
import java.io.*;

public class GCD_board {
    static final int MAX_N = (int) 1e5 + 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int x = 1; x <= N; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        int[] gcdPrefix = new int[MAX_N];
        int[] gcdSuffix = new int[MAX_N];
        for (int x = 1; x <= N; ++x) {
            gcdPrefix[x] = gcd(gcdPrefix[x - 1], arr[x]);
        }
        for (int x = N; x >= 1; --x) {
            // GCD for suffix
            gcdSuffix[x] = gcd(gcdSuffix[x + 1], arr[x]);
        }

        int ans = 1;
        // We are going to remove the element at index x
        for (int x = 1; x <= N; ++x) {
            /*
             * Removing the element at index x is the same as finding the GCD from 0 to x -
             * 1
             * and the GCD from x + 1 to n - 1
             */
            ans = Math.max(ans, gcd(gcdPrefix[x - 1], gcdSuffix[x + 1]));
        }
        System.out.println(ans);
    }

    public static int gcd(int num1, int num2) {
        // How to quickly find GCD
        return num2 != 0 ? gcd(num2, num1 % num2) : num1;
    }
}