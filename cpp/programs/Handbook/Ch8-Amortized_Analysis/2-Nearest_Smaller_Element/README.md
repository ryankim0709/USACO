## Nearest smaller element

In this problem, we are givin an array. Our task is to find the nearest preceding element that is smaller than the current element for each element. If there are no preceding elements that are smaller than the current element, return -1.

We will be solving this problem using a **stack**. Rembmer that stacks are **first in last out**. For each element, `currElem`, we first check the top of the stack. If the very first element of the stack is _smaller than_ `currElem`, we can conclude that the nearest smallest element, is the top of the stack. If this is not the case, we have to _continuously `pop()` elements_ of the stack until we find a value that is smalelr than `currElem`. If the size of the stack becomes `0`, we can return `-1` since this means there are no remaining elements.


```cpp
// Solution for Nearest smaller element
// Complexity is O(n) because we add/subtract each value at most once

stack<int> solStack; // Solution stack

    for (int i = 0; i < N; i++) {
        int currElem = arr[i];

        if(solStack.size() == 0) {
             // Already empty, then return -1
            cout << -1 << "\n";
            solStack.push(currElem);
        }
        else
        {
            if(solStack.top() < currElem) {
                // Top is smaller
                cout << solStack.top() << "\n";
                solStack.push(currElem);
            } else {
                // Keep popping from the stack
                while(solStack.size() > 0) {
                    if(solStack.top() < currElem) {
                        cout << solStack.top() << "\n";
                        break;
                    } else {
                        solStack.pop();
                    }
                }

                if(solStack.size() == 0) {
                    // If there is nothing in the stack afterwards
                    cout << -1 << "\n";
                }
                solStack.push(currElem);
            }
        }
    }
```