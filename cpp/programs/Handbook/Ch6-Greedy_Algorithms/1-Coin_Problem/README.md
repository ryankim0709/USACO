# Coin Problem
In this problem we will be given ```coins={c1,c2,c3...}``` and we can use each coin as many times as we want. We have to find the minimal amount of coins to make the combined coin value ```n```.


For example, if we are given ```{1,2,5,10,20,50,100,200}``` and ```n = 520```, the smallest number of coins would be 4, 200 + 200 + 100 + 20 = 520.


The algorithm for this would be to use the largest coins possible, which works in the scenario above. This makes sense because it get us closer to our target value.

However, this greedy algorithm could fail. For example, if we were given ```{1,3,4}``` and ```n=6```, our algorithm to use the highest coin values would return 1 + 1 + 4 = 6, however, the optimal solution would be 3 + 3 = 6.