#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    int order[n];
    for (int i = 0; i < n; i++) {
        cin >> order[i];
    }

    int ans = 0;
    multiset<int> towers;
    for(int i:order) {
        auto towerToPlace = towers.upper_bound(i);
        if (towerToPlace == towers.end())
        {
            ans++;
            towers.insert(i);
        }
        else
        {
            towers.erase(towerToPlace);
            towers.insert(i);
        }
    }
    cout << ans;
}