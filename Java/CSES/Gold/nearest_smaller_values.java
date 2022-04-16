import java.util.*;
import java.io.*;

public class nearest_smaller_values {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] vals = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>(); // Keep count of index
        stk.add(0);

        for (int i = 1; i <= N; i++) {
            int valToBeat = vals[i];
            while (vals[stk.peek()] > valToBeat) {
                stk.pop();
            }
            System.out.print(stk.peek() + " ");
            stk.add(i);
        }
    }
}