#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    int n;
    cin >> n;

    int prefix[n + 1];
    prefix[0] = 0;

    for (int i = 1; i <= n; i++) {
        int a;
        cin >> a;
        prefix[i] = prefix[i - 1] + a;
    }

    int ans = -1;
    for (int i = n; i >= 0; i--)
    {
        if(ans > -1)
            break;
        if (i == 0)
            ans = 0;

        for (int a = 1; a <= n - i + 1; a++) {
            int start = a;
            int end = start + i - 1;

            if((prefix[end] - prefix[start - 1]) % 7 == 0) {
                ans = i;
                break;
            }
        }
    }

    cout << ans;
}