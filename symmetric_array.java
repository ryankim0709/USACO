import java.util.*;
import java.io.*;

public class symmetric_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i ++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] arr = new long[n * 2];
            for(int j = 0; j < 2 * n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(arr);

            int size = 2 * n;
            int ind = 2 * n - 1;
            long total = 0;

            HashSet<Double> possible = new HashSet<>();

            boolean yes = true;

            while(size != 0) {
                if(arr[ind] != arr[ind - 1] || arr[ind] % 2 == 1) {
                    yes = false;
                    break;
                }

                double value = (double) (arr[ind] - total) / (double) size;
                if(value != Math.floor(value) || possible.contains(value) || value <= 0) {
                    yes = false;
                    break;
                }

                possible.add(value);
                total += 2 * value;
                size -= 2;
                ind -= 2;
            }
            System.out.println(yes ? "YES" : "NO");
        }
    }
}