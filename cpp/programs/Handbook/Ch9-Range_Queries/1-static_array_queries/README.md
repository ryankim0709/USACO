# Static array queries

We will be working with the array `[1,3,4,8,6,1,4,2]`

## Sum queries (1-D)

For sum queries, we will be creating a prefix array. A prefix array will contain the sum of all preceding elements in a list. The length of the prefix array will be `n` and the starting element will be the first element of `arr`. We can construct a prefix array defining `prefix[i] = prefix[i - 1] + arr[i];`. In our example, our prefix array would be `[1,4,12,18,19,23,25]`.

Now, we can tell that our `prefix[i]` is the sum of all elements from `arr[0]` to `arr[i - 1]`. Using this information, we can find the sum from `arr[a]` to `arr[b]`. Since `prefix[i]` is the sum of all elements from `0` to `i - 1` in our original array, we know that `sum(a, b) = prefix[b] - prefix[a-1]`. I would suggest drawing out an example and it will make clear sense.

## Sum queries (2-D)

Similar to 1-D queries, we need to make a 2-D `prefix` matrix. The formula for this 2-D prefix matrix is, `prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i - 1][j-1] + arr[i][j]`. Again, drawing will really help understand this concept.

Now if we want to find the sum of values from `(x1, y1)` to `(x2, y2)` where `(x1, y1)` is the upper left and `(x2, y2)` is the lower left, our formula is `sum(x1, y1, x2, y2) = prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1][y2-1] + prefix[x1 - 1][y1 - 1];`
