# Modular Arithmetic
Modular arithmetic is also known as **mod** or `%`. `a mod b` is defined as the remainder when `a` is divided by `b`. For example, `75 mod 17 = 75 % 17 = 5`. Due to the definition of mod, `x mod m` yields a number in the set, `[0, 1, 2, ..., m - 1]`. There are certain formulas that can make calculating modular arithmetic easier
- `(x + y) mod m = (x mod m + y mod m) mod m`
- `(x - y) mod m = (x mod m - y mod m) mod m`
- `(x * y) mod m = (x mod m * y mod m) mod m`
- `x^n mod m = (x mod m)^n mod m`

## Modular exponentiation
In modular exponentiation, we may need to find `x^n mod m`. We can use the following formula, `x^n % m = {1 if n = 0, (x^n/2 % m * x^n/s % m) % m if m%2 = 0, (x^(n-1) % m * x % m) % m if m%2 = 1}`

```cpp
int modpow(int x, int n, int m) {
    // x^n % m

    if(n == 0) return 1;
    long long u = modpow(x, n/2, m);
    u = (u * u) % m;

    if(n % 2 == 1) u = (u * x) % m;
    return u;
}
```

## Fermat's and Euler's theorem
Fermat's theorem states that `x^(m-1) % m = 1` when `m` is prime and `x` and `m` are **coprime** (meaning both numbers are prime). This can then be extended to `x^k % m = x^(k % (m-1)) % m`. More generally, **Euler's Theorem** states that `x^p(m) % m = 1` where `p(m)` is **Eulers Totient function** which will return the number of numbers relatively prime to `m` which means that `gcd(m, x) = 1`.

## Modular inverse
The inverse of `x % m` called `x^-1` is defined such that `(x * x^-1) % m = 1`.