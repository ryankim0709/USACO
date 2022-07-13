# Bit Operations

In this section, we will be reviewing various imiportant bit operations that are performed on binary numbers.

## Or
`1` if *one of the two* is `1`
`0` if *both* are `0`

## And
`1` if **both** are `1`
`0` if *one or both* are `0`

## XOR
`1` if the two values are **different**
`0` if the two values are **the same**

## -X
To find `-X`, we will apply **Two's complement**. First, we will invert all `0 => 1` and `1 => 0`. Then, we will increase the resulting binary by 1. 
**Note: -x = ~x + 1**

## Not (~X)
Produces a number where the bits of `x` are inverted. `0 => 1` and `1 => 0`.
**Note: ~x = -x - 1**

## The connection between -X and ~X
`-X` simply resembles Two's Complement
`~X` is simply inverting the binary representation

`-X = ~X + 1`
`~X = -X - 1`

## Bit shifts (<< & >>)
`a << k` will add `k` zeros to the end of the bit representation of `a` and `a >> k` will remove the last `k` bits of `a`. `x << k` is the same as *multiplying* `a` by `2^k` and `x >> k` is the same as *dividing* `a` by `2^k`.

## Applications

1. Setting the `kth` bit to `1`
* `x | (1 << k)` => Indexing of binary representation with position 0

2. Setting the `kth` bit to `0`
* `x & ~(1 << k)`

3. Inverting the `kth` bit
* `x ^ (1 << k)`

4. Setting the last bit to `0`
* `x & (x-1)`

5. Setting all `1` bits to `0` *except the last one*
* `x & -x`

6. Set all `1` bits to `0` except the last `1` bit
* `x & -x`

7. Invert all bits after the last `1` bit
* `x | (x-1)`

8. Check if `x` is a power of `2`
`x & (x-1) = 0`