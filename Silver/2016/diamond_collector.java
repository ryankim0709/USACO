import java.util.*;
import java.io.*;

public class diamond_collector {
    static class subarray implements Comparable<subarray> {
        int left, right, len;

        public subarray(int left, int right, int len) {
            this.left = left;
            this.right = right;
            this.len = len;
        }

        public int compareTo(subarray a) {
            return a.len - this.len;
        }
    }

    static int[] sizes;
    static int N;
    static int K;

    static ArrayList<subarray> arrs = new ArrayList<>();

    static int[] test;

    public static void main(String[] args) throws IOException {

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sizes = new int[N];
        test = new int[N];

        for (int x = 0; x < N; x++) {
            sizes[x] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(sizes);
        twoPointer();

        Collections.sort(arrs);

        int ans = 0;

        int[] prefixMax = new int[500000];
        for (int x = N - 1; x >= 0; x--) {
            prefixMax[x] = Math.max(prefixMax[x + 1], test[x]);
        }

        for (int x = 0; x < N; x++) {
            int tempAns = test[x] + prefixMax[x + test[x]];
            ans = Math.max(ans, tempAns);
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
    }

    public static void twoPointer() {
        int left = 0;
        int right = 0;

        while (left < N) {
            while (right < N) {
                if (sizes[right] - sizes[left] <= K && right < N) {
                    right++;
                } else {
                    int len = right - left;
                    test[left] = len;
                    left++;
                }
            }
            if (right == N) {
                int len = N - left;
                test[left] = len;
                left++;
            }
        }
    }
}
