import java.util.*;
import java.io.*;

public class magic_ship {
    static int[] start = new int[2];
    static int[] end = new int[2];
    static HashMap<Character, Integer> cycle = new HashMap<>();
    static char[] cycleSpecs;
    static int cycleLen;
    static String winds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        cycleLen = Integer.parseInt(br.readLine());

        winds = br.readLine();

        cycle.put('U', 0);
        cycle.put('D', 0);
        cycle.put('L', 0);
        cycle.put('R', 0);

        cycleSpecs = new char[cycleLen];
        for (int x = 0; x < cycleLen; x++) {
            cycle.put(winds.charAt(x), cycle.get(winds.charAt(x)) + 1);
            cycleSpecs[x] = winds.charAt(x);
        }
        // System.out.println(cycle);

        long lo = 0;
        long hi = Long.MAX_VALUE;
        long mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            // System.out.println("HI: " + hi + " LOW: " + lo);
            if (valid(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (hi == Long.MAX_VALUE) {
            hi = -1;
        }
        System.out.println(hi);
        // System.out.println(valid(5));
    }

    public static boolean valid(long days) {
        long cycles = days / cycleLen;
        long remainder = days % cycleLen;

        long[] startCoord = new long[2];
        startCoord[0] = start[0];
        startCoord[1] = start[1];

        long up = cycle.get('U') * cycles;
        long down = cycle.get('D') * cycles;
        long left = cycle.get('L') * cycles;
        long right = cycle.get('R') * cycles;

        startCoord[0] = startCoord[0] + right - left;
        startCoord[1] = startCoord[1] + up - down;

        for (int x = 0; x < remainder; x++) {
            char a = winds.charAt(x);

            if (a == 'U')
                startCoord[1]++;
            if (a == 'D')
                startCoord[1]--;
            if (a == 'R')
                startCoord[0]++;
            if (a == 'L')
                startCoord[0]--;

        }
        long dist = Math.abs(startCoord[0] - end[0]) + Math.abs(startCoord[1] - end[1]);
        // System.out.println(
        // "X: " + startCoord[0] + " Y: " + startCoord[1] + " Distance: " + dist + "
        // result: " + (dist <= days));

        return dist <= days;
    }
}
