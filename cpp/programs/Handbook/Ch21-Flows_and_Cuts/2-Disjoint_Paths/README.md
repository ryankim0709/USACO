# Disjoint paths

In this summary, we will figure out how to find the number of Edge-Disjoint paths and the number of Node-disjoint paths

## Edge Disjoint Paths

**Edge Disjoint Paths** are a set of paths such that an edge is not repeated in any of the paths. To find the maximum number of edge-disjoint paths, find the maximum flow of the graph, **assuming the capacity of each edge is `1`**.

## Node Disjoint Paths

**Node Disjoint Paths** are a set of paths such that a node is not repeated in any of the paths. In order to solve this problem, we must use a slightly more complicated approach. The most common is to split each node **except the source and since**. The first node will have all of the incoming edges of the original node, and the second node will have the outgoing edges of the original node. After this, we can find the maximum flow **assuming the capacity of each edge is `1`**.
