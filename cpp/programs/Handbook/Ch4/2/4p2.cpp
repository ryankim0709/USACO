#include <bits/stdc++.h>
using namespace std;

int main() {
    set<int> s;
    s.insert(3);
    s.insert(2);
    s.insert(5);
    cout << s.count(3) << "\n"; // 1
    cout << s.count(4) << "\n"; // 0
    s.erase(3);
    s.insert(4);
    cout << s.count(3) << "\n"; // 0
    cout << s.count(4) << "\n"; // 1

    s = {2, 5, 6, 8};
    for (auto i:s) {
        cout << i << "\n";
    }

    // No duplicates in sets
    s = {};
    s.insert(4);
    s.insert(4);
    s.insert(4);
    cout << s.count(4) << "\n"; // 1

    // Multiset allows duplicates
    multiset<int> z;
    z.insert(5);
    z.insert(5);
    z.insert(5);
    cout << z.count(5) << "\n"; // 3

    // Erase removes ALL instances in multiset
    z.erase(5);
    cout << z.count(5) << "\n"; // 0

    // If you only want one instance ....
    z.insert(5);
    z.insert(5);
    z.insert(5);
    z.erase(z.find(5));
    cout << s.count(5) << "\n"; // 2
}