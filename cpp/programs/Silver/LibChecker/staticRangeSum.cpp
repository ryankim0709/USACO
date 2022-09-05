#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n, m;
    cin >> n >> m;

    ll arr[n];

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    ll prefix[n + 1];
    prefix[0] = 0;

    for (int i = 1; i <= n; i++ ) {
        prefix[i] = prefix[i - 1] + arr[i - 1];
    }

    for (int i = 0; i < m; i++ ) {
        int a, b;
        cin >> a >> b;

        cout << prefix[b] - prefix[a] << "\n";
    }
}