#include<iostream>
#include <fstream>
#include<bits/stdc++.h>
using namespace std;

vector<int> cows;
int N, K, MAX_COW = -1;

bool simulate(int R) {

    int ind = 0;
    for (int i = 0; i < K; i++) {
        int low = cows[ind];
        int high = low + 2 * R;

        while(cows[ind] <= high) {
            ind++;
            if(ind == N)
                return true;
        }
    }
        return false;
}

int main()
{
        freopen("angry.in", "r", stdin);
        freopen("angry.out", "w", stdout);
        cin >> N >> K;

        for (int i = 0; i < N; i++)
        {
        int val;
        cin >> val;
        cows.push_back(val);
        MAX_COW = max(MAX_COW, val);
    }
    sort(cows.begin(), cows.end());

    int lo = 0, hi = MAX_COW;
    int ans = -1;
    while (lo <= hi)
    {
        int mid = lo + (hi - lo) / 2;

        if(simulate(mid)) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    cout << ans;
}