#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int countOne(int x) {
    int count = 0;
    for (int i = 0; i < 32; i++)
    {
        if(x & (1 << i))
            count++;
    }
    return count;
}

int main() {
    int x = 0; // All 0's
    x |= (1 << 1); // To the first position
    x |= (1 << 3);
    x |= (1 <<4);
    x |= (1 << 8);
    for (int i = 0; i < 32; i++) {
        if(x&(1<<i)) // Curr position is 1
            cout << i << "\n";
    }

    // Set Operations
    cout << "Set operations \n";
    x = (1 << 1) | (1 << 3) | (1 << 4) | (1 << 8);
    int y = (1 << 3) | (1 << 6) | (1 << 8) | (1 << 9);
    int z = x | y;

    // From the output, you can tell that the union of x and y have succeeded
    for (int i = 0; i < 32; i ++) {
        if(z & (1 << i))
            cout << i << "\n";
    }

    // Iterating through subsets
    cout << "Iterating through all subsets \n";
    int n = 4;
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
    cout << "\nIterating through all subsets of size k\n";
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

    cout << "\nIterating through all subsets of x\n";
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
}