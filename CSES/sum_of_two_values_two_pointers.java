import java.util.*;
import java.io.*;

public class sum_of_two_values_two_pointers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] nums = new int[len];
        HashMap<Integer, ArrayList<Integer>> index = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        int num;
        for (int x = 0; x < len; x++) {
            num = Integer.parseInt(st.nextToken());
            if (!index.containsKey(num)) {
                index.put(num, new ArrayList<>());
            }
            index.get(num).add(x + 1);
            nums[x] = num;
        }

        Arrays.sort(nums);

        int pointer1 = 0; // left
        int pointer2 = 0; // right

        while (pointer1 < len - 1) {
            pointer2 = pointer1 + 1;
            if (nums[pointer2] + nums[pointer1] > goal) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            while (pointer2 < len) {
                if (nums[pointer1] + nums[pointer2] == goal) {
                    int num1 = index.get(nums[pointer1]).get(0);
                    index.get(nums[pointer1]).remove(index.get(nums[pointer1]).get(0));
                    int num2 = index.get(nums[pointer2]).get(0);
                    System.out.println(num1 + " " + num2);
                    return;
                } else if (nums[pointer1] + nums[pointer2] > goal) {
                    break;
                }
                pointer2++;
            }
            pointer1++;
        }
        System.out.println("IMPOSSIBLE");
    }
}
