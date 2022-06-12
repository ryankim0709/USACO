# Paths on a grid
In this problem, we are tasked to find a path from the top left to the bottom right such that we maximze the sum of the squares to visit. As an example, in the following,
| 3 | 7 | 9 | 2 | 7  |
|---|---|---|---|----|
| 9 | 8 | 3 | 5 | 5  |
| 1 | 7 | 9 | 8 | 5  |
| 3 | 8 | 6 | 4 | 10 |
| 6 | 3 | 9 | 7 | 8  |

the most optimal path would be ```3 => 9 => 8 => 7 => 9 => 8 => 5 => 10 => 8```. To solve this problem, instead of a 1-Dimensional array to store our results, we need a 2-Dimensional array called ```sum[n][n]```. We define ```sum[i][j]``` as the maximum sum a path can yield to position ```[i][j]```.

The solution to this problem is fairly simple, we simply have to determine which of ```sum[i-1][j]``` or ```sum[i][j-1]``` is greater. The problem statement states that we are only allowed to "move" right or down, so we must check the cells to the left and up of us.

```cpp
// Solution paths on grid
// Complexity O(n^2)

int sum[n][n];

for(int i = 1; i < n; i++) {
    for(int j = 1; j < n; j++) {
        // In the code, graph is the original graph we are given
        sum[i][j] = max(graph[i-1][j], graph[i][j-1]) + graph[i][j];
    }
}

cout << sum[n-1][n-1] + graph[0][0];
```