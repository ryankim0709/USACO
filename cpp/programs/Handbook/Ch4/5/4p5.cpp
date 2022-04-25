#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Bitset
    // A bitset is an array whose value is either 0 or 1
    bitset<10> s;
    s[1] = 1;
    s[3] = 1;
    s[4] = 1;
    s[7] = 1;
    cout << s[4] << "\n"; // 1
    cout << s[5] << "\n"; // 0

    // Bitset only require one bit of memory. Much faster than array and takes up less memory.
    // 1 bit VS 32 bits

    // Bitwise operators
    bitset<10> a(string("0010011010"));
    cout << a.count() << "\n"; // 4 -> returns the number of 1's

    bitset<10> b(string("0010110110"));
    bitset<10> c(string("1011011000"));
    cout << (a & b) << "\n"; // 0010010000 -> and
    cout << (a | b) << "\n"; // 1011111119 -> or
    cout << (a ^ b) << "\n"; // 1001101110 -> XOR(both are different)

    // Deque
    // A deque is a dynamic array whose size can be efficiently changed at both ends of the array
    // Uses chunks of contiguous memory instead of one contiguous block of memory

    vector<int> v;
    v.push_back(5); // [5]
    v.push_back(2); // [5, 2]
    v.insert(v.begin(), 6); // [6, 5, 2] -> doing v.begin() is pretty expensive
    // Vector has no pushing to the fron except this method
    deque<int> d;
    d.push_back(5); // [5]
    d.push_back(2); // [5, 2]
    d.push_front(3); // [3, 5, 2]
    d.insert(d.begin() + 2, 9); // [3, 5, 9, 2]
    d.pop_back();  // [3, 5, 9]
    d.pop_front(); // [5, 9]

    // Stack
    // First in last out data structure
    // Adding and removing averages to O(1)

    stack<int> st;
    st.push(3); // [3]
    st.push(2); // [2, 3]
    st.push(5); // [5, 2, 3]
    cout << st.top() << "\n"; // 5 
    st.pop(); // [2, 3]
    cout << st.top() << "\n"; // 2

    // Queue
    // First in first out data structure
    // Adding and removing averages to O(1)

    queue<int> q;
    q.push(3); // [3]
    q.push(5); // [3, 5]
    q.push(7); // [3, 5, 7]
    q.push(2); // [3, 5, 7, 2]
    cout << q.front() << "\n"; // 3
    q.pop(); // [5, 7, 2]
    cout << q.front() << "\n"; // 5

    // Priority Queue
    // Queue that sorts itself in decreasing order

    priority_queue<int> pq;
    pq.push(3); // [3]
    pq.push(5); // [5, 3]
    pq.push(7); // [7, 5, 3]
    pq.push(2); // [7, 5, 3, 2]
    cout << pq.top() << "\n"; // 7
    pq.pop(); // [5, 3, 2]
    cout << pq.top() << "\n"; // 5
    pq.pop();
    pq.push(6);
    cout << pq.top() << "\n"; // 6
    pq.pop();

    // If you want it to be increasing order
    priority_queue<int, vector<int>, greater<int>> pga; // Priority Queue Ascending
}