#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {

    freopen("pairup.in", "r", stdin);
    freopen("pairup.out", "w", stdout);

    int N;
    cin >> N;

    vector<ll> cows;

    int size = 0;
    for (int i = 0; i < N; i++)
    {
        int output, occurence;
        cin >> occurence >> output;
        size += occurence;

        for (int j = 0; j < occurence; j++)
        {
            cows.push_back(output);
        }
    }

    sort(cows.begin(), cows.end());

    ll ans = 0;
    for (int i = 0; i < size / 2; i++)
    {
        ans = max(ans, cows[i] + cows[size - 1 - i]);
    }

    cout << ans;
}