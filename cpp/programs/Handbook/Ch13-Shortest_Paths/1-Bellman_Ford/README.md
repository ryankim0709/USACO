# Bellman-Ford Algorithm

The Bellman-Ford algorithm is a unique algorithm that allows us to find the shortest distance from one node to all other nodes given that the graph **has no cycles with negative lengths.** However, the Bellman-Ford algorithm can detect negative cycles. Initially, in our `distance[]` array, we will initialize all values to `INT_MAX`. Viven a starting node `x`, we know that `distance[x] = 0`. After this, Bellman-Ford algorithm is very similar to brute force. We will loop over _all_ edges and try to reduce as many lengths as possible.

```cpp
// Time complexity O(nm) since we iterate through all m edges n-1 times
int distance[N];
for (int i = 0; i < N; i++) // Set all to INFINITY
    distance[i] = INF;

distance[start] = 0; // Distance from start to start is 0
for (int i = 0; i < N - 1; i++) { // For N - 1 times
    for(auto e:edgeList) { // Iterate through all edges
        int a, b, w; // start, end, weight
        tie(a, b, w) = e;
        distance[b] = min(distance[b], distance[a] + w); // a->b = min(current dist, a + w)
    }
}

for (int i = 0; i < N; i++)
{
    cout << "Shortest distance from  node " << start << " to node " << i << " is " << distance[i] << "\n";
}
```

We could optimize this solution by stopping the algorithm if no distance are reduced during a given round. If no distances are reduced, the distances are at a minimum. This would be a good optimization because most of the time, Bellman-Ford's algorithm finds the smallest length within `n-1` iterations.

## Detecting negative cycles

Negative cycles can be detected by running Bellman-Ford `n` times. Bellman-Fords algorithm states that we should have the minimum distances within `N - 1` iterations, however a negative number would constantly decrease the path length since `-# + -# = more negative #`. During the `Nth` iteration, we simply check if there has been a change in values, if so, there is a negative cycle.

```cpp
int distance[N];
for (int i = 0; i < N; i++)
    distance[i] = INF;

distance[start] = 0;
for (int i = 0; i < N - 1; i++) {
    for(auto e:edgeList) {
        int a, b, w;
        tie(a, b, w) = e;
        distance[b] = min(distance[b], distance[a] + w);
    }
}

// During the nth iteration
for(auto e:edgeList) {
    int a, b, w;
    tie(a, b, w) = e;
    if(distance[a] + w != distance[b]) // If there is a change
        return "Negative cycle exists";
}
return "Negative cycle does not exist";
```

## SPFA (Shortest Path Faster Algorithm)

This algorithm is an extention of Bellman-Ford. In SPFA, we initialize a `queue<int> q` we add our first element to `q`. While processing our `q`, we check if we can reduce any paths that start with `q.front()`. If a path from `q.front() -> b` is reduced, we add `b` into `q` since the new reduced path length would effect other paths that go through `b`.

```cpp
int distance[N];
for (int i = 0; i < N; i++)
    distance[i] = INF;

distance[start] = 0;
queue<int> q;
q.push(start);

while(!q.empty()) {
    int next = q.front();
    q.pop();
    for (auto e : spfaGraph[next])
    {
        int b, w;
        tie(b, w) = e;
        int past = distance[b];
        distance[b] = min(distance[b], distance[next] + w);

        if(distance[b] < past) {
            q.push(b);
        }
    }
}

for (int i = 0; i < N; i++)
{
    cout << "Shortest distance from  node " << start << " to node " << i << " is " << distance[i] << "\n";
}
```
