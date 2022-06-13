# Knapsack Dynamic Programming

A **knapsack** refers to a problem where a set of objects is given, and subsets with some properties have to be found. These problems can often be solved with dynamic programming.

We will focus on the following problem: Given a list of weights ```[w1, w2, .., wn]```, find all of the possible sums. In the example of ```[1, 3, 5]```, we can make the sums `[0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12]` each element once or none.

In order to solve this problem, we set our subproblem where we only use the first `k` weights to construct sums. Let `possible(x,k)` = `true` if we can construct a sum `x` with the first `k` weights, otherwise, `possible(x,k)` = `false`. We observe using this property that, `possible(x,k) = possible(x-wn, k-1) || possible(x, k-1)`. If we can make the sum `x-wn` with all of the elements before `k`, ie. `k-1`, then we can add `wn` to `x-wn` to make `x` Similarly, if we can make the sum `x` using the first `k-1` weights, we do not have to use weight `wn`, thus making sum of `x` within the first `k` weights. As the **base case**, `possible(x, 0) = true` if `x == 0` and `possible(x, 0) = false` if `x != 0`. 

```cpp
// Solution with 2-D array

possible[n + 1][n + 1];
possible[0][0] = true;

for(int k = 1; k <= n; k ++) {
    // W is the sum of all of the weights
    for(int x = 0; x <= W; x++) {
        // a |= b => a = a | b => a = a || b => a = a or b
        if(x-w[k] >= 0) {
            possible[x][k] |= possible[x-w[k]][k-1];
            possible[x][k] |= posible[x][k-1];
        }
    }
}
```

However, there is a much faster implementation using a 1-D array.
```cpp
// Solution with 1-D array
// The trick to this solution is to build the array from the back

possible[n + 1];
possible[0] = true;
for(int k = 1; k <= n; k++) {
    for(int x = W; x >= 0; x --) {
        if(possible[x]) {
            // If we can build x, then we can also build x + w[k], which is x plus our current position.
            possible[x + w[k]] = true;
        }
    }
}
```