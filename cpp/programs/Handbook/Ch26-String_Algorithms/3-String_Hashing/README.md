# String Hashing

**String Hashing** is used to generate a certain value for a given string. Using string hashing, we can quickly check whether two strings are equal.

## Calculating Hash Values

The **hash value** is the actual value that is generated from string hasing. To find this hash value, we will use two predefined constants, `A` and `B` along as the **ascii** values of each letter. The usual way to implement string hasing is using **polynomial hasing** which uses the following formula.

`(s[0]A^n-1 + s[1]A^n-2 + ... + s[n-1]A^0) mod B`.

For `s[0]`, `s[1]`, `...`, `s[n-1]` we will be using their ascii values. In ascii, `A = 65, B = 66, ..., Z = 90` and `a = 97, b = 98, c = 99, ..., z = 122`.

## Preprocessing
We can apply polynomial hashing in order to find the hash value of any substring in `O(1)` after an `O(n)` preprocessing. Using a simple recursive function, we can calculate gnerate the following array `h`.

`h[0] = s[0]`

`h[k] = (h[k - 1]A + s[k]) mod B`

Additionally, we can can construct another array `p` such that `p[k] = A^k mod B`

`p[0] = 1`

`p[k] = (p[k - 1]A) mod B`.

After this preprocessing, we can find the hash value of any substring `s[a ... b]` can be calculated inn `O(1)` time using,

`(h[b] - h[a - 1]p[b - a +1]) mod B`

if `a > 0`. If `a = 0`, then the hash value is simply `h[b]`.