# Coin Problem with DP
Using DP, we will be attempting to solve the problem in a quick and efficient manner. We will be using a *recursive function* and *memoization* to lower the complexity of the algorithm.

## Recursive formulation
Dynamic Programming is all about solving the problem recursively so that *the solution to the problem can be calculated from solutions to smaller subproblems*

We will define a function, ```solve(x)``` which will denote the minimum number of coins required for a sum ```x```. For example, if ```coins = {1,3,4}```, we have
<br/> ```solve(0) = 0```
<br/> ```solve(1) = 1```
<br/> ```solve(2) = 2```
<br/> ```solve(3) = 1```
<br/> ```solve(4) = 1```
<br/> ```solve(5) = 2```
<br/> ```solve(6) = 2```
<br/> ```solve(7) = 2```
<br/> ```solve(8) = 2```
<br/> ```solve(9) = 3```
<br/> ```solve(10) = 3```

The main idea of this recursive function is that we will be **focusing on the first coin**. For example, for ```solve(10)```, the first coin could be ```1```, ```3```, or ```4```. If ```1``` was our first coin, ```solve(10) = solve(10 - 1) + 1``` because since we have designated our first coin as ```1```, the remaining sum must be ```9``` and we have to add one coin to the result to compensate for the first coin. We can see that ```solve(10) = solve(7) + 1 = solve(4) + 1 + 1 = solve(0) + 3 = 3```. From this ovservation, we can formulate the following for our example, **```solve(x) = min(solve(x - 1) + 1, solve(x - 3) + 1, solve(x - 4) + 1)```**. Using this formula, we can come up with the following algorithm.

```cpp
// Recursive function
int solve(int x) {
    // INF resembles infinite
    if(x < 0) 
        return INF;
    if(x == 0)
        return 0;
    int best = INF;
    for(auto c:coins) 
        best = min(best, solve(x-c) + 1);
    return best;
}
```

## Using memoization
Even with our efficient recursive function, our algorithm is too slow. This is becausee there may be an exponential number of ways to construct all sums. To solve this problem, we can use *memoization*. In memoization we keep track of past answers to subproblems.
```cpp
bool ready[N]; // Has solve(x) been calculated?
bool value[N]; // Values of solve(x)
```

Now, our new function looks like,
```cpp
// Recursive function with memoization
// Complexity of O(nk) where n is the target sum and k is the number of coins
int solve(int x) {
    // INF resembles infinite
    if(x < 0) 
        return INF;
    if(x == 0)
        return 0;
    if(ready(x))
        return value[x];
    int best = INF;
    for(auto c:coins) 
        best = min(best, solve(x-c) + 1);
    value[x] = best;
    ready[x] = true;
    return best;
}
```

Another way to utilize memoization is to *iteravely* construct the array ```value``` using a loop
```cpp
int value[n + 1];
value[0] = 0;
for(int i = 1; i <= n; i ++) {
    // Again, INF denotes 
    value[i] = INF;
    for(auto c:coins) {
        if(x-c >= 0) { // Only go here if we can subtract c cents
            value[x] = min(value[x], value[x-c] + 1);
            // We take minimum of the current value and value(x-c) + 1 coin
        }
    }
}
```

## Constructing a solution
In addition to the value of the optimal solution, we may be asked to give an example of how such a solution can be constructed. For the coin problem, we can solve this by declaring another array, ```int first[n + 1]``` which will hold the first coin for the optimal solution.

We would have to modify our algorithm to,
```cpp
int value[n + 1];
value[0] = 0;
for(int i = 1; i <= n; i ++) {
    // Again, INF denotes 
    value[i] = INF;
    for(auto c:coins) {
        if(x-c >= 0) { // Only go here if we can subtract c cents
            value[x] = min(value[x], value[x-c] + 1);
            // We take minimum of the current value and value(x-c) + 1 coin
            first[x] = c;
        }
    }
}
```

and to print our solution, we would use,
```cpp
while (n > 0) {
    cout << first[n] << "\n";
    n -= first[n];
}
```

Another variation of the problem could be to count the number of ways to produce a sum ```x``` using the coins. To solve this problem, we can similarly use an iterative approach as shown,
```cpp
int count[n + 1];
for(int i = 1; i <= n; i++) {
    for(auto c:coins) {
        if(x-c >= 0) {
            // Often there are so many solutions that we are asked to give our answer in mod m
            int m = pow(10, 9) + 7;
            count[x] %= m;
            count[x] += count[x - c];
        }
    }
}
```