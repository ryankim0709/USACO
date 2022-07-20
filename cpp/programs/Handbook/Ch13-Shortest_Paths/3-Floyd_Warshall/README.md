# Floyd Warshall algorithm

Floyd Warshall algorithm is a unique solution to the Shortest Path problem because it can find the shortest paths in a **single run**. In Floyd Warshall's algorithm, we maintain a 2-D array which `matrix[i][j]` represents the distance from node `i` to node `j`. In this algorithm, once we fill in the known edges from `adjList`, we will run a for loop `N` times. The value of this for loop, `k` will be the intermediate value. This means that we must go from node `i -> k -> j`. Given this fact, we can determine that `distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j]);`.

```cpp
// Complexity O(n^3)
int distance[N][N];
for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
        if(i == j) // Distance from i to i is 0
            distance[i][j] = 0;

        else if(matrix[i][j] != INF) // If we already know the weight, then fill it in
            distance[i][j] = matrix[i][j];
        else
            distance[i][j] = INF;
    }
        }

for (int k = 0; k < N; k++) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j]);
        }
    }
}

for (int i = 0; i < N; i++) {
    cout << "\n";
    for (int j = 0; j < N; j++) {
        cout << distance[i][j] << " ";
    }
}
```

Although Floyd Warshall may be the easiest algorithm to implement, it is also the most time consuming. It is important to note that Floyd Warshall's algorithm should only be used when the graph is small and a complexity of `O(n^3)` will not `TLE`.