# Bookkeeping To Sort

Another way of "sorting" a list is using a map or bookkeep. We will store all of the values in a map and the number of times they occur. Then, since C++ maps auto sort themselves in ```O(nlog(n))``` time, thus this algorithm is in ```O(nlog(n))``` time. This can still be improved. If we use a list such that the values at index ```i``` is the **number of occurences**, then our algorithm is in ```O(n)``` time.

However, there are many limitations to using lists such as,
    - Items that have to be sorted **must** be integers
    - Items must be **only integers**

On the other hand, if maps were used,
    - Items can be **any data type**
    - If they are numbers, they can be ```float```, ```double```, ```integer```. 