# Cycle Detection
Given a successor graph, we know that there must be a cycle within the graph. We know this because that is the definition of a successor graph. Finding the start of the cycle is the problem that will be solved in this section. The simplist way to solve this problem would be to use DFS to go through all of the nodes, then when one of the nodes are visitied for a second time, then we have come back to the start of the cycle. However, this implementation takes `O(n)` time which can be very inefficient.

## Floyds Algorithm
Floyds algorithm is quite a simple algorithm to understand. We start by using two pointers starting at the same node, and at each step, we will increase pointer `a` one step and increase pointer `b` **two** steps. We will continue this cycle until the two pointers meet. This will work because pointer `b` is only moving one more step ahead of pointer `a`, so they will eventually meet, which is the start of the cycle.

```cpp
int floyds() {
    int a = succ(0);
    int b = succ(succ(0));

    while(a != b) {
        a = succ(a); // One step
        b = succ(succ(b)); // Two steps
    }
    return a;
}
```
Floyds algorithm can also be extended in order to find out the length of the cycle. Since we know the start of the cycle, we need to start the pointer at `start` and call `succ(start)` until we reach `start` again. This can be implemented like so,

```cpp
int cycleLength() {
    int first = floyds();
    int b = succ(first);
    int length = 1;

    while(b != first) {
        b = succ(b);
        length++;
    }

    return length;
}
```