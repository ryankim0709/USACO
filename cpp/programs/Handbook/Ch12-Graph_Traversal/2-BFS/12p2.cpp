#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int V;
    map<int, vector<int>> adjList;

public:
    Graph(int V) 
    {
        this->V = V;
    }
    void addNeightbor(int s, int e) {
        adjList[s].push_back(e);
    }

    void bfs(int v, bool visited[], int dist[]) {
        queue<int> q;

        visited[v] = true;
        q.push(v);

        while(!q.empty()) {
            int s = q.front();
            q.pop();

            for(auto u:adjList[s]) {
                if(visited[u])
                    continue;
                visited[u] = true;
                dist[u] = dist[s] + 1;
                q.push(u);
            }
        }

        cout << "Start node: " << v << "\n";
        for (int i = 0; i < V; i++)
        {
            cout << "From start node " << v << " node " << i << " is " << dist[i] << " steps away\n";
        }
    }

    void bfsPrep(int start) {
        bool *visited = new bool[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        int *dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = 0;
        }

            bfs(start, visited, dist);
    }
};

int main() {
    Graph bfsTest(6);
    bfsTest.addNeightbor(0, 1);
    bfsTest.addNeightbor(0, 3);
    bfsTest.addNeightbor(1, 0);
    bfsTest.addNeightbor(1, 2);
    bfsTest.addNeightbor(1, 4);
    bfsTest.addNeightbor(2, 1);
    bfsTest.addNeightbor(2, 5);
    bfsTest.addNeightbor(3, 0);
    bfsTest.addNeightbor(4, 5);
    bfsTest.addNeightbor(4, 1);
    bfsTest.addNeightbor(5, 4);
    bfsTest.addNeightbor(5, 2);

    bfsTest.bfsPrep(0);
}