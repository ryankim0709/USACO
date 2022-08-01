#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    vector<vector<int>> adjList;
    vector<vector<int>> reversedAdjList;
    vector<bool> visited;
    int currTime = 0;
    set<pair<int, int>> dfsList;

    vector<unordered_set<int>> scc;
    unordered_set<int> currScc;

public:
    Graph(int N) {
        this->N = N;
        adjList = vector<vector<int>>(N);
        reversedAdjList = vector<vector<int>>(N);
        visited = vector<bool>(N);

        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }
    }

    void addEdge(int a, int b) {
        adjList[a].push_back(b);
        reversedAdjList[b].push_back(a);
    }

    void dfs1Prep() {
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                currTime++;
                dfs1(i);
            }
        }
    }

    void dfs1(int curr) {
        visited[curr] = true;
        for (int i : adjList[curr])
        {
            if(!visited[i]) {
                currTime++;
                dfs1(i);
            }
        }
        currTime++;
        dfsList.insert({-currTime, curr});
    }

    void expressSet() {
        for(auto u:dfsList) {
            cout << "Node " << u.second << " finished at time " << u.first << "\n";
        }
    }

    void dfs2(int start, int curr)
    {
        for(int i:reversedAdjList[curr]) {
            if (currScc.count(i))
            { // If it contains that number
                if(i == start) {
                    scc.push_back(currScc);
                    return;
                }
                else
                {
                    currScc.clear();
                    currScc.insert(start);
                    scc.push_back(currScc);
                    return;
                }
            }
            else
            { // Does not contain
            if(visited[i])
                continue;
            currScc.insert(i);
            visited[i] = true;
            dfs2(start, i);
            }
        }
    }
    void dfs2prep() {
        for (int i = 0; i < N; i++)
            visited[i] = false;
        for (auto u : dfsList)
        {
            int node = u.second;
            if(!visited[node]) {
                currScc.clear();
                currScc.insert(node);
                visited[node] = true;
                dfs2(node, node);
            }
        }
    }

    void expressAllScc() {
        for(auto u:scc) {
            for(int i:u) {
                cout << i << " ";
            }
            cout << "\n";
        }
    }
};

int main() {
    Graph scc(7);

    scc.addEdge(0, 1);
    scc.addEdge(0, 3);
    scc.addEdge(1, 0);
    scc.addEdge(1, 4);
    scc.addEdge(2, 1);
    scc.addEdge(2, 6);
    scc.addEdge(4, 3);
    scc.addEdge(5, 2);
    scc.addEdge(5, 4);
    scc.addEdge(6, 5);

    scc.dfs1Prep();
    scc.expressSet();

    scc.dfs2prep();
    scc.expressAllScc();
}