# Applications
In this section we will go over different applications of DFS and BFS. It is worth noting that in practice, DFS is a better choice because it is easier to implement. In this section we will go over various applications of graph traversal.

## Connectivity Check
A **connected** graph is a graph in which all nodes can be visited through a path from a starting node. We can check whether a graph is connected or not through a graph search. After DFS or BFS, if `visited[i] = 0`, we can conclude that the graph *is not* connected.

```cpp
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
```

## Finding if cycles exist
A graph contains a cycle if we find a node neightbor who has already been visited. This excludes the previous node. Using DFS, we can determine if a graph has cycles if `visited[i] == true && i != prev`. Additionally, we can count the number of edges since we know that if `m = n - 1`, the graph is a tree and there are not cycles.
```cpp
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
```   

## Bipartiteness check
Checking bipartiteness using DFS/BFS is extremely simple. Instead of having `visited`, we can create an array `coloring`. `coloring[i] = 0` if the color of the node is *red*, `coloring[i] = 1` if the color of the node is *blue*, and `coloring[i] = -1` if the node has not been visited. Before we explore onto the next node, we check whether it has been visited **and if it has been, the color**. If the color of the next node is the same coloring as the current node, we know that the graph is not bipartite by definition.

```cpp
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
```