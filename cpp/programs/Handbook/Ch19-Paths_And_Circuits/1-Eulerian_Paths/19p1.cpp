#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;

    vector<vector<int>> adjlist;

public:
    Graph(int N) {
        this->N = N;
        adjlist = vector<vector<int>>(N);
    }

    void addEdge(int a, int b) {
        adjlist[a].push_back(b);
        adjlist[b].push_back(a);
    }

    void hierholzers() {
        unordered_map<int, int> edge_count;

        for (int i = 0; i < N; i++) {
            edge_count[i] = adjlist[i].size();
        }

        if(!adjlist.size())
            return;

        stack<int> curr_path;
        curr_path.push(0);
        int curr_v = 0;

        vector<int> circuit;

        while(!curr_path.empty()) {
            if(edge_count[curr_v]) {
                curr_path.push(curr_v);
                int next_v = adjlist[curr_v].back();
                edge_count[curr_v]--;
                adjlist[curr_v].pop_back();

                curr_v = next_v;
            } else {
                circuit.push_back(curr_v);
                curr_v = curr_path.top();
                curr_path.pop();
            }
        }

        for (int i = circuit.size(); i > 1; i--) {
            cout << circuit[i];
            if(i)
                cout << " -> ";
        }
    }
};

int main() {
    Graph hier(7);

    hier.addEdge(0, 1);
    hier.addEdge(0, 2);
    hier.addEdge(1, 2);
    hier.addEdge(1, 5);
    hier.addEdge(1, 4);
    hier.addEdge(2, 3);
    hier.addEdge(2, 5);
    hier.addEdge(3, 6);
    hier.addEdge(4, 5);
    hier.addEdge(5, 6);

    hier.hierholzers();
}