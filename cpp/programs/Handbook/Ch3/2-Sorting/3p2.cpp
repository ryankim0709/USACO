#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Sorting vectors
    vector<int> v = {4, 2, 5, 3, 5, 8, 3};
    sort(v.begin(), v.end()); // Sorting in increasing order
    for(int i:v)
        cout << i << " "; // 2 3 3 4 5 5 8
    cout << "\n";
    sort(v.rbegin(), v.rend()); // Sorting in decreasing order
    for(int i:v)
        cout << i << " "; // 8 5 5 4 3 3 2
    cout << "\n";

    // Sorting normal arrays
    int a[] = {4, 2, 5, 3, 5, 8, 3};
    int n = sizeof(a) / sizeof(a[0]); // Size of array
    n = 7; // Size of array
    sort(a, a + n);
    for(int i:a)
        cout << i << " "; // 2 3 3 4 5 5 8
    cout << "\n";

    // String sorting
    string s = "monkey";
    sort(s.begin(), s.end());
    cout << s << "\n"; // ekmnoy => based on ASCII values

    // Comparison operators
    vector<pair<int, int>> pairs;
    pairs.push_back({1, 5});
    pairs.push_back({2, 3});
    pairs.push_back({1, 2});
    sort(pairs.begin(), pairs.end()); // Sort via first number, then second
    for(auto i:pairs)
        cout << "(" << i.first << i.second << ") "; // (1, 2), (1,5), (2, 3)
    cout << "\n";

    vector<tuple<int, int, int>> tuples;
    tuples.push_back({2, 1, 4});
    tuples.push_back({1, 5, 3});
    tuples.push_back({2, 1, 3});
    sort(tuples.begin(), tuples.end());
    for(auto i:tuples)
        cout << "(" << get<0>(i) << get<1>(i) << get<2>(i) << ") "; // (1, 5, 3), (2, 1, 3), (2, 1, 4)

}