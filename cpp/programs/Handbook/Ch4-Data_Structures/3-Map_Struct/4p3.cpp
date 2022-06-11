#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // map is like HashMap
    // unordered_map is like TreeMap

    map<string, int> m;
    m["monkey"] = 4;
    m["banana"] = 3;
    m["harpsichord"] = 9;
    cout << m["banana"] << "\n"; // 3

    cout << m["aybabtu"] << "\n"; // 0
    // Initializes to basic which is 0
    
    if(m.count("aybabtu")) {
        // The key "aybabtu" exists in map m
    }
    for(auto x:m) 
        cout << x.first << " " << x.second << "\n"; // Prints all of the key-value pairs in a map
    
}