#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("div7.in","r",stdin);
    freopen("div7.out", "w", stdout);

    int n;
    cin >> n;
    int currRemain = 0;
    int ans = 0;

    vector<int> first(7, -1);
    first[0] = 0;
    for (int i = 1; i <= n; i++)
    {
        int next;
        cin >> next;

        currRemain = (currRemain + next)%7;
        if(first[currRemain] == -1) {
            first[currRemain] = i;
        } else {
            ans = max(ans, i - first[currRemain]);
        }
    }
    cout << ans << endl;
}