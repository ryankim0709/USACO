import java.util.*;
import java.io.*;

public class diamond_collector {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        br.close();

        // Two pointer one
        int p1 = 0;
        int p2 = 0;

        int max = 0;
        int maxp1 = 0;
        int maxp2 = 0;

        while(p2 != N - 1) {
            // Check length
            if(arr[p2] - arr[p1] > K) {
                p1 ++;
            } else {
                if(p2 - p1 > max) {
                    max = p2 - p1;
                    maxp1 = p1;
                    maxp2 = p2;
                }
                p2 ++;
            }
        }
        
        int ans = maxp2 - maxp1 + 1;

        max = 0;
        p1 = 0;
        p2 = 0;

        int max2p1 = 0;
        int max2p2 = 0;

        while(p2 <= N - 1) {
            if(p2 == maxp1) {
                p2 = maxp2 + 1;
            }
            if(p1 == maxp1) {
                p1 = maxp2 + 1;
            }
            if(arr[p2] - arr[p1] > K) {
                p1 ++;
            } else {
                if(p2 - p1 >= max) {
                    max = p2 - p1;
                    max2p1 = p1;
                    max2p2 = p2;
                }
                p2 ++;
            }
        }
        //System.out.println(ans + max2p2 - max2p1 + 1);
        pw.print(ans + max2p2 - max2p1 + 1);
        pw.close();
    }
}