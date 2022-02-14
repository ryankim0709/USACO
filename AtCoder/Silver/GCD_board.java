import java.util.*;
import java.io.*;
public class GCD_board {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int[] prefix = new int[N + 1];
        int[] suffix = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            prefix[i] = GCD(arr[i-1], prefix[i-1]);
            suffix[N-i] = GCD(arr[N-i], suffix[N-i+1]);
        }
        
        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans = Math.max(ans, GCD(prefix[i], suffix[i+1]));
        }
        System.out.println(ans);
    }

    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}