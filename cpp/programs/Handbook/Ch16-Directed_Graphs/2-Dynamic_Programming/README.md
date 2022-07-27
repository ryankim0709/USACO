# Dynamic Programming with Directed Graphs

We can combine what we have leearned about graph thus far to compute many values

- Number of different paths
- Shortest/longest path
- Maximum/minimum numbers of edges in a path
- Which node certainly appears in **any** path.

## Counting the number of paths
We know that the number of paths to node `i`, is the sum of the number of paths that lead to node `i`. In other words `paths(x) = paths(a1) + paths(a2) + ... + paths(ak)` where `a1`, `a2`, `...`, `ak` are nodes that have an edge **to x**. By definition of a topological sort, we can process each node in the ordering of a topological sort and not have to worry about any missing values.

```cpp
void findTotalPaths() {
        // Find the number of paths from the first node in the topological sort to every other node
        numPaths[topological_array[0]] = 1;
        for (int i = 1; i < N; i++) {
            numPaths[topological_array[i]] = 0;
            for (int j : from[topological_array[i]]) // All of the nodes that are pointing to a certain node
            {
                numPaths[topological_array[i]] += numPaths[j]; // # of paths = sum(# of paths to nodes pointing to that node)
            }
        }

        for (int i = 0; i < N; i++)
        {
            cout << "From " << topological_array[0] << ", there are " << numPaths[i] << " paths to " << i  << "\n";
        }
    }
```

## Extending extending Djikstra's algorithm
A by product of Dijkstra's algorithm is a **`DAG`**. If you draw drawing edges from node `a` to `b` where the edges are the edges that Dijkstra's algorithm visits, then we will end up with a **`DAG`**.Using this 