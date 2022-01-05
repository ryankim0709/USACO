import java.util.*;
import java.io.*;

public class sum_of_two_values {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> nums = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int num;

        for (int x = 0; x < len; x++) {
            num = Integer.parseInt(st.nextToken());

            if (nums.containsKey(goal - num)) {
                System.out.println(
                        Math.min(x + 1, nums.get(goal - num) + 1) + " " + Math.max(x + 1, nums.get(goal - num) + 1));
                break;
            } else {
                nums.put(num, x);
            }

            if (x == len - 1) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
