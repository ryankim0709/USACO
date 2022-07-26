#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Union_Find {
    int N;
    vector<int> link; // Array that contains the element directly above itself
    vector<int> size; // Size of the component of its representative

public:
    Union_Find(int N) {
        this->N = N;
        link = vector<int> (N);
        size = vector<int> (N);

        for (int i = 0; i < N; i++) {
            link[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        while(x !=  link[x])
            x = link[x];
        return x;
    }

    bool same(int a, int b) {
        return find(a) == find(b);
    }

    void unite(int a, int b) {
        a = find(a);
        b = find(b);
        // Always link smaller set to larger set
        if(size[a] < size[b]) {
            // Swap a and b
            int temp = a;
            a = b;
            b = temp;
        }
        size[a] += size[b]; // A is larger
        link[b] = a;
    }
};

int main() {
    Union_Find practice(7);
    practice.unite(0, 1);
    cout << practice.same(0, 1) << "\n";
    cout << practice.find(0) << "\n";
}