# Sliding window minimum

In this problem we are givin an array of size `n` and window size `k`. For every contiguous window `k`, we must find the minimum value within the window.
Example, arr = `[2, 1, 4, 5, 3, 4, 1, 2]` and `k=3`, for the first window, `[2, 1, 4]`, the smallest value is `1`.

Solution: For the proble, we will be using a `deque<int>` which is a dynamic array whose size can be efficiently changed at both ends of the array. Using this data structure, for every window, we can construct a deque in which the elements are in increasing order with the first element being the smallest within the window. Since it is a _sliding window_, we can remove the first element if it the element that should be removed. We can also easily remove all values in the stack **greater than** the current value.

```cpp
    // Solution: O(n) because we are only inserting/deleting each element one time 
    deque<int> queue; // Deque

    // First iteration is manual
    for (int i = 0; i < k; i++) {
        if(queue.size() == 0) // For the first element
            queue.push_back(arr[i]);
        else if (arr[i] < queue.front()) // Smaller than the starting element?
        {
            queue.clear();
            queue.push_back(arr[i]);
        }
        else if (arr[i] > queue.back()) // Greater than the back?
        {
            queue.push_back(arr[i]);
        }
    }
    cout << queue.front() << "\n";

    for (int i = 1; i < n - k; i++)
    {
        int removed = arr[i - 1]; // Element that will be removed
        int added = arr[i + k - 1]; // Element that will be added
        if(queue.front() == removed) { // Remove the first element if it the one that should be removed
            queue.pop_front();
        }
        while(queue.size() > 0 && queue.back() >= added) { // Clean out deque such that the current element > deque.back()
            queue.pop_back();
        }
        queue.push_back(added); // Add element
        cout << queue.front() << "\n";
    }
```
