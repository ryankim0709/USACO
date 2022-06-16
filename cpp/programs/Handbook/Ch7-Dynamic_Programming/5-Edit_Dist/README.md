# Edit Distance

In this problem, we are allowed three operations, 
    1. Insert a character (eg. ABC => ABCA)
    2. Remove a character (eg. ABC => AC)
    3. Modify a character (eg. ABC => ADC)

We are to find the minimum number of edits to turn string `a` into string `b`. For example, the edit distance between `love` and `movie` is `2` because `love => move => movie`. To solve this problem, we can set up a 2-D matrix, `distance[n + 1][m + 1]` where `n` is the length of `a` and `m` is the length of `b`. `distance[i][j]` will represent the minimum edits between the prefixes `a[0...i]` and `b[0...j]`. Since we have 3 total operations, we can define `distance[i, j] = min(distance[i, j-1] + 1, distance[i - 1][j] + 1, distance[i-1][j-1] + cost(i, j))` where `cost(i, j) = 1 if a[i] != b[j]` and `cost(i, j) = 0 if a[i] == b[j]`.

```cpp
// Solution for Edit Distance
// Complexity O(n^2)

string a, b;
cin >> a >> b;
int n = a.length();
int m = b.length();

int distance[n + 1][m + 1];
for(int i = 0; i <= n; i++) 
    distance[i][0] = i;

for(int j = 0; j <= m; j++)
    distance[0][j] = j;

for(int i = 1; i <= n; i ++) {
    for(int j = 1; j <= m; j ++) {
        int cost = (a[i] == b[j]) ? 1 : 0;
        distance[i][j] = min(distance[i - 1][j] + 1, distance[i][j-1] + 1, distance[i-1][j-1] + cost);
    }
}

cout << distance[n][m];
```