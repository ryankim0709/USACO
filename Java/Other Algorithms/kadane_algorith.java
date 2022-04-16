public class kadane_algorith {
    public static void main(String[] args) {
        int[] arr = { -1, -2, -4, -8, -3, -8, -5 };

        int maxSum = Integer.MIN_VALUE;

        int currSum = 0;

        for (int x : arr) {
            currSum += x;
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(0, currSum);
        }
        System.out.println(maxSum);
    }
}
