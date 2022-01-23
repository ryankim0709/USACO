import java.util.*;
import java.io.*;

public class GCD_board {
    static final int maxN = 100000 + 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

<<<<<<< HEAD
        int[] orig = new int[maxN];
=======
        int[] orig = new int[N + 1];
>>>>>>> d285738 (smallest string concatenation)
        for (int x = 1; x <= N; x++) {
            orig[x] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[maxN];
        int[] suffix = new int[maxN];

        prefix[0] = 0;
        suffix[N + 1] = 0;

        for (int x = 1; x <= N; ++x) {
            prefix[x] = GCD(prefix[x - 1], orig[x]);
        }
        for (int x = N; x >= 1; --x) {
            suffix[x] = GCD(suffix[x + 1], orig[x]);
        }

        int ans = 1;

        for (int x = 1; x <= N; ++x) {
            ans = Math.max(ans, GCD(prefix[x - 1], suffix[x + 1]));
        }

        System.out.println(ans);
    }

    public static int GCD(int num1, int num2) {
<<<<<<< HEAD
        if (num2 != 0) {
            return GCD(num2, num1 % num2);
        }
        return num1;
=======
        return num2 != 0 ? GCD(num2, num1 % num2) : num1;
>>>>>>> d285738 (smallest string concatenation)
    }
}
