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
        link = vector<int>(N);
        size = vector<int>(N);

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
            swap(a, b);
        }
        size[a] += size[b]; // A is larger
        link[b] = a;
    }

    void expressTree() {
        for (int i = 0; i < N; i++)
        {
            cout << "Next element in the chain for " << i << " is " << link[i] << "\n";
            
        }
    }
};

class Kruskal {
    int N;
    set<tuple<int, int, int>> edgeList;

public: 
    Kruskal(int N) {
        this->N = N;
    }

    void addEdge(int a, int b, int w) {
        edgeList.insert({w, a, b});
    }

    void Kruskals_Algo() {
        Union_Find minTree(N);
        for (auto e : edgeList)
        {
            int w, a, b;
            tie(w, a, b) = e;

            if(minTree.same(a, b) == 0) {
                minTree.unite(a, b);
            }
        }

        minTree.expressTree();
    }
};

int main() {
    Kruskal min_tree(6);
    min_tree.addEdge(0, 1, 3);
    min_tree.addEdge(0, 4, 5);
    min_tree.addEdge(1, 0, 3);
    min_tree.addEdge(1, 4, 6);
    min_tree.addEdge(1, 2, 5);
    min_tree.addEdge(2, 1, 5);
    min_tree.addEdge(2, 5, 3);
    min_tree.addEdge(2, 3, 9);
    min_tree.addEdge(3, 2, 9);
    min_tree.addEdge(3, 5, 7);
    min_tree.addEdge(4, 0, 5);
    min_tree.addEdge(4, 1, 6);
    min_tree.addEdge(4, 5, 2);
    min_tree.addEdge(5, 4, 2);
    min_tree.addEdge(5, 2, 3);
    min_tree.addEdge(5, 3, 7);

    min_tree.Kruskals_Algo();
}