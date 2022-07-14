# Representing Sets

Bits are a very efficient way to store subsets. We can store a subset of `{0, 1, 2, 3, ..., n-1}` with an `n` bit integer. Using an integer is not only space efficient because it only requires `1` bit per element and set operations can be implemented as bit operations. For example, an `int` can represent any subset of `{0, 1, 2, 3, 4, 5}`. The bit representation of the set `{1, 3, 4, 5}` would be `111010 = 32 + 16 + 8 + 2 = 58`.

## Set Implementation

The following code will create a subset of `{0, 1, 2, 3, n-1}` using an integer. We will then add `1`, `3`, `4`, and `8` to the set.

```cpp
int x = 0;
x |= (1 << 1);
x |= (1 << 3);
x |= (1 <<4);
x |= (1 << 8);
cout << __bultin_popcount(x) << "\n"; // 4

for(int i = 0; i < 32; i++) {
    if(x & (1 << i)) cout << i <<"\n";
}
```

## Set Operations
|              | Set Syntax | Bit Syntax |
| :----------- | :--------: | ---------: |
| Intersection |  `a ∩ b`   |    `a & b` |
| Union        |  `a ∪ b`   |   `a OR b` |
| Complement   |    `ā`     |       `~a` |
| Difference   |  `a \ b`   | `a & (~b)` |

## Iterating through subsets

```cpp
int n = 4;

// Generates all subsets in the set {0, 1, 2, 3, n-1}
for (int b = 0; b < (1 << n); b++)
{
    cout << "\n";
    for (int i = 0; i < n; i++)
    {
        if(b & (1<<i))
            cout << 1 << " ";
        else
            cout << 0 << " ";
    }
}

// Generates all subsets of size 2
int k = 2;
for (int b = 0; b < (1 << n); b++)
{
    if(countOne(b) == k) {
        cout << "\n";
        for (int i = 0; i < n; i++)
        {
            if(b & (1<<i))
                cout << 1 << " ";
            else
                cout << 0 << " ";
        }
    }
 }

 // Generating all subsets of x
 x = 5; // 101
int b = 0;
do {    
    for (int i = 0; i < 3; i++)
    {
        if(b & (1<<i))
            cout << 1 << " ";
        else
            cout << 0 << " ";
    }
    cout << "\n";
} while ((b=((b - x)&x)));
```