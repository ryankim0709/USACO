#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    vector<vector<int>> graph; // Graph is edge weight graph
    vector<vector<int>> rGraph; // Stores the capacity of each edge

public:
    Graph(int N) {
        this->N = N;
        graph = vector<vector<int>>(N);
        rGraph = vector<vector<int>>(N);

        for (int i = 0; i < N; i++) {
            graph[i] = vector<int>(N);
            rGraph[i] = vector<int>(N);
        }
    }

    void addEdge(int a, int b, int weight) {
        graph[a][b] = weight;
    }

    void expressGraph() {
        for (int i = 0; i < N; i++) {
            for(int u:graph[i]) {
                cout << u << " ";
            }
            cout << "\n";
        }
    }

    bool bfs(int s, int t, int parent[]) {
        bool visited[N];

        memset(visited, 0, sizeof(visited)); // Visited or not

        queue<int> q;
        q.push(s);
        visited[s] = true;
        parent[s] = -1;

        while(!q.empty()) {
            int u = q.front();
            q.pop();

            for (int v = 0; v < N; v++) {
                if(visited[v] == false && rGraph[u][v] > 0) {
                    if(v == t) {
                        parent[v] = u;
                        return true;
                    }
                    q.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false; // Could not find a path
    }

    int fordFulkersons (int s, int t) { // s is source & t is sink
        int u, v;
        for (u = 0; u < N; u++)
        {
            for (v = 0; v < N; v++)
            {
                rGraph[u][v] = graph[u][v];
            }
        }

        int parent[N]; // Store the path from BFS

        int max_flow = 0; // No flow initially

        while(bfs(s, t, parent)) {
            int path_flow = INT_MAX;

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = min(path_flow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v])
                {
                    u = parent[v];
                    rGraph[u][v] -= path_flow; // Less available
                    rGraph[v][u] += path_flow; // Current flow
                }

            max_flow += path_flow;
        }

        return max_flow;
    }
};

int main() {
    Graph edge_disjoint(6);

    edge_disjoint.addEdge(0, 1, 1);
    edge_disjoint.addEdge(0, 2, 1);
    edge_disjoint.addEdge(1, 2, 1);
    edge_disjoint.addEdge(1, 3, 1);
    edge_disjoint.addEdge(2, 1, 1);
    edge_disjoint.addEdge(2, 4, 1);
    edge_disjoint.addEdge(3, 2, 1);
    edge_disjoint.addEdge(3, 5, 1);
    edge_disjoint.addEdge(4, 3, 1);
    edge_disjoint.addEdge(4, 5, 1);

    edge_disjoint.expressGraph();

    cout << edge_disjoint.fordFulkersons(0, 5) << "\n";
}