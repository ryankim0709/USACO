#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n;
    cin >> n;

    ll prefix = 0;
    map<ll, int> count;
    count[0] = 1;

    ll ans = 0;
    for (int i = 0; i < n; i++)
    {
        ll a;
        cin >> a;

        prefix = ((prefix + a) % n + n) % n;
        count[prefix];

        ans += count[prefix];
        count[prefix]++;
    }
    cout << ans;
}