#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("maxcross.in", "r", stdin);
    freopen("maxcross.out", "w", stdout);
    int n, k, b;
    cin >> n >> k >> b;
    vector<int> broken (n + 1, 1);
    for (int i = 0; i < b; i++)
    {
        int a;
        cin >> a;
        broken[a] = 0;
    }
    vector<int> prefix(n + 1, 0);

    for (int i = 1; i <= n + 1; i++) {
        prefix[i] = prefix[i - 1] + broken[i];
    }

    int ans = 0;
    for (int i = 1; i <= n - k + 2; i++)
    {
        int front = i;
        int back = front + k - 1;
        ans = max(ans, prefix[back] - prefix[front - 1]);
    }

    cout << k - ans;
}