# Kruskals Algorithm
Kruskal's algorithm is quite simple. We will be traversinng through **all** of the edges in order of edge weights in ascending order. After ordering our edges in ascending order, we will add the edge to our minimum spanning tree if and only if adding that edge would not create a cycle. We can use a **Union_Find** data structure in order to complete this task.

```cpp
void Kruskals_Algo() {
    Union_Find minTree(N); // Initialize Union_Find
    for (auto e : edgeList) // Edge list sorted by weight
    {
        int w, a, b;
        tie(w, a, b) = e;

        if(minTree.same(a, b) == 0) { // If a and b do not have the same representative
            minTree.unite(a, b);
        }
    }

    minTree.expressTree();
}
