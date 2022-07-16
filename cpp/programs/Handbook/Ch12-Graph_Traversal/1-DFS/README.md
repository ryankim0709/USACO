# Depth-First Search (DFS)
Depth first search or DFS is a graph traversal technique in which we travel to every other possible node from the given node. DFS will follow one path which is why it is name **Depth** first search. We are searching as **deeply** as possible within the graph, then backtracking to explore more. We implement DFS through an adjacency list and *recursion*. We also **must** keep track of all visited nodes so that we don't revisit them. Without this measure, our recursive function would continue infinetely. 

```cpp
// Imports
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Create a graph class
class Graph {
    int V; // number of verticies
    map<int, vector<int>> adjList; // Adjacency list


public:
    Graph(int V) // Get the size of the graph
    {
        this->V = V; // Set size
    }
    void addNeighbor(int s, int e) {
        adjList[s].push_back(e); // Add a connection from s -> e
    }
    void dfs(int v, bool visited[]) {
        visited[v] = true; // We have now visited the node!
        cout << v << " "; // Output/process node
        vector<int>::iterator i; 
        for (i = adjList[v].begin(); i != adjList[v].end(); ++i) { // For all reachable nodes from this node
            if(!visited[*i]) // If we have not explored the node
                dfs(*i, visited); // Explore!
        }
    }

    void dfsPrep(int start, int v) { // For dfs preparation
        // Initialize an empty boolean array for visited
        bool *visited = new bool[v];
        for (int i = 0; i < v; i++) { // Set all values to false
            visited[i] = false;
        } 
        dfs(start, visited); // Start the dfs
    }
};

int main() {
    Graph dfsTest(5);

    // Graph building
    dfsTest.addNeighbor(0, 1);
    dfsTest.addNeighbor(0, 3);
    dfsTest.addNeighbor(1, 0);
    dfsTest.addNeighbor(1, 2);
    dfsTest.addNeighbor(1, 4);
    dfsTest.addNeighbor(2, 1);
    dfsTest.addNeighbor(2, 4);
    dfsTest.addNeighbor(3, 0);
    dfsTest.addNeighbor(4, 1);
    dfsTest.addNeighbor(4, 3);

    dfsTest.dfsPrep(0, 5);
    cout << "\n";
}
```