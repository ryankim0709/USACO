import java.util.*;
import java.io.*;

public class angry_cows {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bales = Integer.parseInt(st.nextToken());
        int cows = Integer.parseInt(st.nextToken());

        int[] baleLocations = new int[bales];

        for (int x = 0; x < bales; x++) {
            baleLocations[x] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(baleLocations);

        int radius = 0;

        int low = 0;
        int high = 1_000_000_000;

        while (low < high) {
            radius = low + (high - low) / 2;

            if (canHitAll(radius, cows, baleLocations)) {
                high = radius;
            } else {
                low = radius + 1;
            }
        }

        // System.out.println();
        // System.out.println(canHitAll(3, cows, baleLocations));
        System.out.println(high);
        pw.println(high);
        pw.close();
        br.close();
    }

    public static boolean canHitAll(int radius, int cows, int[] baleLocations) {
        // 1 3 8 10 18 20 25
        if (cows == 1) {
            if (2 * radius >= baleLocations[baleLocations.length - 1] - baleLocations[0]) {
                return true;
            }
            return false;
        }
        int end = baleLocations[0];

        int low_idx = 0;
        int high_idx = baleLocations.length - 1;
        int mid_idx;

        for (int x = 0; x < cows; x++) {
            end = baleLocations[low_idx] + 2 * radius;
            if (end >= baleLocations[baleLocations.length - 1]) {
                return true;
            }
            high_idx = baleLocations.length - 1;

            // binary search
            while (low_idx <= high_idx) {
                mid_idx = low_idx + (high_idx - low_idx) / 2;

                if (baleLocations[mid_idx] > end) {
                    high_idx = mid_idx - 1;
                } else {
                    low_idx = mid_idx + 1;
                }
            }
            if (low_idx >= baleLocations.length - 1) {
                return true;
            }
        }
        return false;
    }
}
