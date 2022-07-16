#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Create a graph class
class Graph {
    int V; // number of verticies
    map<int, vector<int>> adjList;


public:
    Graph(int V)
    {
        this->V = V;
    }
    void addNeighbor(int s, int e) {
        adjList[s].push_back(e); // Add a connection from s -> e
    }
    void dfs(int v, bool visited[]) {
        visited[v] = true;
        cout << v << " ";
        vector<int>::iterator i; 
        for (i = adjList[v].begin(); i != adjList[v].end(); ++i) {
            if(!visited[*i])
                dfs(*i, visited);
        }
    }

    void dfsPrep(int start, int v) {
        bool *visited = new bool[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        cout << typeid(visited).name();
        dfs(start, visited);
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