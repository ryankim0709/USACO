#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int* bubble_sort(int arr[], int n) {
    // You have to pass in the size because we can't use the array (arr) to find out size
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j ++) {
            if(arr[j + 1] < arr[j]) {
                // Swapping
                
                // Manual swapping
                // int temp = arr[j + 1];
                // arr[j + 1] = arr[j];
                // arr[j] = temp;

                // Function swapping
                swap(arr[j], arr[j + 1]);
            }
        }
    }
        return arr;
}

int main() {
    int arr[] = {1, 4, 2, 52, 6, 3, 5, 3, 23, 64, 99};
    int n = sizeof(arr) / sizeof(arr[0]);
    bubble_sort(arr, n);

    for(int i:arr) {
        cout << i << "\n";
    }
}