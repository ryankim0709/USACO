#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {

    int a[] = {1, 2, 3, 4};
    int b[] = {2, 3, 4, 5};
    int n = sizeof(a) / sizeof(a[0]); 
    // In bites
    // Find the length. Total bites/size of one bite = total length in bites

    // Set Union
    cout << "Set union"
         << "\n";
    vector<int> unionResult(5);
    set_union(a, a + n, b, b + n, unionResult.begin());
    for(auto i:unionResult) {
        cout << i << "\n";
    }

    // Set Intersection
    cout << "Set Intersection"
         << "\n";
    vector<int> intersectionResult(3);
    set_intersection(a, a + n, b, b + n, intersectionResult.begin());
    for (auto i:intersectionResult) {
        cout << i << "\n";
    }

    // No function available for the complement, but you can run a for loop

    // Set difference
    cout << "Set Difference"
         << "\n";
    vector<int> differenceResult(1);
    set_difference(a, a + n, b, b + n, differenceResult.begin());
    for(auto i:differenceResult) {
        cout << i << "\n";
    }

    // With integer vectors
    cout << "Set union with vectors"
         << "\n";
    vector<int> c = {1, 2, 3, 5, 4};
    vector<int> d = {2, 3, 4, 5, 6};
    n = sizeof(c) / sizeof(c[0]);

    // Sorting is required for set functions

    // Without sorting
    cout << "Non-sorted"
         << "\n";
    vector<int> vectSetUnionNoSort(6);
    set_union(c.begin(), c.end(), d.begin(), d.end(), vectSetUnionNoSort.begin());
    for(auto i:vectSetUnionNoSort) {
        cout << i << "\n";
    }

    // With sorting
    cout << "Sorted"
         << "\n";
    sort(c.begin(), c.end());
    sort(d.begin(), d.end());
    vector<int> vectSetUnionSorted(6);
    vectSetUnionNoSort.clear();
    vectSetUnionNoSort.resize(6);
    set_union(c.begin(), c.end(), d.begin(), d.end(), vectSetUnionSorted.begin());
    for(auto i:vectSetUnionSorted) {
        cout << i << "\n";
    }
}