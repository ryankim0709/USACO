#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int M, N; // Row, Col
int graph[500][500];
int waypoints[500][500];
int wayRow, wayCol;
int visited[500][500];
int currWaypoints = 0;

void flood_fill(int row, int col, int D, int prev, int iteration) {
    if(row < 0 || row >= M || col < 0 || col >= N) {
        // out of bounds
        return;
    }
    if(abs(prev - graph[row][col]) > D) {
        return;
    }
    if(visited[row][col] == iteration) {
        // visited
        return;
    }
    else {
        visited[row][col] = iteration;
        if(waypoints[row][col] == 1) {
            currWaypoints ++;
        }
        flood_fill(row + 1, col, D, graph[row][col], iteration);
        flood_fill(row - 1, col, D, graph[row][col], iteration);
        flood_fill(row, col + 1, D, graph[row][col], iteration);
        flood_fill(row, col - 1, D, graph[row][col], iteration);
    }
}

int main() {
    freopen("ccski.in", "r", stdin);
    freopen("ccski.out", "w", stdout);
    cin >> M >> N;
    for (int i = 0; i < M; i++)
    {
        for(int j = 0; j < N; j++) {
            cin >> graph[i][j];
        }
    }

    int totalWaypoints = 0;
    for(int i = 0; i < M; i++) {
        for(int j = 0; j < N; j++) {
            cin >> waypoints[i][j];
            if(waypoints[i][j] == 1) {
                totalWaypoints ++;
                wayRow = i;
                wayCol = j;
            }
        }
    }

    int low = 0;
    int high = INT_MAX;
    int iteration = 0;

    while(low < high)
    {
        // Find testing value
        int mid = low + (high - low) / 2;
        currWaypoints = 0;
        iteration++;
        flood_fill(wayRow, wayCol, mid, graph[wayRow][wayCol], iteration);
        // cout << low << " " << high << " " << currWaypoints << "\n";
        if (currWaypoints == totalWaypoints)
        {
            high = mid;
       } else {
        low = mid + 1;
       }
    }

    cout << low;
}