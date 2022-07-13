# Bit Representation

Internally in your computer, numbers are stored as a binary number. Integers are binary numbers with `32` bits. For example, the number `43` would be `00000000000000000000000000101011`. For the bit representation of `-43` we would use **Two's complement**. This means that we will be inverting `0 => 1` and `1 => 0`, then increase the number by 1. Thus, the binary representation of `-43` would be, `11111111111111111111111111010101`.

## Unsigned vs Signed

Signed

- Can be positive or negative
- `-2^31-1 - 2^31-1`
- Overflows to `2^31-1`

Unsigned

- Only positive
- `0 - 2^32-1`
- Overflows to `0`
- Larger than signed integer

However, there is a connection between signed and unsigned integers. This connection is that an **signed number `-x`** is _equal_ to the **unsigned number `2^n - x`**
