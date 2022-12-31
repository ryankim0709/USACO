# Errichto Video Binary Search Notes

Idea: How to search for an element in a sorted list

Cut the search space each time you search

**If search space is empty, there is no such value**

`Left` and `Right` are variables that represent the ends of the range
`mid = L + (R-L)/2` => use this because `(L+R)/2` can overflow

Complexity: `log_2(N)`
Think of Binary Search as a prefix of `True` and `False` and you are trying to find the boundary