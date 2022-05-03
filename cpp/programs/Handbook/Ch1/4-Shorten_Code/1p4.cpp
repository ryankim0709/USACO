#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Typedef
typedef long long ll; // Setting long long to ll
typedef vector<int> vi; // Setting integer vectors to vi
typedef pair<int, int> pi; // Setting integer pair to pi

// Macros
#define PB push_back
#define MP make_pair

// Complex Macros
#define FOR(i, a, b) for (int i = a; i <= b; i ++)
#define SQ(a) (a)*(a)

int main() {
    // Type Def
    long long a = 123456789;
    ll b = 123456789;
    cout << a << " " << b << "\n";
    // These are the same thing because I defined long long as "ll"

    // More complex typedef & simple Macros
    vi vectInt;
    vectInt.PB(1); // Vector push to the back
    pi intPair;
    intPair = MP(10, 20); // Make a pair (10, 20)

    // Complex Macros
    FOR(i, 1, 5) {
        cout << i << "\n"; // 1, 2, 3, 4, 5
    }

    cout << SQ(3 + 3) << "\n"; // 36
}