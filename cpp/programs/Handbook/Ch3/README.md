# Competitive Programming Handbook

In this chapter, I learned about sorting. The two main sorting algorithms that were introduced in this chapter was **bubble sort O(N^2)**, **counting sort O(N)**, & **merge sort O(NlogN)**. Both of my codes can be found in the *Sorting Theory* folder. I also established that an **inversion** is a pair of elements that are *not* in the correct order. 

I also learned to use ```sort(v.begin(), b.end())``` to sort vectors in increasing order and ```sort(v.rbegin(), v.rend())``` to sort in reverse order. Array sorting goes as follows, ```sort(arr, arr + n)```, or ```sort(arr, arr + n, greater<int>())``` for reverse order. Similarly, sorting strings is ```sort(s.begin(), s.end())```. 

I also learned about defining custom structures which are similar to *classes* which can be used to create custom sorting methods. Additionally, comparison functions can be **passed into the sort() function** if a custom sorting is desired. In these custom sorts, the function *must* return ```true``` if the element is smaller than the parameter, and ```false``` vice-versa.

Finally, we learned about binary search, an ```O(logn)``` searching algorithm, and various functions such as ```lower_bound()```, ```upper_bound()```, and ```equal_range()```.