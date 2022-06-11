#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool comp(string a, string b) {
    // User defined function to sort via size
    if (a.size() != b.size())
        return a.size() < b.size();
    return a < b; // Done by ascii value
}

struct Name {
    string first, last;

    // My own sorting by name length
    bool operator<(const Name &name) const { 
        // First name size
        if (first.size() != name.first.size()) 
            return first.size() < name.first.size();
        // First name ascii
        if (first != name.first)
            return first < name.first;
        // If the first name is the same ...

        // Last name size
        if (last.size() != name.last.size()) 
            return last.size() < name.last.size();
        // Last name ascii
        if (last != name.last)
            return last < name.last;
        
        //If first and last name are the same, it doesn't matter
        return true;
    }
};

int main()
{
    // Sorting vectors
    vector<int> v = {4, 2, 5, 3, 5, 8, 3};
    sort(v.begin(), v.end()); // Sorting in increasing order
    for(int i:v)
        cout << i << " "; // 2 3 3 4 5 5 8
    cout << "\n";
    sort(v.rbegin(), v.rend()); // Sorting in decreasing order
    for(int i:v)
        cout << i << " "; // 8 5 5 4 3 3 2
    cout << "\n";

    // Sorting normal arrays
    int a[] = {4, 2, 5, 3, 5, 8, 3};
    int n = sizeof(a) / sizeof(a[0]); // Size of array
    n = 7; // Size of array
    sort(a, a + n);
    for(int i:a)
        cout << i << " "; // 2 3 3 4 5 5 8
    cout << "\n";

    // String sorting
    string s = "monkey";
    sort(s.begin(), s.end());
    cout << s << "\n"; // ekmnoy => based on ASCII values

    // Comparison operators
    vector<pair<int, int>> pairs;
    pairs.push_back({1, 5});
    pairs.push_back({2, 3});
    pairs.push_back({1, 2});
    sort(pairs.begin(), pairs.end()); // Sort via first number, then second
    for(auto i:pairs)
        cout << "(" << i.first << "," << i.second << ") "; // (1, 2), (1,5), (2, 3)
    cout << "\n";

    vector<tuple<int, int, int>> tuples;
    tuples.push_back({2, 1, 4});
    tuples.push_back({1, 5, 3});
    tuples.push_back({2, 1, 3});
    sort(tuples.begin(), tuples.end());
    for(auto i:tuples)
        cout << "(" << get<0>(i) << "," << get<1>(i) << "," << get<2>(i) << ") "; // (1, 5, 3), (2, 1, 3), (2, 1, 4)
    cout << "\n";

    vector<string> strings;
    strings.push_back("Ryan");
    strings.push_back("Kim");
    strings.push_back("2022");
    strings.push_back("Him");
    // Using custom comparator
    sort(strings.begin(), strings.end(), comp);

    for(string i:strings)
        cout << i << " ";
    cout << "\n";
    
    // User defined structures
    vector<Name> ducklings;
    Name ryan = {"Ryan", "Kim"};
    Name august = {"August", "Mondragon"};
    Name romy = {"Romy", "Kiessling"};
    Name kinga = {"Kinga", "Czajkowska"};

    ducklings.push_back(ryan);
    ducklings.push_back(kinga);
    ducklings.push_back(romy);
    ducklings.push_back(august);
    sort(ducklings.begin(), ducklings.end()); // Soring my struct with my method

    for(Name i:ducklings)
        cout << "(" << i.first << ", " << i.last << ") ";
    cout << "\n";
}