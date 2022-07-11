#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);

    int n;
    cin >> n;

    // Contains first time prefix % 7 = i
    vector<int> first_occur(7, -1); // All -1 and has size 7
    first_occur[0] = 0;

    int curr_remainder = 0;

    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        int cow;
        cin >> cow;

        curr_remainder = (curr_remainder + cow) % 7;

        if(first_occur[curr_remainder] == -1) {
            first_occur[curr_remainder] = i;
        } else {
            ans = max(ans, i - first_occur[curr_remainder]);
        }
    }
    cout << ans;
}