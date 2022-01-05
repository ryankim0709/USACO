import java.util.*;
import java.io.*;

public class meeting_place {
    static double lo = Double.MAX_VALUE;
    static double hi = -1;

    static double[] friendLoc;
    static double[] friendSpeeds;
    static int numFriends;

    static double minTime = Double.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numFriends = Integer.parseInt(br.readLine());

        friendLoc = new double[numFriends];
        friendSpeeds = new double[numFriends];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < numFriends; x++) {
            friendLoc[x] = Double.parseDouble(st.nextToken());
            lo = Math.min(lo, friendLoc[x]);
            hi = Math.max(hi, friendLoc[x]);
        }

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < numFriends; x++)
            friendSpeeds[x] = Double.parseDouble(st.nextToken());

        double mid;

        while ((hi - lo) >= (0.000001) && lo < hi) {
            mid = lo + (hi - lo) / 2;
            closeToMax(mid);
        }

        if (minTime == Double.MAX_VALUE) {
            minTime = 0.0;
        }
        System.out.println(minTime);

    }

    public static void closeToMax(Double to) {
        double maxPerson = -1.0;
        double maxTime = -1.0;

        double time;
        for (int x = 0; x < numFriends; x++) {
            time = Math.abs(to - friendLoc[x]);
            time = time / friendSpeeds[x];

            if (time > maxTime) { // what if times are all 0 seconds?
                maxTime = time;
                maxPerson = friendLoc[x];
            }
        }
        minTime = Math.min(minTime, maxTime);
        // System.out.println("MAXPERSON: " + maxPerson);
        if (maxPerson > to) {
            lo = to;
        } else {
            hi = to;
        }
    }
}
