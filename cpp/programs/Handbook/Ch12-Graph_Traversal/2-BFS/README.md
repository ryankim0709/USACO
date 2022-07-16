# Breadth-First Search
Breadth first search is another graph traversal algorithm, but takes a different approach from DFS. When DFS explores as deeply as possible, BFS will explore as **widely** as possible. Specifically, BFS traverses nodes in **increasing order of their distance from the starting node**. This can be achieved using a *queue* structure which is first in, first out. Unlike DFS, BFS can be done with a single while loop. In essence, we are traversing a tree one row at a time.

```cpp
// Time complexity: O(n + m)
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Graph class
class Graph {
    int V; // Size
    map<int, vector<int>> adjList; // Adjacency list

public:
    Graph(int V) // Constructor
    {
        this->V = V;
    }
    void addNeightbor(int s, int e) {
        adjList[s].push_back(e);
    }

    void bfs(int v, bool visited[], int dist[]) {
        queue<int> q; // Queue

        visited[v] = true; // First node is visited
        q.push(v); // Process this first node

        while(!q.empty()) { // While we still have nodes to process
            int s = q.front(); // Next node is q.front()
            q.pop();

            for(auto u:adjList[s]) { // For all of it's connections
                if(visited[u]) // Skip if it's been visited
                    continue;
                visited[u] = true; // We now visited u
                dist[u] = dist[s] + 1; // Distance from center is distance from s + 1
                q.push(u); // Add u for processing
            }
        }

        cout << "Start node: " << v << "\n";
        for (int i = 0; i < V; i++)
        {
            cout << "From start node " << v << " node " << i << " is " << dist[i] << " steps away\n";
        }
    }

    void bfsPrep(int start) {
        // Initialize visited array
        bool *visited = new bool[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Initialize distance array
        int *dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = 0;
        }

            bfs(start, visited, dist);
    }
};

int main() {
    // make and intialize graph
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

    // BFS
    bfsTest.bfsPrep(0);
}
```