#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    vector<int> g1;
    vector<int> h2;
    vector<int> j3;

    int n, q;
    cin >> n >> q;

    for (int i = 0; i < n; i++) {
        int type;
        cin >> type;

        if(type == 1) {
            g1.push_back(1);
            h2.push_back(0);
            j3.push_back(0);
        } else if(type == 2) {
            g1.push_back(0);
            h2.push_back(1);
            j3.push_back(0);
        } else {
            g1.push_back(0);
            h2.push_back(0);
            j3.push_back(1);
        }
    }

    vector<int> gp;
    vector<int> hp;
    vector<int> jp;

    gp.push_back(0);
    hp.push_back(0);
    jp.push_back(0);

    for (int i = 1; i <= n; i++) {
        gp.push_back(gp.at(i - 1) + g1.at(i - 1));
        hp.push_back(hp.at(i - 1) + h2.at(i - 1));
        jp.push_back(jp.at(i - 1) + j3.at(i - 1));
    }

    for (int i = 0; i < q; i++) {
        int lower, upper;
        cin >> lower >> upper;
        cout << gp.at(upper) - gp.at(lower - 1) << " ";
        cout << hp.at(upper) - hp.at(lower - 1) << " ";
        cout << jp.at(upper) - jp.at(lower - 1) << endl;
    }
}