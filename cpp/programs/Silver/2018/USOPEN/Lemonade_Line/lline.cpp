#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
    freopen("lemonade.in", "r", stdin);
    freopen("lemonade.out", "w", stdout);
    int N;
    vector<int> cows;

    cin >> N;
    for (int i = 0; i < N; i++) {
        int curr;
        cin >> curr;
        cows.push_back(curr);
    }

    sort(cows.rbegin(), cows.rend());

    int ans = 0;
    for(int i:cows) {
        if(ans <= i) {
            ans++;
        }
    }
    cout << ans;
}