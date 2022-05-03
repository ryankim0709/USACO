#include <iostream>
#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
template <size_t N>

void printArr(array<int, N> s) {
    for(int i:s) {
        cout << i << " ";
    }
    cout << "\n";
}

void printArray(int *arr, int len) {
   
    for (int i = 0; i < len; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

void printSet(set<int> s) {
    for (auto it = s.begin(); it != s.end(); it++) {
        cout << *it << " ";
    }
    cout << "\n";
}

int main () {
    array<int, 5> s = {5, 3, 4, 2, 1};
    printArr(s);
    sort(s.begin(), s.end());
    printArr(s);
    reverse(s.begin(), s.end());
    printArr(s);

    int arr[5] = {1, 3, 5, 2, 4};
    int n = sizeof(arr)/sizeof(arr[0]);
    printArray(arr, n);
    sort(arr, arr + n);
    printArray(arr, n);
    reverse(arr, arr + n);
    printArray(arr, n);

    set<int> a;
    a.insert(1);
    a.insert(3);
    a.insert(2);
    a.insert(7);
    a.insert(5);
    printSet(a);

    auto it = a.find(13);
    if(it == a.end()) {
        cout << "Not found";
    } else {
        cout << "Found";
    }
    cout << "\n";
    if (a.find(13) != a.end())
    {
        cout << "Found";
    }
    else
    {
        cout << "Not found";
    }
    cout << "\n";

    // lower_bound(x) is at least x and upper_bound(x) is larger than x
    it = a.lower_bound(3);
    cout << *it << "\n";
    it = a.upper_bound(3);
    cout << *it << "\n";
}