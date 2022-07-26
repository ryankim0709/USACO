# Tree Diameter
The diameter of a tree is the length between any two nodes. There are two `O(n)` solutions in finding the diameter of a tree.

## Double DFS
In this solution, we will be running DFS 2 times. We start by choosing an arbitrary node. We can DFS from that node in order to find the node **furthest away** from that starting node. Once we find the node furthest from the starting node, we can DFS from that node (the one furthest away from the starting node). During the second DFS however, we must find the node **futhest away** from the node that is futhest away from the starting node.

```cpp
// Getting the futhest node
void dfsFurthest(int s, int e, int currLength) {
    currLength++; // Increase the size by one
    if(currLength > currLongest) { // If the current size > current longest length
        currLongest = currLength;
        furthestNodeID = s;
    }

    for(int i:adjList[s]) {
        if(i != e)
            dfsFurthest(i, s, currLength);
    }
}
```

## Dynamic Programming
In this algorithm, we will first root the tree arbitrarily. After the tree is rooted, we know that the longest path from the root node to a leaf node is the futhest distance from one it's children to a leaf node. Thus, we know that `toLeaf[i] = max(toLeaf[childrenNodes])`. Then, we know that `diameter = max(toLeaf[childrenOfRoot]) + secondMax(toLeaf[childrenOfRoot]);`

```cpp
void diameter(int s, int e) {
    for(int u:adjList[s]) {
        if(u != e) {
            diameter(u, s);
            toLeaf[s] = max(toLeaf[s], toLeaf[u] + 1); // + 1 since child to that node is length 1
        }
    }
 }

 void getDiameter(int root) {
    int diameter = 0;
    for (int i = 1; i < N; i++) {
        for (int j = 1; j < N; j++) {
            if(i == j)
                continue;
            diameter = max(diameter, toLeaf[i] + toLeaf[j]);
        }
    }

    cout << "The total diameter of this tree is " << diameter + 2 << "\n";
}
```