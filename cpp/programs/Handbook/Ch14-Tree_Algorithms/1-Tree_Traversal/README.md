# Tree Traversal
Since a tree is a type of graph, DFS and BFS are still popular ways of traversal. However, we can take use of the fact that a tree has **no cycles**. This becomes useful because we don't need to store the visited values in a boolean. Since there are no cycles, we just need to make sure the current node doens't travel back the node it came from. More specifically, we run `dfs` if `u != e` where `u` is a possible node we could travel to and `e` is the previous node. 

```cpp
void dfs(int s, int e) {
    cout << s << " ";
    for(auto u:adjList[s]) {
        if(u != e) // Possible != past node
            dfs(u, s);
    }
}
```

Trees are also useful because we can find useful information in `O(n)` time using **Dynamic Programming**. We can find the number of nodes in the subtree of each node in `O(n)` time. 

``` cpp
void dfsNodesBelow(int s, int e, int count[]) {
    count[s] = 1;
    for(auto u:adjList[s]) {
        if(u == e) continue;
        dfsNodesBelow(u, s, count);
        count[s] += count[u]; // Count of current is itself + sum of node under itself.
    }
}
```