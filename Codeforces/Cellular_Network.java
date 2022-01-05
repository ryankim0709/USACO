import java.util.*;
import java.io.*;

public class cellular_network {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cities = Integer.parseInt(st.nextToken());
        int towers = Integer.parseInt(st.nextToken());

        HashSet<Integer> cityLocation = new HashSet<>();
        TreeSet<Integer> towerLocation = new TreeSet<>();
        towerLocation.add(Integer.MAX_VALUE); // When there is no more towers on the right
        towerLocation.add(Integer.MIN_VALUE); // When there are no more towers on the left

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < cities; x++) {
            cityLocation.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < towers; x++) {
            towerLocation.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;

        int num1;
        int num2;

        for (int x : cityLocation) {
            num1 = towerLocation.floor(x); // Down
            num2 = towerLocation.ceiling(x); // Up

            if (num1 != Integer.MIN_VALUE) {
                num1 = Math.abs(x - num1);
            } else {
                num1 = Integer.MAX_VALUE;
            }

            if (num2 != Integer.MAX_VALUE) {
                num2 = Math.abs(num2 - x);
            }
            // System.out.println(ans + " " + num1 + " " + num2);
            ans = Math.max(ans, Math.min(num1, num2));
        }
        System.out.println(ans);
    }
}
