# Finding Ancestors

The `kth` ancestor of a node `x` in a _rooted tree_ is the node that will be reached after moving `k` levels up from `x`. We would like to find `ancestor(x, k)` which denotes the `k` of node `x`. Intuitively, we can easily find this value by moving upwards `k` times, however, this would leave to a complexity of `O(n)`. Using the same strategy from section `16.3`, we can lower the complexity to `O(logk)`. By precalculating `ancestor(x, k)` where `k` is a power of `2`, we can use these preprocessed values to claculate `ancestor(x, k)` in `O(logk)` time.
