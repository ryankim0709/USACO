#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    vector<vector<int>> graph;
    vector<vector<int>> rGraph;
    vector<int> left;
    vector<int> right;

public:
    Graph(int N, vector<int> left, vector<int> right) {
        this->N = N;
        graph = vector<vector<int>>(N + 2);
        rGraph = vector<vector<int>>(N + 2);
        this->left = left;
        this->right = right;

        for (int i = 0; i < N + 2; i++) {
            graph[i] = vector<int> (N + 2);
            rGraph[i] = vector<int>(N + 2);
        }
    }

    void addEdge(int a, int b) {
        graph[a][b] = 1;
    }

    int findMaxMatching() {
        for(int i:left) {
            addEdge(0, i);
        }
        for(int i:right) {
            addEdge(i, N + 1);
        }

        // for (int i = 0; i < N + 2; i++) {
        //     for (int u = 0; u < N + 2; u++) {
        //         cout << graph[i][u] << " ";
        //     }
        //     cout << "\n";
        // }
        return fordFulkersons(0, N + 1);
        //return 1;
    }

    bool bfs(int source, int sink, int parent[]) {
        bool visited[N + 2];
        memset(visited, 0, sizeof(visited));

        queue<int> q;
        q.push(source);
        visited[source] = true;
        parent[source] = -1;

        while(!q.empty()) {
            int u = q.front();
            q.pop();

            for (int v = 0; v < N + 2; v++) {
                if(visited[v] == false && rGraph[u][v] > 0) {
                    if(v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    q.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    int fordFulkersons(int source, int sink) {
        int u, v;

        for (u = 0; u < N + 2; u++) {
            for (v = 0; v < N + 2; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        int parent[N + 2];

        int max_flow = 0;

        while(bfs(source, sink, parent)) {
            int path_flow = INT_MAX;
            for(v = sink; v != source; v = parent[v]) {
                u = parent[v];
                path_flow = min(path_flow, rGraph[u][v]);
            }

            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }
};

int main() {
    vector<int> left = {1, 2, 3, 4};
    vector<int> right = {5, 6, 7, 8};
    Graph max_match(8, left, right);

    max_match.addEdge(1, 5);
    max_match.addEdge(2, 7);
    max_match.addEdge(3, 5);
    max_match.addEdge(3, 6);
    max_match.addEdge(3, 8);
    max_match.addEdge(4, 7);

    cout << max_match.findMaxMatching() << "\n";

    int minimumNodeCover = max_match.findMaxMatching();
    int maximumIndependentSet = 8 - max_match.findMaxMatching();

    cout << "Minimum Node Cover Size " << minimumNodeCover << "\n";
    cout << "Maximum Independent Set Size" << maximumIndependentSet << "\n";
}