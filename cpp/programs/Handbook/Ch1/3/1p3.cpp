#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Integer range is from -2 * 10^9 ... 2 * 10^9
    // Integers are 32 bits
    int a = 123456789;
    cout << a * a << "\n"; // -175895751

    // You can use long long which are 64 bit integers
    // The range of long long is from -8 * 10^18 ... 9 * 10^18
    long long x = 123456789123456789LL; // LL indicates a long long
    cout << x << "\n";
    // LL indicates that the number is a type of long long

    long long b = a * a;
    cout << b << "\n"; // -175895751
    // THis does not work bceause a is a type int, thus the result must be type int
    long long c = (long long)a * a; // This will cast to long long
    cout << c << "\n";

    // Modular arithmetic
    // x mod m yields the remainder when x is divided by m
    // In a nutshell, modular arithmetic is x - (greatest multiple of m less or equal to x)
    // ex. 17 mod 5 = 2

    // In C++, if the argument is negative, then the result will be negative
    cout << -20 % 6 << "\n"; // -2
    // This should be 4, but C++ says that -20/6 = -3 * 6 + (-2)
    // We can fix this by doing
    int x = -20;
    int m = 6;
    x = x % m; // -2
    x += m; // 4
    cout << x << "\n"; // 4

    // Floating point numbers

    double doub = 0.1231231231; // Doubles are 64 bits long
    long double longDoub = 0.123123123123123123123; // Long doubles are 80 bits long. More precise

    // You can format your output using printf
    doub = 0.3 * 3 + 0.1;  
    printf("%.9f\n", doub); // Print the first 9 decimals
    printf("%20f\n", doub); // As you can see, there are some rounding errors

    // To avoid these round errors, == is risky, use this instead
    double a = 0.1231231231231232;
    double b = 0.1231231231231234;

    // e means power of 10, thus e-9 represents 10^-9
    if(abs(a-b) < 1e-9) {
        // a and b are "equal"
    }
}