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

    void expressTree() {
        for (int i = 0; i < N; i++)
        {
            cout << "Next element in the chain for " << i << " is " << link[i] << "\n";
            
        }
    }
};

class Prims {
    int N;
    vector<vector<pair<int, int>>> edgeList;

public:
    Prims(int N) {
        this->N = N;
        edgeList = vector<vector<pair<int, int>>>(N);
    }

    void addEdge(int a, int b, int w) {
        edgeList[a].push_back({b, w});
    }

    void prims() {
        Union_Find min_tree(6);
        priority_queue<tuple<int, int, int>> edges; // {w, a, b}

        for(auto e:edgeList[0]) {
            int a = 0;
            int b, w;
            tie(b, w) = e;
            edges.push({-w, a, b});
        }

        while(!edges.empty()) {
            auto e = edges.top();
            edges.pop();
            int a, b, w;
            tie(w, a, b) = e;
            int bperm = b;
            // cout << w << " " << a << " " << b << " " << "\n";
            if(min_tree.same(a, b) == 0) {
                min_tree.unite(a, b);

                cout << a << " " << b << "\n";
                min_tree.expressTree();
                cout << "\n";

                for(auto u:edgeList[b]) {
                    a = bperm;
                    tie(b, w) = u;
                    edges.push({-w, a, b});
                }
            }
        }

        min_tree.expressTree();
    }

    void showGraph() {
        for (int i = 0; i < N; i++) {
            cout << "From " << i << " ";
            for(auto u:edgeList[i]) {
                cout << "(" << u.first << " " << u.second << ") ";
            }
            cout << "\n";
        }
    }
};

int main() {
    Prims min_tree(6);

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

    min_tree.prims();
    //min_tree.showGraph();
}