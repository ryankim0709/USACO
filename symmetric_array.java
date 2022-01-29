import java.util.*;
import java.io.*;

public class symmetric_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] d = new long[2 * n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * n; j++) {
                d[j] = Long.parseLong(st.nextToken());
            }
            System.out.println(isSymmetric(d, n) ? "YES" : "NO");
        }
    }

    public static boolean isSymmetric(long[] d, int n) {
        HashSet<Double> a = new HashSet<>();
        Arrays.sort(d);

        int index = 2 * n - 1;
        int size = 2 * n;
        long sum = 0;

        while (size != 0) {
            // Check if the one before is same too
            if (d[index] != d[index - 1]) {
                return false;
            }
            // Check if even
            if (d[index] % 2 == 1) {
                return false;
            }

            Double value = (double) (d[index] - sum) / (double) size;
            if (value != Math.floor(value) || value < 1) {
                return false;
            }
            if (a.contains(value)) {
                return false;
            }
            a.add(value);
            index -= 2;
            sum += 2 * value;
            size -= 2;
        }
        return true;
    }
}
