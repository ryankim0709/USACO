#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Binary Search
    // O(logn) algorithm for finding an element in a sorted list of elements.

    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = 9;
    int x = 3; // Target value

    // Method 1
    // Compare the target value to the middle value and slowly shrink the "active region"

    int a = 0, b = n - 1;
    while (a <= b) {
        int k = a + (b - a) / 2;

        if(arr[k] == x) {
            // x found at k
            cout << x << " was found at index " << k << "\n";
            break;
        }

        if (arr[k] > k)
            b = k - 1;
        else
            a = k + 1;
    }

    // Method 2
    // Use efficient looping. Initially, the skip length is (n/2), then (n/4) ....

    int k = 0;
    for (int b = n / 2; b >= 1; b /= 2) {
        while (k + b < n && arr[k + b] <= x)
            k += b;
    }
    if(arr[k] == x) {
        cout << x << " was found at index " << k << "\n";
    }

    // C++ Functions

    // lower_bound() function returns a pointer to the first array element whose value is at least x
    // upper_bound() function returns a pointer to the first array element whose value is larger than x
    // equal_range() returns both above pointers

    // All of these functions assume that the array is sorted

    auto resk = lower_bound(arr, arr + n, x) - arr; // Subtract the adresses
    // Will return the space between the lower_bound() result and the first element
    cout << resk << "\n";

    auto resa = lower_bound(arr, arr + n, x);
    auto resb = upper_bound(arr, arr + n, x);
    cout << x << " is at index " << resb - resa << "\n";

    auto resr = equal_range(arr, arr + n, x);
    cout << x << " is at index " << resr.second - resr.first << "\n";
    // This does the same thing as above
}