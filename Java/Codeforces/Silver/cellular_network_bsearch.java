import java.util.*;
import java.io.*;

public class cellular_network_bsearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cities = Integer.parseInt(st.nextToken());
        int towers = Integer.parseInt(st.nextToken());

        int[] cityLocation = new int[cities];
        int[] towerLocation = new int[towers + 2];
        towerLocation[0] = Integer.MAX_VALUE;
        towerLocation[1] = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < cities; x++) {
            cityLocation[x] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int x = 2; x <= towers + 1; x++) {
            towerLocation[x] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(towerLocation);
        // for (int x : towerLocation) {
        // System.out.print(x + " ");
        // }
        // System.out.println();

        int ans = 0;

        for (int city : cityLocation) {
            ans = Math.max(ans, binarySearch(city, towerLocation));
        }
        System.out.println(ans);
    }

    public static int binarySearch(int cityLocation, int[] towerLocation) {
        int low = 0;
        int high = towerLocation.length;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (towerLocation[mid] < cityLocation) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (high != towerLocation.length - 1) {
            right = towerLocation[high] - cityLocation;
        }

        if (high > 1) {
            left = cityLocation - towerLocation[high - 1];
        }
        // System.out.println("Right: " + right + " left: " + left + " high: " + high +
        // " low: " + low + " "
        // + "City Lcation: " + cityLocation + " Return: " + Math.min(left, right));
        return Math.min(left, right);
    }
}
