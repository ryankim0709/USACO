# Longest Increasing Subsequence
In this problem, we are tasked to find the **longest increasing subsequence** in an array of ```n``` elements. For example, in ```[6,2,5,1,7,4,8,3]```, the longest subsequence would be ```2 => 5 => 7 => 8```. Similar to the coin problem, we will define a function, ```length(k)``` which returns the longest increasing subsequence that **ends at** position ```k```. Some of the first couple values of ```length(k)``` for our example would be,
<br/>```length(0) = 1```
<br/>```length(1) = 1```
<br/>```length(2) = 2```
<br/>```length(3) = 1```
<br/>```length(4) = 3```
<br/>```length(5) = 2```
<br/>```length(6) = 4```
<br/>```length(0) = 2```

The solution to this problem is fairly simple. We want to find a position ```i``` such that ```i < k``` and ```arr[i] < arr[k]``` because then we know that we can add ```arr[k]``` into the subsequence.

```cpp
// Longest Increasing Subsequence Solution
// Complexity O(n^2)

int lengths[n];
for(int i = 0; i < n; i++) {
    lengths[i] = 1; // If there is nothing less than the current value, then it is the start of a new subsequence
    for(int j = i - 1; j >- 0; j --) {
        if(arr[j] < arr[i]) { // If we can add arr[i] into subsequence
            lengths[i] = max(lengths[i], lengths[j] + 1);
        }
    }
}
```

**Note: There is a ```O(nlogn)``` solution which will be covered later**