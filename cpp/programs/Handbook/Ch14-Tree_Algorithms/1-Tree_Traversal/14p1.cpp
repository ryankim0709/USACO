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
};

int main() {
    Tree tree(4);
    tree.addConnection(0, 1);
    tree.addConnection(0, 2);
    tree.addConnection(2, 3);

    tree.dfs(0, 0);
}