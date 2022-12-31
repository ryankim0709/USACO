#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {

    // Problem 1: Does a value target exist in vector 1
    vector<int> a;
    
    int L = 0, R = a.size() - 1, target = 2;
    while(L <= R) {
        int mid = L + (R - L) / 2;
        if(a[mid] == target) {
            break;
        }
        if(a[mid] < target) {
            L = mid + 1;
        }
        else {
            R = mid - 1;
        }
    }

    // Problem two: Is a number a perfect square (without using sqrt function)
    int x = 16, left = 0, right = x;
    while(left <= right) {
        int mid = L + (R - L) / 2;
        if(pow(mid, 2) == x) {
            break;
        }
        if(pow(mid, 2) < x) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    // Problem three: Find the first value >= x (lower bound problem)
    int three[7] = {2, 3, 5, 6, 8, 10, 12};
    // Answer should be 5
    int x = 4;
    L = 0, R = 6;
    int ans = -1;
    while (L <= R)
    {
        int mid = L + (R - L) / 2;
        if(a[mid] >= x) {
            ans = mid; // Only getting better, so you don't need to do min(ans, curr)
            R = mid - 1;
        }
        else {
            L = mid + 1;
        }
    }

    // Problem 4: Find the smallest element in the rotated array
    int four[7] = {6,7,9,15,19,2,3};
    // Compare against the last element of the arrray

    // Problem 5: Find the largest element in the rotated array
    // We would compare against the previous value and find the last True

    // Problem 6: Find the square root

    
}