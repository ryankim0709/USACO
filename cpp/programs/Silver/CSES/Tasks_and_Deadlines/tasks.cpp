// For this greedy, you process the ones with the shortest task lengths. If the lengths are the same, 
// process the tasks ending first first.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n;
    cin >> n;
    map<int, vector<ll>> tasks;

    for (int i = 0; i < n; i ++) {
        int duration, deadline;
        cin >> duration >> deadline;
        tasks[duration];
        tasks[duration].push_back(deadline);
    }

    for(auto i:tasks) {
        sort(i.second.begin(), i.second.end());
    }

    ll currTime = 0;
    ll ans = 0;
    for (auto i : tasks)
    {
        int duration = i.first;
        for(int j:i.second) {
            currTime += duration;
            ans += j - currTime;
        }
    }
    cout << ans;
}