#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Tree {

    int N;
    vector<vector<int>> adjList;

public:
    Tree(int N)
        {
            this->N = N;
            adjList = vector<vector<int>>(N);
        }

    void addConnection(int s, int e) {
        adjList[s].push_back(e);
    }

    void dfs(int s, int e) {
        cout << s << " ";
        for(auto u:adjList[s]) {
            if(u != e)
                dfs(u, s);
        }
    }

    void dfsNodesBelow(int s, int e, int count[]) {
        count[s] = 1;
        for(auto u:adjList[s]) {
            if(u == e) continue;
            dfsNodesBelow(u, s, count);
            count[s] += count[u];
        }
    }

    void findNodesBelow(int s, int e) {
        int *count = new int[N];
        for (int i = 0; i < N; i++) {
            count[i] = 0;
        }

        dfsNodesBelow(s, e, count);

        for (int i = 0; i < N; i++) {
            cout << "Node " << i << " has " << count[i] << " nodes underneath it and inlcluding itself.\n";
        }
    }
};

int main() {
    Tree tree(4);
    tree.addConnection(0, 1);
    tree.addConnection(0, 2);
    tree.addConnection(2, 3);

    tree.dfs(0, 0);
    cout << "\n";
    tree.findNodesBelow(0, 0);
}