#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void searchRecursion(vector<int> a, int k, int n, vector<int> subset) {
    
    if(k == n) {
        cout << "{";
        for(int i:subset) {
            cout << i << " ";
        }
        cout << "}\n";
    } else {
        // Make one subset without the element
        searchRecursion(a, k + 1, n, subset);
        // Make a subset with the element
        subset.push_back(a[k]);
        searchRecursion(a, k + 1, n, subset);
        subset.pop_back();
    }
}

int main() {
    // Creating all subsets using recursion
    vector<int> a = {0, 1, 2};
    int n = 3;
    vector<int> b;
    searchRecursion(a, 0, n, b);
    cout << "\n";
    for (int b = 0; b < (1 << 3); b++)
    {
        vector<int> subset;
        for (int i = 0; i < n; i++) {
            if(b&(i<<i))
                subset.push_back(i);
        }
        cout << "{";
        for (int j : subset)
        {
            cout << j;
        }
        cout << "}\n";
    }
}