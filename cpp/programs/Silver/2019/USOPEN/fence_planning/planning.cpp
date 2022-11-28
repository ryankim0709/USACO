#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define MAX INT_MAX
#define MIN INT_MIN

map<int, pair<int, int>> cows;
map<int, vector<int>> graph;
vector<bool> visited (1000005, false);

int minx, maxx, miny, maxy;
int ans = MAX;

void traverse(int cow) {
    if(visited[cow]) {
        return;
    }

    visited[cow] = true;
    minx = min(minx, cows[cow].first);
    miny = min(miny, cows[cow].second);
    maxx = max(maxx, cows[cow].first);
    maxy = max(maxy, cows[cow].second);

    for(int i:graph[cow]) {
        traverse(i);
    }
}

int main() {
    freopen("fenceplan.in", "r", stdin);
    freopen("fenceplan.out", "w", stdout);
    int N, M;
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        int row, col;
        cin >> row >> col;
        cows[i] = {row, col};
    }

    for (int i = 0; i < M; i++) {
        int one, two;
        cin >> one >> two;

        graph[one];
        graph[two];

        graph[one].push_back(two);
        graph[two].push_back(one);
    }

    for (int i = 1; i <= N; i++) {
        minx = MAX;
        miny = MAX;
        maxx = MIN;
        maxy = MIN;

        if(visited[i]) {
            continue;
        }

        traverse(i);
        ans = min(ans, (maxx - minx) * 2 + (maxy - miny) * 2);
    }
    cout << ans;
}