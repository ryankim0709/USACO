# Competitive Programming Handbook

In this chapter, I learned about the various data structures in C++. Here are a quick summary of the studied data structures.

## 1. Dynamic Arrays
These are usually the *vector<>* data structure. You can use ```push_back```, ```pop_back()```, and ```erase()```. Using ```vector<> a(z)``` will intialize a vector with ```z``` elements which are **all 0**. We can use ```vector<> a(x, y)``` to create a vector of size ```x``` filled with ```y```.

## 2. Sets
There are two main sets in C++, ```set<>``` and ```unordered_set<>```. ```set<>``` is similar to ```HashSet<>()``` in Java and inserts elements in ```O(log n)``` time, but has very useful functions such as ```lower_bound()```, ```upper_bound```, and ```equal_range()```. On the other hand, ```unordered_set<>``` is similar to ```TreeSet<>()``` in Java and inserts elements in ```O(1)``` time, but does not have as many useful functions. Additionally, elements of ```set<>``` are sorted while elements of ```unordered_set<>``` are not.

## 3. Maps
Similarly, there are ```map<>``` and ```unordered_map<>``` which are similar to ```HashMap<>()``` and ```TreeMap<>()``` repectively. The ```map``` structure takes about ```O(logn)``` to access elements while ```unordered_map<>``` takes around ```O(1)```. Similarly, not only does ```map<>``` auto-sort by keys, it is capable of performing many more useful functions.

## 4. Iterators
Iterators is a variable that points to an element in a data strucutre. It does not contain a value, but a reference to a value. Use ```*it``` to retrieve the value of the reference. An iterator has a ```it.begin()``` and ```it.end()```. Performing ```it ++``` will move the pointer to the next reference in the data strucutre.

## 5. Bitset
A bitset is an *array* whose values are **either 0 or 1**. We can also make binary strings into bitsets using the following syntax, ```bitset<n> s(string(binary))```. Using bitsets, we can perform operations such as ```&```, ```|```, and ```^``` which are and, or, and XOR, respectively. 

## 6. Deque
A deque is a dynamic array in which the size can be efficiently changed at both ends. In addition to ```push_back()``` and ```pop_back()```, deque also offers ```push_front()``` and ```pop_front()```.

## 7. Stack
A stack is a **FILO** data structure which represents **First In Last Out**. The stack offers insertion and deletion in ```O(1)``` time. Stacks only allow for access and deletion of the topmost element.

## 8. Queue
A queue is a **FIFO** data structure which represents **First In First Out**. The queue also offers insertion and deletion in ```O(1)``` time. You can access the first and last element of a queue using ```q.front()``` and ```q.back()```.

## 9. Priority Queue
A priority queue is essentially a queue that automatically **sorts itself in descending order**, thus the top of the priority queue is the *greatest value*. It supports insertion an, depending on the type of queue, retrieval and removal of either the minimum or maximum element. Insertion and removal are in ```O(logn)``` and retrieval takes ```O(1)```. If we want a priority queue that sorts in ascending order and remove the smallest element, we can use the following syntax, ```priority_queue<int, vector<int>, greater<int>>q```.