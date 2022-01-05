import java.util.*;
import java.io.*;

public class meeting {
    public static double[] friendLocs;
    public static double[] friendSpeeds;

    public static double minTime = 10 ^ 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int friends = Integer.parseInt(br.readLine());

        friendLocs = new double[friends];
        friendSpeeds = new double[friends];

        double lo = Double.MAX_VALUE;
        double hi = Double.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int x = 0; x < friends; x++) {
            friendLocs[x] = Double.parseDouble(st.nextToken());
            lo = Math.min(lo, friendLocs[x]);
            hi = Math.max(hi, friendLocs[x]);
        }

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < friends; x++) {
            friendSpeeds[x] = Double.parseDouble(st.nextToken());
        }

        double mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            // canDo(mid);
            // System.out.println("Lo: " + lo + " hi: " + hi + " mid: " + mid + " minTime: "
            // + minTime);
            if (canDo(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            System.out.println("Lo: " + lo + " hi: " + hi + " mid: " + mid + " minTime: " + minTime);
        }
        System.out.println(minTime);
    }

    public static boolean canDo(Double loc) {
        double start;
        double speed;

        double time = 0;

        for (int x = 0; x < friendSpeeds.length; x++) {
            start = friendLocs[x];
            speed = friendSpeeds[x];

            start = Math.abs(loc - start);
            start = start / speed;

            time = Math.max(time, start);
        }
        if (time < minTime) {
            minTime = time;
            return true;
        }
        return false;
    }
}