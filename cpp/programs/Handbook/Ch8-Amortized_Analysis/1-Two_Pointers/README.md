# Two pointers Method

As the name suggests, in the two pointer method, there are two pointers that are used to iterate through an array. Both pointers can only move in one direction (to the end), which ensures that the algorithm works efficienty. We will not discuss two classic two pointer problems.

## Subarray Sum
In this problem, we are given an array of `n` positive integers and a target sum `x`. Our task is to find whether there is a subarray that has a sum of `x`. To solve this problem, we will be moving our right pointer as far as possible. If `currSum + arr[curr] > x`, then we must move our left pointer to the right to decrease our sum. Using this approach, we can find all of the possible subarray sums that are less than or equal to `x`. If our sum happens to equal `x`, then we have found a solution!

```cpp
// Subarray Sum Solution
// Complexity O(n)

int main() {
    int n; // Array Size
    int x; // Target Sum
    cin >> n;
    cin >> x;
    int arr[n];

    for (int i = 0; i < n; i++) 
        cin >> arr[i];

    int p1 = 0;
    int p2 = 0;
    int currSum = arr[0];

    while(p2 < n && p1 < n) {
        if(currSum == x) {
            cout << "Found! Between Index " << p1 << " and " << p2 << "\n";
            break;
        }
        int nextRight = p2 + 1;
        if(nextRight == n) {
            p1++;
            continue;
        } else if(currSum + arr[nextRight] <= x) { // If we can add the next element without overflowing
            currSum += arr[nextRight];
            p2++;
        } else if(currSum + arr[nextRight] > x) { // Otherwise ....
            currSum -= arr[p1];
            p1++;
        }
    }
}
```
## 2SUM Problem
This problem is fairly similar to the Subarray problem. Given an array of `n` numbers and a target sum `x`, find two array values that have a sum of `x`. Our approach is a a little modified from the previous problem. In this problem, we first sort our array of `n` numbers. Then, we set pointer 1 to start at `0` and pointer to start at `n - 1`. After calculating `currSum`, if `currSum > x`, then `p2--` will decease the sum since the values are sorted. Similarly, if `currSum < x`, then `p1++` will increase the sum. SUing this property, we can see the following solution.

```cpp
// 2Sum Solution
// Complexity O(nlogn)
int main() {
    int n, x;
    cin >> n;
    cin >> x;
    int tsum[n];

    for (int i = 0; i < n; i++) 
        cin >> tsum[i];

    sort(tsum, tsum + n);

    p1 = 0;
    p2 = n - 1;
    while(p1 < p2) {
        int currSum = tsum[p1] + tsum[p2];
        if(currSum == x) {
            cout << tsum[p1] << " and " << tsum[p2] << " exist in the array and sum to " << x;
            break;
        }
        if(currSum > x) {
            p2--;
        } else {
            p1++;
        }
    }
}
```