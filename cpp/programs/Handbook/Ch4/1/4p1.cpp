#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Dynamic Array - vector
    vector<int> v;
    v.push_back(3); // [3]
    v.push_back(2); // [3,2]
    v.push_back(5); // [3,2,5]
    cout << v[0] << "\n";
    cout << v[1] << "\n";
    cout << v[2] << "\n";
    cout << v.size() << "\n"; // v.size() = 3

    for (int i = 0; i < v.size(); i ++) {
        cout << v[i] << "\n";
    }
    // OR
    for(auto i:v) {
        cout << i << "\n";
    }

    vector<int> d;
    d.push_back(5);
    d.push_back(2);
    cout << d.back() << "\n"; // 2
    d.pop_back();
    cout << d.back() << "\n"; // 5

    vector<int> e = {2, 4, 2, 5, 1};
    vector<int> f(10); // Size 10 initial values are 0
    vector<int> g(10,5); // Size 10 initial values are 5

    string a = "hatti";
    string b = a + a;
    cout << b << "\n"; // hattihatti
    b[5] = 'v';
    cout << b << "\n"; // hattivatti
    string c = b.substr(3, 4); // Starts at index 3 and has a length of 4
    cout << c << "\n"; // tiva


}