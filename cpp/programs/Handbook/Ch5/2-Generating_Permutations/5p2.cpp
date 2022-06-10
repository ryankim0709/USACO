#include <iostream>
#include <bits/stdc++.h>
using namespace std;


int chosen[3];
vector<int> permutation;
void permute(vector<int> arr, int n) {
    // Use recursion to generate permutations
    // [1] > [1, 2] > [1, 2, 3] > [1, 2] > [1] > [1, 3] > [1, 3, 2]
    if(permutation.size() == n) {
        for(int i:permutation)
            cout << i << " ";
        cout << "\n";
    }
    else
    {
        for (int i = 0; i < n; i++) {
            if(chosen[i])
                continue;
            chosen[i] = true;
            permutation.push_back(arr[i]);
            permute(arr, n);
            chosen[i] = false;
            permutation.pop_back();
        }
    }
}

int main() {
    // Permutation with recursion
    cout << "Permutations with recursion\n";
    vector<int> arr = {1, 2, 3};
    vector<int> permutation;
    int n = 3;
    permute(arr, n);

    // Permutations with C++ standard library
    cout << "\nPermutations with the C++ Standard Library\n";
    permutation.clear();
    for (int i = 0; i < n; i++)
        permutation.push_back(i);
    do {
        for(int i: permutation) {
            cout << i << " ";
        }
        cout << "\n";
    } while (next_permutation(permutation.begin(), permutation.end()));
}