#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int a = 22; // 10110
    int b = 26; // 11010

    // Remember, these are BINARY operations, thus a and b are first converted into binary

    // OR
    // 1 if one or both are 1
    // 0 if both are 9
    cout << (a | b) << "\n";
    // 11110 => 30

    // AND
    // 1 if both are 1
    // 0 if one or both are 0
    cout << (a & b) << "\n";
    // 10010 => 18

    // XOR
    // 1 if a and b are different
    // 0 if a and b are the same
    cout << (a ^ b) << "\n";
    // 01100 => 12

    // NOT
    // For every bit in the binary representation, 1 => 0 and 0 => 1. Also remember that ~x = -x - 1
    cout << (~a) << " " << (~b) << "\n";
    // Keep note that the sign bit also switches
    // 01001 => -23 and 00101 => -26

    // Bit shifts
    // Not circular
    // "Overflow" becomes 0
    cout << (a << 2) << "\n";
    // 10110 => 11000
    cout << (b >> 2) << "\n";
    // 11010 => 00110

    // Getting the binary representation of x
    int x = 31;
    for (int i = 31; i >= 0; i--)
    {
        if(x&(1<<i))
            // If there is a one at a certain position. Since and (&) if they are the same. If (x & (1 << i)) > 0, there must be an overlap
            cout << "1";
        else
            cout << "0";
    }
    
}