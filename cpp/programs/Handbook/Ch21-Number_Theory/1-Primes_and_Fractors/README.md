# Primes and Factors

`a` is a **factor** or **divisor** of `b` is `a` divides into `b`. We write `a | b` if `a` is a factor of `b`, and `a ∤ b` if `a` is not a factor of `b`.

If `n > 1` and if the positive factors of `n` are `1` and `n`, then a number is **prime**. Some examples are, `7, 19, & 41`. The **prime factorization** is a number `n` is writing `n` in terms of prime numbers. For example, the prime factorization of `84 = 2^3 * 3 * 7`.

## Number of primes

It has been determined that there are an **inifinite** amount of prime numbers.

## Denisty of primes

The density of primes is how often a prime number occurs in a range of numbers. Let `d(n)` denote the number of primes between `1` and `n`. For example, `d(10) = 4` because `2, 3, 5,& 7` are primes from `1-10`. This number `d(n)`, is approximated to be, `d(n) = n/ln(n)`.

## Conjectures

A conjecture is something that has been accepted to be true, but has not been proved.

- Goldbach's Conjecture: Each number `n > 2` can be expressed as `n = a + b` where `a` and `b` are both prime numbers.
- Twin Prime Conjecture: There are an infinite number of pairs `{p, p + 2}` such that `p` and `p + 2` are prime.
- Legendre's Conjecture: There is always a prime number between `n^2` and `(n + 1)^2`, where `n` is a positive integer.

## Basic Algorithms

```cpp
// Determines if a number is prime
// We just need to try to divide all numbers until sqrt(n), and if any are divisible, then the number is not prime

bool prime(int n) {
    if(n < 2) return false;

    for(int i = 2; i <= sqrt(n); i++) {
        if(n % i == 0) return true;
    }

    return false;
}
```

```cpp
// We are finding all positive factors of number n
// We will divide n by all possible prime factors, then add them to a vector if the remainder is 0

vector<int> factors(int n) {
    vector<int> f;

    for(int i = 2; i <= sqrt(n); i++) {
        while(n % i == 0) {
            f.push_back(i);
            n /= i;
        }
    }

    if(n > 1) f.push_back(n);
    return f;
}

```

## Sieve of Eratosthenes

The Sieve of Eratosthenes is a preprocessing algorithm that will build an array to efficiently check whether a given number `2 ... n` is prime or not. We will go through the array starting from index `2`, and if `sieve[i] = 0`, then `i` is prime, and we mark `2i, 3i, 4i, ..., ni` with `i` since `i` divides `n`.

```cpp
void eratosthenes(int sieve[], int n) {
    for (int x = 2; x < n; x++) {
        if(sieve[x])
            continue;
        for (int i = x * 2; i < n; i += x)
            sieve[i] = x;
    }

    for (int i = 0; i < n; i++) 
        cout << sieve[i] << " ";
    
    cout << "\n";
}
```

## Euclid's algorithm
The `gcd` or **greatest common divisor** of two numbers is the largest number that divides both numbers `ex) gcd(36, 48) = 12`. The `lcm` or **least common multiple** of two numbers is the smallest number that both numbers divide `ex) lcm(24, 46) = 72`. It has been proven that the `lcm` and `gcd` are connected by the following, `lcm(a, b) = ab/gcd(a, b)`.

**Euclid's algorithm** is an efficient method of determining the `gcd` of two numbers. Using recursion, we have determined that `gcd(a, b) = {0 if b == 0, gcd(b, a mod b) if b ≠ 0}`. For example, `gcd(12, 24) = gcd(24, 12) = gcd(12, 0) = 12`.

```cpp
// Time complexity: O(logn)

int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a % b);
}
```