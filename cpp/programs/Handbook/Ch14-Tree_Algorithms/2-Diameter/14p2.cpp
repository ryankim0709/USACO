#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Tree {
    int N;
    vector<vector<int>> adjList;
    int *toLeaf;
    int currLongest = 0;
    int furthestNodeID = 0;

public:
    Tree(int N) {
        this->N = N;
        adjList = vector<vector<int>>(N);
        toLeaf = new int[N];
        for (int i = 0; i < N;i++) {
            toLeaf[i] = 0;
        }
    }

    void addEdge(int s, int e) {
        adjList[s].push_back(e);
    }

    void diameter(int s, int e) {
        for(int u:adjList[s]) {
            if(u != e) {
                diameter(u, s);
                toLeaf[s] = max(toLeaf[s], toLeaf[u] + 1);
            }
        }
    }

    void getLeafDistance() {
        for (int i = 0; i < N; i++) {
            cout << "From node " << i << " to the farthest leaf node, the distance is " << toLeaf[i] << "\n";
        }
    }

    void getDiameter(int root) {
        int diameter = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(i == j)
                    continue;
                diameter = max(diameter, toLeaf[i] + toLeaf[j]);
            }
        }

        cout << "The total diameter of this tree is " << diameter + 2 << "\n";
    }

    void dfsFurthest(int s, int e, int currLength) {
        currLength++;
        if(currLength > currLongest) {
            currLongest = currLength;
            furthestNodeID = s;
        }

        for(int i:adjList[s]) {
            if(i != e)
                dfsFurthest(i, s, currLength);
        }
    }
    int getFurthest(int start) {
        currLongest = 0;
        furthestNodeID = 0;
        dfsFurthest(start, -1, 0);
        return furthestNodeID;
    }

    int getCurrLongestDistance() {
        return currLongest - 1;
    }
};

int main() {
    Tree diameter(7);

    diameter.addEdge(0, 1);
    diameter.addEdge(0, 2);
    diameter.addEdge(0, 3);
    diameter.addEdge(1, 0);
    diameter.addEdge(1, 4);
    diameter.addEdge(1, 5);
    diameter.addEdge(2, 0);
    diameter.addEdge(3, 0);
    diameter.addEdge(3, 6);
    diameter.addEdge(4, 1);
    diameter.addEdge(5, 1);
    diameter.addEdge(6, 3);

    diameter.diameter(0, 0);
    diameter.getLeafDistance();
    diameter.getDiameter(0);

    Tree diamTwoDFS(7);

    diamTwoDFS.addEdge(0, 2);
    diamTwoDFS.addEdge(0, 1);
    diamTwoDFS.addEdge(0, 3);
    diamTwoDFS.addEdge(1, 0);
    diamTwoDFS.addEdge(1, 4);
    diamTwoDFS.addEdge(1, 5);
    diamTwoDFS.addEdge(2, 0);
    diamTwoDFS.addEdge(3, 0);
    diamTwoDFS.addEdge(3, 6);
    diamTwoDFS.addEdge(4, 1);
    diamTwoDFS.addEdge(5, 1);
    diamTwoDFS.addEdge(6, 3);

    int furthest = diamTwoDFS.getFurthest(2); // This start can be any node
    diamTwoDFS.getFurthest(furthest);
    int diamTwoDFSDiameter = diamTwoDFS.getCurrLongestDistance();
    cout << "Tree diameter is " << diamTwoDFSDiameter << "\n";
}