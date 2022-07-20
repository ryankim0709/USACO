# Dijkstra's Algorithm

Dijkstras algorithm also helps us find the minimum distance from one node to every other node, however it requires **that there are no negative edges within the graph**. However, Dijkstras algorithm is more eficient than Bellman-Ford because it only processes each edge once. In Dijkstra's algorithm, we use a `priority_queue<pair<int, int>> q` where pairs in `q` contains `{-d, x}` distance from the starting node to `x` is `d`. Within our pair, we store `-d` because by default, `priority_queue` sorts in descending order and since we want the shortest distance, we will use `-d` in order to sort our distances by the shortest distance. We then process the next node if it not unprocessed. For each unprocessed node we will visit all of its edges and update any edge lengths through **relaxation**. If an edge `b` is relaxed, then we add `{-distance[b], b}` to our priority queue. What is so remarkable about Dijkstra's algorithm is that once we visit a node, it's distance is final and we do not visit the node again.

```cpp
// Complexity: O(nm), however it is more optimized than Bellman Ford
bool processed[N];
for (int i = 0; i < N; i++) { // Is node processed
    processed[i] = false;
}

int distance[N];
for (int i = 0; i < N; i++) { // Set distances to infinity
    distance[i] = INF;
}

distance[start] = 0; // From start to start is 0
priority_queue<pair<int, int>> q;
q.push({0, start}); // distance to start is 0

while(!q.empty()) {
    int a = q.top().second;
    q.pop();
    if(processed[a]) continue;
    processed[a] = true;
    for(auto u:adjList[a]) { // Process nodes
        int b = u.first, w = u.second;
        if(distance[a] + w < distance[b]) {
            distance[b] = distance[a] + w;
            // We store b because priority queue sorts from largest to smallest
            q.push({-distance[b], b});
        }
    }
}

for (int i = 0; i < N; i++) {
    cout << "Distance from " << start << " to " << i << " is" << distance[i] << "\n";
}

```
