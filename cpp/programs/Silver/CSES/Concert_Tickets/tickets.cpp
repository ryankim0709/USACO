#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    map<int, int> count;
    set<int> prices;

    for (int i = 0; i < n; i++) {
        int cost;
        cin >> cost;
        count[-cost];
        count[-cost] += 1;
        prices.insert(-cost);
    }
    for (int i = 0; i < m; i++)
    {
        int bargain;
        cin >> bargain;
        bargain *= -1;
        auto lowest = prices.lower_bound(bargain);

        if(lowest == prices.end()) {
            cout << -1 << "\n";
        } else {
            cout << *lowest * -1 << "\n";
            count[*lowest]--;

            if(count[*lowest] == 0) {
                prices.erase(*lowest);
            }
        }
    }
}