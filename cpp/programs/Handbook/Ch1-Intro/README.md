# Competitive Programming Handbook

**Passing C++ arrays as reference**
By default, C++ passes vectors by value, to change to call by reference, given ```vector<int> vect```, we call functions like so
```int foo(vector<int>& vect) {}```