#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdin);

    int n, q;
    cin >> n >> q;

    int H1[n];
    int G2[n];
    int J3[n];

    for (int i = 0; i < n; i++) {
        int type;
        cin >> type;

        switch (type) {
            case 1:
                H1[i] = 1;
            case 2:
                G2[i] = 1;
            case 3:
                J3[i] = 1;
        }
    }
    int h1p[n + 1], g2p[n + 1], j3p[n + 1];

    for (int i = 1; i <= n; i ++) {
        h1p[i] = h1p[i - 1] + H1[i - 1];
        g2p[i] = g2p[i - 1] + G2[i - 1];
        j3p[i] = j3p[i - 1] + J3[i - 1];
    }

    for (int i = 0; i < q; i ++) {
        int lower, upper;
        cin >> lower >> upper;
        cout << h1p[upper] - h1p[lower - 1]<<" ";
        cout << g2p[upper] - g2p[lower - 1]<<" ";
        cout << j3p[upper] - j3p[lower - 1] << endl;
    }
}