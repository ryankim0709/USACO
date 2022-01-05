import java.util.*;
import java.io.*;

public class array_division {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrLen = Integer.parseInt(st.nextToken());
        int arrays = Integer.parseInt(st.nextToken());

        int[] array = new int[arrLen];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < arrLen; x++) {
            array[x] = Integer.parseInt(st.nextToken());
            sum += array[x];
        }

        int low = 0;
        int high = sum;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            // System.out.println(mid + " " + low + " " + high);
            if (canFit(mid, arrays, array)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }

    public static boolean canFit(int target, int arrays, int[] array) {
        int currSum = 0;
        int arrsUsed = 0;

        for (int x : array) {
            currSum += x;
            if (currSum > target) {
                arrsUsed++;
                currSum = x;

                if (x > target) {
                    return false;
                }
            }
            if (arrsUsed == arrays) {
                return false;
            }
        }
        return true;
    }
}
