#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> counting_sort_map(int arr[], int n) {
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

void counting_sort(int arr[], int n) {
    // * is used when when determining the adress of the variable
    // & is used to display the value of the asterisk

    int finale[100] = {0};
    for (int i = 0; i < n; i++) {
        finale[arr[i]] += 1;
    }
    for(int i = 0; i < 100; i ++) {
        for(int j = 0; j < finale[i]; j ++) {
            cout << i << "\n";
        }
    }
}

int main() {
    int arr[] = {1, 4, 2, 52, 6, 3, 5, 3, 23, 64, 99};
    int n = sizeof(arr) / sizeof(arr[0]);

    vector<int> sorted = counting_sort_map(arr, n); // This one is using maps, it is not very efficient

    for(int i:sorted) {
        cout << i << "\n";
    }
    cout << "\n";
    cout << "Using arrays to sort\n";
    counting_sort(arr, n);
}