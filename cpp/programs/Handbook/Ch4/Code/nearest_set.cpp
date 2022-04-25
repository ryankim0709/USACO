#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    set<int> s;
    s.insert(1);
    s.insert(2);
    s.insert(3);
    s.insert(4);
    s.insert(20);

    auto it = s.lower_bound(6);
    if (it == s.begin()) {
        cout << *it << "\n";
    } else if(it == s.end()) {
        it--;
        cout << *it << "\n";
    } else {
        int a = *it;
        it--;
        int b = *it;
        if(6-b < a-6)
            cout << b << "\n";
        else
            cout << a << "\n";
    }
}