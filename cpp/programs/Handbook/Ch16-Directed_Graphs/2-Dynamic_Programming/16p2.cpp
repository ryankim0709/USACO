#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    vector<vector<int>> adjList;
    vector<int> topological_ref;
    vector<int> topological_array;
    bool cycle = false;

    vector<int> numPaths;
    vector<vector<int>> from;

public:
    Graph(int N) {
        this->N = N;
        adjList = vector<vector<int>>(N);
        topological_ref = vector<int> (N);
        numPaths = vector<int>(N);

        from = vector<vector<int>>(N);

        for (int i = 0; i < N; i++)
        {
            topological_ref[i] = 0;
        }
    }
    void addEdge(int a, int b) {
        adjList[a].push_back(b);
        from[b].push_back(a);
    }

    void topological_dfs(int curr) {
        if(cycle || topological_ref[curr] == 2)
            return;
        if (topological_ref[curr] == 1)
        {
            cycle = true;
            cout << "There is a cycle in the graph and we can't find the topological ordering of this tree!\n";
        }

        topological_ref[curr] = 1;
        for (int i : adjList[curr])
        {
            topological_dfs(i);
        }
        topological_ref[curr] = 2;
        topological_array.push_back(curr);
    }

    void topological_sort() {
        for (int i = 0; i < N; i++) {
            if(topological_ref[i] == 2) continue;
            topological_dfs(i);
        }

        // Remember the topological sort is what we just found reversed. 
        reverse(topological_array.begin(), topological_array.end()); // Reverse the topological_array vector
    }

    void express_topological_sort() {
        for(int i:topological_array) {
            cout << i << " ";
        }
        cout << "\n";
    }

    void findTotalPaths() {
        // Find the number of paths from the first node in the topological sort to every other node
        numPaths[topological_array[0]] = 1;
        for (int i = 1; i < N; i++) {
            numPaths[topological_array[i]] = 0;
            for (int j : from[topological_array[i]]) // All of the nodes that are pointing to a certain node
            {
                numPaths[topological_array[i]] += numPaths[j]; // # of paths = sum(# of paths to nodes pointing to that node)
            }
        }

        for (int i = 0; i < N; i++)
        {
            cout << "From " << topological_array[0] << ", there are " << numPaths[i] << " paths to " << i  << "\n";
        }
    }
};

int main() {
    Graph topological(6);

    topological.addEdge(0, 1);
    topological.addEdge(0, 3);
    topological.addEdge(1, 2);
    topological.addEdge(2, 5);
    topological.addEdge(3, 4);
    topological.addEdge(4, 1);
    topological.addEdge(4, 2);

    topological.topological_sort();
    topological.express_topological_sort();

    topological.findTotalPaths();
}