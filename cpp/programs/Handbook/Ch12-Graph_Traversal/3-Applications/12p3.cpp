#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int n;
    list<int> *adjList;
    int edges = 0;
    bool bipartiteness = true;

public:
    Graph(int N) {
        this->n = N;
        adjList = new list<int>[N];
    }
    void addNeighbor(int s, int e) {
        adjList[s].push_back(e);
    }
    void dfs(int curr, bool visited[]) {
        visited[curr] = true;
        list<int>::iterator i;

        for (i = adjList[curr].begin(); i != adjList[curr].end(); ++i) {
            if(!visited[*i]) {
                dfs(*i, visited);
            }
        }
    }
    string checkConnectivity(int n) {
        bool *visited = new bool[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        dfs(0, visited);

        for (int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                return "Not connected";
            }
        }
            return "Connected";
    }
    void dfsCycles(int curr, int prev,  bool visited[]) {
        visited[curr] = true;
        edges++;
        list<int>::iterator i;
        for (i = adjList[curr].begin(); i != adjList[curr].end(); i++) {
            if(visited[*i] && *i != prev) {
                edges = n;
                return;
            }
            if(!visited[*i]) {
                dfsCycles(*i, curr, visited);
            }
        }
    }
    string containsCycles(int n) {
        bool *visited = new bool[n];
        for (int i = 0; i < n; i ++) {
            visited[i] = false;
        }
        if(edges == n - 1) {
            return "No cycles";
        }
        return "Cycles";
    }

    void dfsIsBipartite(int curr, int prev, int color[]) {
        // 1 is blue, 0 is red
        // First node is always blue
        if(color[prev] == 1)
            color[curr] = 0;
        else
            color[curr] = 1;

        int currColor = color[curr];
        list<int>::iterator i;
        for (i = adjList[curr].begin(); i != adjList[curr].end(); i++) {
            if(color[*i] == currColor) {
                bipartiteness = false;
                return;
            }
            if(color[*i] == -1) {
                dfsIsBipartite(*i, curr, color);
            }
        }
    }

    string isBipartite(int n) {
        int *color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        color[0] = 0;
        dfsIsBipartite(0, 0, color);

        if(!bipartiteness)
            return "Graph is not bipartite";
        return "Graph is bipartite";
    }
};

int main() {
    int n = 5;
    Graph connectivityCheck(n);

    connectivityCheck.addNeighbor(0, 2);
    connectivityCheck.addNeighbor(0, 3);
    connectivityCheck.addNeighbor(1, 4);
    connectivityCheck.addNeighbor(2, 0);
    connectivityCheck.addNeighbor(2, 3);
    connectivityCheck.addNeighbor(3, 2);
    connectivityCheck.addNeighbor(3, 0);
    connectivityCheck.addNeighbor(4, 1);

    cout << connectivityCheck.checkConnectivity(n) << "\n";
    cout << connectivityCheck.containsCycles(n) << "\n";

    Graph bipartitenes(n);
    bipartitenes.addNeighbor(0, 1);
    bipartitenes.addNeighbor(0, 3);
    bipartitenes.addNeighbor(1, 0);
    bipartitenes.addNeighbor(1, 2);
    bipartitenes.addNeighbor(1, 4);
    bipartitenes.addNeighbor(2, 1);
    bipartitenes.addNeighbor(2, 4);
    bipartitenes.addNeighbor(3, 0);
    bipartitenes.addNeighbor(3, 4);
    bipartitenes.addNeighbor(4, 1);
    bipartitenes.addNeighbor(4, 2);

    cout << bipartitenes.isBipartite(n) << "\n";
}