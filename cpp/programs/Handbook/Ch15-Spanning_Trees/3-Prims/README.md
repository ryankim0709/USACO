# Prims Algorithm

Prims algorithm is another algorithm to find the minimum spanning tree and it represents Dijkstra's algorithm. We will first choose any arbitrary node `n`. After we choose `n`, we are going to put all of the edges that is possible to traverse from `n`. We will then add to our minimum spanning tree the edge with the smallest weight. After this, we will add all edges starting from the next node (the node the original node led to). We will then process the edge with the smallest edge weight in the priority queue. Note that priority queues in `C++` order their elements in `descending order`.

```cpp
void prims() {
    Union_Find min_tree(6); // Union find structure
    priority_queue<tuple<int, int, int>> edges; // {w, a, b}

    for(auto e:edgeList[0]) { // Starting node will be 0
        int a = 0;
        int b, w;
        tie(b, w) = e;
        edges.push({-w, a, b}); // Store negative because of priority queue property
    }

    while(!edges.empty()) {
        auto e = edges.top();
        edges.pop();
        int a, b, w;
        tie(w, a, b) = e;
        int bperm = b;
        if(min_tree.same(a, b) == 0) { // If they are not connected
            min_tree.unite(a, b);
            for(auto u:edgeList[b]) { // Add to our priority queue
                a = bperm;
                tie(b, w) = u;
                edges.push({-w, a, b});
            }
        }
    }

    min_tree.expressTree();
}
```
