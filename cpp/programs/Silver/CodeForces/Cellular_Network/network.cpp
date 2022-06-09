#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    int cities[n];
    set<int> towers;
    set<int> towersNegative;

    for (int i = 0; i < n; i++) {
        cin >> cities[i];
    }

    for (int i = 0; i < m; i ++) {
        int val;
        cin >> val;
        towers.insert(val);
        towersNegative.insert(-1 * val);
    }

    int ans = 0;
    for(int i : cities) {
        auto leftSide = towersNegative.lower_bound(-i);
        auto rightSide = towers.lower_bound(i);
        int lDiff = -1 * *leftSide;
        lDiff = abs(i - lDiff);
        int rDiff = abs(*rightSide - i);
        int shortest = min(lDiff, rDiff);
        ans = max(ans, shortest);
    }
    //Comment so that I can submit
    cout << ans;
}