#include<bits/stdc++.h>
#include <iostream>
using namespace std;

vector<vector<char>> graph;
vector<vector<bool>> visited;
int currArea, currPerim;
int ansArea = 0;
int ansPerim = 0;

void flood_fill(int x, int y, int n) {
    if(x < 0 || x >= n || y < 0 || y >= n) {
        // Out of bounds
        currPerim++;
        return;
    }
    if(graph[x][y] == '.') {
        // Not ice cream
        currPerim++;
        return;
    }
    if(graph[x][y] == '#') {
        if(visited[x][y])
            return;
        else
        {
            visited[x][y] = true;
            currArea++;
            flood_fill(x + 1, y, n);
            flood_fill(x - 1, y, n);
            flood_fill(x, y + 1, n);
            flood_fill(x, y - 1, n);
        }
    }
}

int main()
{
    freopen("perimeter.in", "r", stdin);
    freopen("perimeter.out", "w", stdout);
    int n;
    cin >> n;

    for(int i = 0; i < n; i++) {
        vector<char> line;
        vector<bool> visit;
        for (int j = 0; j < n; j++)
        {
            char curr;
            cin >> curr;
            line.push_back(curr);
            visit.push_back(false);
        }
        graph.push_back(line);
        visited.push_back(visit);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(!visited[i][j]) {
                currArea = currPerim = 0;
                flood_fill(i, j, n);

                // Find ans
                if(currArea > ansArea) {
                    ansArea = currArea;
                    ansPerim = currPerim;
                }
                else if(currArea == ansArea) {
                    ansPerim = min(ansPerim, currPerim);
                }
            }
        }
    }

    cout << ansArea << " " << ansPerim;
}