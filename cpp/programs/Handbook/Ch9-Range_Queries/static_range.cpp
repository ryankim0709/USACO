#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {

    // Static range queries
    int n = 8;
    int arr[n] = {1, 3, 4, 8, 6, 1, 4, 2};
    int prefix[n + 1];

    for (int i = 1; i < n + 1; i++) 
        prefix[i] = prefix[i - 1] + arr[i - 1];
    
    // sum(a, b) = sum(0,b) - sum(0,a-1)
    // Makes sense because you are subtracting the portion you don't want (0, a-1) from the whole, (0,b)
    
}