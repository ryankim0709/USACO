# Errichto Video Binary Search Notes

Idea: How to search for an element in a sorted list

Cut the search space each time you search

**If search space is empty, there is no such value**

`Left` and `Right` are variables that represent the ends of the range
`mid = L + (R-L)/2` => use this because `(L+R)/2` can overflow

Complexity: `log_2(N)`
Think of Binary Search as a prefix of `True` and `False` and you are trying to find the boundary

## Common mistakes

---

**Mistake 1 - Off By One**

```cpp
long long f(int x) {
	return (long long) x * x;
}

int sqrt(int x) {
	int lo = 0;
	int hi = x;
	while (lo < hi) {
		int mid = (lo + hi) / 2;
		if (f(mid) <= x) {
			lo = mid;
		} else {
			hi = mid - 1;
		}
	}
	return lo;
}
```

If x = 4, then <br/>
lo = 0, hi = 4, mid = 2 <br/>
lo = 2, hi = 4, mid = 3 <br/>
lo = 2, hi = 2, mid = 2 <br/>
. <br/>
. <br/>
. <br/>

To fix, you use `mid = (lo + hi + 1)/2` <br/>
If x = 4, then <br/>
lo = 0, hi = 4, mid = 2 <br/>
lo = 2, hi = 4, mid = 3 <br/>
lo = 2, hi = 2, mid = 2 <br/>