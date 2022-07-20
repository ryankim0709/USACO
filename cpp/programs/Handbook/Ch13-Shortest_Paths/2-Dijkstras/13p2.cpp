#include <iostream>
#include <bits/stdc++.h>
#define INF INT_MAX
using namespace std;

class Graph {
    int N;
    vector<pair<int, int>> adjList[5];

public:
    Graph(int N) {
        this->N = N;
    }
    void addNeighbor(int s, int e, int w) {
        adjList[s].push_back({e, w});
    }
    void dijkstra(int start) {
        bool processed[N];
        for (int i = 0; i < N; i++) {
            processed[i] = false;
        }
            int distance[N];
        for (int i = 0; i < N; i++) {
            distance[i] = INF;
        }

        distance[start] = 0;
        priority_queue<pair<int, int>> q;
        q.push({0, start}); // distance to start is 0

        while(!q.empty()) {
            int a = q.top().second;
            q.pop();
            if(processed[a]) continue;
            processed[a] = true;
            for(auto u:adjList[a]) {
                int b = u.first, w = u.second;
                if(distance[a] + w < distance[b]) {
                    distance[b] = distance[a] + w;
                    // We store b because priority queue sorts from largest to smallest
                    q.push({-distance[b], b});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            cout << "Distance from " << start << " to " << i << " is " << distance[i] << "\n";
        }
    }
};

int main() {
    Graph shortest(5);

    shortest.addNeighbor(0, 1, 5);
    shortest.addNeighbor(0, 3, 9);
    shortest.addNeighbor(0, 4, 1);
    shortest.addNeighbor(1, 0, 5);
    shortest.addNeighbor(1, 2, 2);
    shortest.addNeighbor(2, 1, 2);
    shortest.addNeighbor(2, 3, 6);
    shortest.addNeighbor(3, 0, 9);
    shortest.addNeighbor(3, 2, 6);
    shortest.addNeighbor(3, 4, 2);
    shortest.addNeighbor(4, 0, 1);
    shortest.addNeighbor(4, 3, 2);

    shortest.dijkstra(0);
}