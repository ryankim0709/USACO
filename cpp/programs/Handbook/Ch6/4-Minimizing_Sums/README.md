# Minimizing Sums
In this problem, we are given ```n``` numbers ```a1, a2, a3, a4, ..., an```, and our task is to find ```n``` to minimize ```|a1 - x|^c + |a2 - x|^c + ... + |an - x|^c```. In this problem we will focus on *c = 1* and *c = 2*.

## Case c = 1
In this case, we are minimizing ```|a1 - x| + |a2 - x| + ... + |an - x|```. In this case, it turns out that using the **median value** for ```x``` is the correct greedy algorithm to minimize our sum.

## Case c = 2
In this case, we are minimizing ```|a1 - x|^2 + |a2 - x|^2 + ... + |an - x|^2```. To minimize this sum, using the **average/mean value** for ```x``` is the correct greedy algorithm to minizue our sum.