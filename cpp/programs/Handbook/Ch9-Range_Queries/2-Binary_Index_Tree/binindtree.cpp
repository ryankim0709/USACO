#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class BinIndTree {
    int N;
    vector<int> tree;
public:
    BinIndTree(int N) {
        this->N = N;
        tree = vector<int>(N + 1);
    }

    int getSum(int index) {
        int sum = 0;
        index = index + 1;

        while(index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }

        return sum;
    }

    void update(int index, int val) {
        index = index + 1;
        while(index <= N) {
            tree[index] += val;
            index += index & (-index);
        }
    }

    void construct(vector<int> arr) {
        for (int i = 0; i <= N; i++) {
            tree[i] = 0;
        }

        for (int i = 0; i <= N; i++) {
            update(i, arr[i]);
        }
    }

    void expressBinIndTree() {
        for (int i = 1; i <= N; i++) {
            cout << tree[i] << "\n";
        }
    }
};

int main() {
    BinIndTree test(9);
    vector<int> arr = {2,3,4,5,3,4,3,1,1};
    test.construct(arr);
    test.expressBinIndTree();
}