import java.util.*;
import java.io.*;

public class Main {
    static int startX, startY, endX, endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        br.readLine();
        String actions = br.readLine();

        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(check(mid, actions)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if(lo == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(lo);
        }
    }

    public static boolean check(int days, String change) {
        int xChange = 0;
        int yChange = 0;
        int len = change.length();
        for(int i = 0; i < days; i++) {
            char action = change.charAt(i % len);
            if(action == 'U') yChange ++;
            else if(action == 'D') yChange --;
            else if(action == 'L') xChange --;
            else xChange ++;
        }

        int newX = startX + xChange;
        int newY = startY + yChange;
        int dist = Math.abs(endX - newX) + Math.abs(endY - newY);
        return dist <= days;
    }
}