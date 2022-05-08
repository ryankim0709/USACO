#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> bookkeeping_sort(int arr[], int n) {
    map<int, int> freq;

    for (int i = 0; i < n; i++) {
        int curr = arr[i];
        if(freq.find(curr) == freq.end()) {
            freq[curr] = 0;
        }
        freq[curr] += 1;
    }
    vector<int> finale;
    for (map<int, int>::iterator it = freq.begin(); it != freq.end(); ++it)
    {
        for (int j = 0; j < it->second; j++) {
            finale.push_back(it->first);
        }
    }
    return finale;
}

int main() {
    int arr[] = {1, 4, 2, 52, 6, 3, 5, 3, 23, 64, 99};
    int n = sizeof(arr) / sizeof(arr[0]);

    vector<int> sorted = bookkeeping_sort(arr, n);

    for(int i:sorted) {
        cout << i << "\n";
    }
}