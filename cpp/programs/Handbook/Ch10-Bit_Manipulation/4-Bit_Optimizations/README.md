# Bit Optimizations

Many problems could be optimized using bits, and here are a couple examples of the usefulness of bit operations.

## Hamming Problem
The **Hamming Distance** of `(a,b)` is the number of positions where the strings differ. For example `hamming(11101, 11001)=2` since the there are tow positions in which the values are different. A striaght forward approach in solving this problem would be running a for loop across the two strings and comparing which values are different. However, if `k <= 32`, we can store the string in an `int`. Then, we can use the `XOR` operator on the two integers because `XOR` returns 1 if the two values at a givien position are different. We can then process the final set using a for loop to check how many `1` occur in the set.

## Counting subgrids problem
We are tasked to find the number of subgrids filled with `0`(white) and `1`(black) such that al `4` corners of the subgrid is black. The brute force implementation would be to generate all possible pairs of rows. After finding `a` and `b`, we would find the number of columns such that `color[a][i] == 1 && color[b][i] == 1`. We can then plug `count` into `count(count - 1)/2` since we must choose `2` of the `count` valid columns to place our barriers.

To optimize this solution, we can group each row by `N` elements. After grouping the rows into `N` elements, we would only have to iterate `n/N` compared to `n`. This is because once we group the row by `N`, we can easily compare `color[a][i]` and `color[b][i]` with the `&` operator.