#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {

    int a[] = {1, 2, 3, 4};
    int b[] = {2, 3, 4, 5};
    int n = sizeof(a) / sizeof(a[0]);
    vector<int> unionResult;

    set_union(a, a + n, b, b + n, unionResult.begin());
    
    // for(auto i:unionResult) {
    //     cout << i << "\n";
    // }
}