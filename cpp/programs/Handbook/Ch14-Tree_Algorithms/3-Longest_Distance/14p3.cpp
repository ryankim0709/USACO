#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Tree
{
    int N;
    vector<vector<int>> adjList;

public:
    Tree(int N)
    {
        this->N = N;
        adjList = vector<vector<int>>(N);
    }

    void addNeighbor(int s, int e)
    {
        adjList[s].push_back(e);
    }

    void findLongestDFS(int s, int e, int longestPath[], int longestPathDirection[]) {
        for(auto u:adjList[s]) {
            if(u == e)
                continue;
            findLongestDFS(u, s, longestPath, longestPathDirection);
            if (longestPath[u] + 1 > longestPath[s]) {
                longestPath[s] = longestPath[u] + 1;
                longestPathDirection[s] = u;
            }
        }
    }
    void findLongestPaths() {
        int *longestPath = new int[N];
        int *longestPathDirection = new int[N];

        for (int i = 0; i < N; i++) {
            longestPath[i] = 0;
            longestPathDirection[i] = 0;
        }

        findLongestDFS(0, -1, longestPath, longestPathDirection);

        for (int i = 0; i < N; i++) {
            cout << "Longest path from node " << i << " is " << longestPath[i] << " and its direction is node " << longestPathDirection[i] << "\n";
        }
    }
};

int main()
{
    Tree longest(6);

    longest.addNeighbor(0, 1);
    longest.addNeighbor(0, 2);
    longest.addNeighbor(0, 3);
    longest.addNeighbor(1, 0);
    longest.addNeighbor(1, 4);
    longest.addNeighbor(1, 5);
    longest.addNeighbor(2, 0);
    longest.addNeighbor(3, 0);

    longest.findLongestPaths();
}