#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
    freopen("lifeguards.in", "r", stdin);
    int N;
    cin >> N;

    vector<pair<int, int>> cows(N+1);

    for(int i = 0; i < N; i++) {
        cin >> cows[i].first >> cows[i].second;
    }
    cows[N].first = INT_MAX;
    cows[N].second = INT_MAX;
    sort(cows.begin(), cows.end());
    cows[N].first = cows[N-1].second;
    cows[N].second = cows[N-1].second + 1;

    int right = 0;
    int totalTime = 0;
    int minTimeAlone = INT_MAX;

    for(int i = 0; i < N; i++) {
        pair<int, int> currCow = cows[i];
        pair<int, int> nextCow = cows[i+1];

        if(right != -1 && right > currCow.second) {
            minTimeAlone = 0;
        }

        if(currCow.second > right) totalTime += currCow.second - max(right, currCow.first);

        int end = min(nextCow.first, currCow.second);
        int start = max(right, currCow.first);
        int timeAlone = end - start;
        minTimeAlone = min(minTimeAlone, timeAlone);
        right = max(right, currCow.second);
    }
    freopen("lifeguards.out", "w", stdout);
    //cout << totalTime;
    cout << totalTime - max(0,minTimeAlone);
}