#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    int n;
    cin >> n;

    vector<int> lst(7, -1);
    lst[0] = 0;
    int remain = 0;
    int ans = 0;

    for (int i = 1; i <= n; i++) {
        int next;
        cin >> next;
        remain = (remain + next) % 7;
        if(lst[remain] == -1) {
            lst[remain] = i;
        }
        else
        {
            ans = max(ans, i - lst[remain]);
        }
    }
    cout << ans;
}