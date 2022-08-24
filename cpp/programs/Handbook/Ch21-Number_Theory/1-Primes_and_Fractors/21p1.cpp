#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool prime(int n) {
    if(n < 2) return false;

    for(int i = 2; i <= sqrt(n); i++) {
        if(n % i == 0) return true;
    }

    return false;
}

vector<int> factors(int n) {
    vector<int> f;

    for(int i = 2; i <= sqrt(n); i++) {
        while(n % i == 0) {
            f.push_back(i);
            n /= i;
        }
    }

    if(n > 1) f.push_back(n);
    return f;
}

int main() {
    cout << prime(4) << "\n";
    vector<int> f = factors(4);

    for(int i:f) {
        cout << i << " ";
    }
    cout << "\n";
}