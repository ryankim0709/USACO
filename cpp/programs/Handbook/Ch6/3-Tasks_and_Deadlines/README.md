# Tasks and Deadlines

We are given `n` tasks with durations and deadlines. For each task, we earn `d-x` points where `d` is the task's deadline and `x` is the moment when we finsh the task.

Given the example,
| Task | Duration| Deadline |
| ----- | ------------- | ----------- |
| A | 4 | 2 |
| B | 3 | 5 |
| C | 2 | 7 |
| D | 4 | 5 |

It turns out, for this problem the most optimal greedy algorithm is to *process tasks in increasing duration*.