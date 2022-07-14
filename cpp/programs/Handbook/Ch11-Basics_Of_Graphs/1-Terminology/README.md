# Graph Terminology

![Example Graph](../images/graph.png)

## Basic Terminology

A **graph** is made up of **nodes** and **edges**. `n` will denote nodes and `m` will denote edges. In the graph above, the circles, or units of data (`5`, `25`, `12`, `4`, `7`, `2`). Edges are the paths from one node to another node. In the graph above, there are `6` nodes and `7` edges.

A **path** is a collection of edges that connects node `a` to node `b`. The **length of a path** is the number of edges the path contains. For example, the graph contains the path `5 -> 12 -> 7 -> 2` of length`3` from node `5` to node `2`.

A **cycle** is path in which the first and last node is the same. In the graph above, `5 -> 12 -> 25 -> 5` is a cycle. A **simple path** is a path in which each node appears _at most once_ in a path.

## Connectivity

A **connected** graph is a graph in which there is path between any two nodes. The graph shown **above** is connected.

The following graph is a **disconnected graph** because there is no path drom `D -> E`, `A -> E`, etc.

![Disconnected Graph](../images/disconnected.png)

Connected parts of a _disconnected_ graph is called a **component**. The graph above contains `3` components, `{A, B, C, D}`, `{E}`, and `{F, G}`.

A **tree** is a connected graph that consists of _`n`_ nodes and _`n - 1`_ edges. There is a unique path between any two nodes of a tree. Below is an example of a tree structure, it contains `13` nodes and `12` edges.

![Tree Graph](../images/tree.png)

## Edge direction

![Directed Graph](../images/directed.png)

The following graph is a **directed**. A directed graph is a graph in which edges can only be traversed in the direction of the arrows. The the above graph, `2 -> 3 -> 1 -> 4` is a path from node `2` to node `4`.

## Edge weight

![Weighted Graph](../images/weighted.png)

The above grpah is known as a **weighted** graph. A weighted graph in which each edge is given a specific weight. The **length** of a path on a weighted graph is the sum of the weights of the edges on the path. For example, the length of the path `0 -> 1 -> 2 -> 3` would be `4 + 8 + 7 = 19`.