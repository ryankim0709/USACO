#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n, x;
    cin >> n >> x;

    map<ll, int> count;
    count[0] = 1;
    ll prefix = 0;
    ll ans = 0;

    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        prefix += a;
        ll target = prefix - x;
        count[target];
        ans += count[target];
        count[prefix] = count[prefix] + 1;
    }

    cout << ans;
}