import java.util.*;
import java.io.*;

public class good_subarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 0; x < cases; x++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();

            int[] orig = new int[len];
            for (int y = 0; y < len; y++) {
                orig[y] = Character.getNumericValue(line.charAt(y));
            }
            int[] prefix = new int[len + 1];

            for (int y = 1; y <= len; y++) {
                prefix[y] = prefix[y - 1] + orig[y - 1];
            }

            HashMap<Integer, Integer> dp = new HashMap<>();
            for (int y = 0; y <= len; y++) {
                int val = prefix[y] - y;
                dp.putIfAbsent(val, 0);
                dp.put(val, dp.get(val) + 1);
            }

            Long ans = Long.valueOf(0);
            for (int y : dp.values()) {
                if (y < 2) {
                    continue;
                } else {
                    ans += Long.valueOf(Long.valueOf(y) * Long.valueOf(y - 1)) / 2;
                }
            }
            System.out.println(ans);
        }
    }
}