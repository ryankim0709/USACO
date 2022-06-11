# Scheduling Problem

In this problem, we are tasked to find the most amount of events we can attend given the start and end times of each event.

| Event | Starting Time | Ending Time |
| ----- | ------------- | ----------- |
| A     | 1             | 3           |
| B     | 2             | 5           |
| C     | 3             | 9           |
| D     | 6             | 8           |


There are *three* greedy approaches we will be exploring

## Greedy 1 ~ Picking the shortest event

In this example, the method may work<br/>
A: **--** <br/>
B: *------- <br/>
C: ******------- <br/>
D: ***********---** <br/>

However, in this example, the algorithm fails <br/>
A: **-----** <br/>
B: ***- <br/>
C: ******-------** <br/>
 The answer would be ```A``` and ```C```, however, this algorithm fails to detect that

 ## Greedy 2 ~ Choosing events that start the earliest

 In this example, the method may work<br/>
A: **--** <br/>
B: *------- <br/>
C: ******------- <br/>
D: ***********-------** <br/>

However, in this example, the algorithm fails <br/>
A: **---------------------** <br/>
B: ***- <br/>
C: ***********-------** <br/>
 The answer would be ```B``` and ```C```, however, this algorithm 

 ## Greedy 3 ~ Choosing events that end the earliest

 It turns out that this algorithm *always* produces the optimal solution. There are not ways to prove a greedy algorithm however through logic or math.