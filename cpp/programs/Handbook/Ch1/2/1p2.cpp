#include <iostream>
#include<bits/stdc++.h>

using namespace std;

int main() {
    // Makes scanning faster?
    ios::sync_with_stdio(0);
    cin.tie(0);
    // --------------------

    // ------- Using cin and cout -----------------
    int a, b;
    string x;
    cin >> a >> b >> x; // Get a, b, and x from the standard stream
    // Needs a least one space or newline between each element in the input
    // 123 321 Hello & 123      321      Hello would both work
    cout << a << " " << b << " " << x << "\n";

    // -------- Using scanf and pringf ------------------
    // These functions are closer to C and a bit faster, but harder to use
    
    // Scanning two integers
    scanf("%d %d", &a, &b);
    // Printing two integers
    printf("%d %d", a, b);

    // Scanning a whole line of input
    string s;
    getline(cin, s);
    printf("%s", s.c_str());

    // If the amount of data is unkown, loops are your best friend
    while (cin >> x) {
        cout << x << "\n";
    }

    // File input and output
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    // Now you can read input from the files as if standard input & output
}