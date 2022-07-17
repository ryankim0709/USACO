#include <iostream>
#include <bits/stdc++.h>
#define INF INT_MAX
using namespace std;

class Graph {
    int N;
    vector<tuple<int, int, int>> edgeList;
    vector<vector<pair<int, int>>> spfaGraph;

public:
    Graph(int N) {
        this->N = N;
        spfaGraph = vector<vector<pair<int, int>>>(N);
    }

    void addEdge(int s, int e, int w) {
        edgeList.push_back({s, e, w});
    }
    void addSpfaEdge(int s, int e, int w) {
        spfaGraph[s].push_back({e, w});
    }
    void shortestPath(int start)
    {
        int distance[N];
        for (int i = 0; i < N; i++) 
            distance[i] = INF;

        distance[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            for(auto e:edgeList) {
                int a, b, w;
                tie(a, b, w) = e;
                distance[b] = min(distance[b], distance[a] + w);
            }
        }

        for (int i = 0; i < N; i++)
        {
            cout << "Shortest distance from  node " << start << " to node " << i << " is " << distance[i] << "\n";
        }
    }

    string negativeCycleExists(int start) {
        int distance[N];
        for (int i = 0; i < N; i++) 
            distance[i] = INF;

        distance[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            for(auto e:edgeList) {
                int a, b, w;
                tie(a, b, w) = e;
                distance[b] = min(distance[b], distance[a] + w);
            }
        }

        for(auto e:edgeList) {
            int a, b, w;
            tie(a, b, w) = e;
            if(distance[a] + w != distance[b])
                return "Negative cycle exists";
        }
        return "Negative cycle does not exist";
    }

    void spfaDFS(int start) {
        int distance[N];
        for (int i = 0; i < N; i++) 
            distance[i] = INF;

        distance[start] = 0;
        queue<int> q;
        q.push(start);
        
        while(!q.empty()) {
            int next = q.front();
            q.pop();
            for (auto e : spfaGraph[next])
            {
                int b, w;
                tie(b, w) = e;
                int past = distance[b];
                distance[b] = min(distance[b], distance[next] + w);

                if(distance[b] < past) {
                    q.push(b);
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            cout << "Shortest distance from  node " << start << " to node " << i << " is " << distance[i] << "\n";
        }
    }
};

int main() {
    Graph bellman(5);

    bellman.addEdge(0, 1, 5);
    bellman.addEdge(0, 2, 3);
    bellman.addEdge(0, 3, 7);
    bellman.addEdge(1, 0, 5);
    bellman.addEdge(1, 3, 3);
    bellman.addEdge(1, 4, 2);
    bellman.addEdge(2, 0, 3);
    bellman.addEdge(2, 3, 1);
    bellman.addEdge(3, 0, 7);
    bellman.addEdge(3, 1, 3);
    bellman.addEdge(3, 2, 1);
    bellman.addEdge(3, 4, 2);
    bellman.addEdge(4, 1, 2);
    bellman.addEdge(4, 3, 2);

    bellman.shortestPath(0);

    Graph bellmanNegative(4);
    bellmanNegative.addEdge(0, 1, 3);
    bellmanNegative.addEdge(0, 2, 5);
    bellmanNegative.addEdge(1, 0, 3);
    bellmanNegative.addEdge(1, 2, 2);
    bellmanNegative.addEdge(1, 3, 1);
    bellmanNegative.addEdge(2, 0, 5);
    bellmanNegative.addEdge(2, 1, 2);
    bellmanNegative.addEdge(2, 3, -7);
    bellmanNegative.addEdge(3, 1, 1);
    bellmanNegative.addEdge(3, 2, -7);

    cout << bellmanNegative.negativeCycleExists(0) << "\n";

    Graph spfa(5);
    spfa.addSpfaEdge(0, 1, 5);
    spfa.addSpfaEdge(0, 2, 3);
    spfa.addSpfaEdge(0, 3, 7);
    spfa.addSpfaEdge(1, 0, 5);
    spfa.addSpfaEdge(1, 3, 3);
    spfa.addSpfaEdge(1, 4, 2);
    spfa.addSpfaEdge(2, 0, 3);
    spfa.addSpfaEdge(2, 3, 1);
    spfa.addSpfaEdge(3, 0, 7);
    spfa.addSpfaEdge(3, 1, 3);
    spfa.addSpfaEdge(3, 2, 1);
    spfa.addSpfaEdge(3, 4, 2);
    spfa.addSpfaEdge(4, 1, 2);
    spfa.addSpfaEdge(4, 3, 2);

    spfa.spfaDFS(0);
}