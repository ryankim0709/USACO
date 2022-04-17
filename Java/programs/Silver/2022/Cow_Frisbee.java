import java.util.*;
import java.io.*;

public class Cow_Frisbee {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] cows = new long[N];
        long[] rev = new long[N];
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            cows[i] = num;
            rev[N - i - 1] = num;
        }

        System.out.println(greatest1(cows) + greatest1(rev));
    }

    public static long greatest1(long[] cows) {
        long ans = 0;
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && cows[s.peek()] < cows[i]) {
                // If not empty and (last_cow_in_statck) < current cow
                ans += (i - s.peek() + 1);
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
}