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
            cout << tree[i] << " ";
        }
        cout << "\n";
    }
};

class Graph {
    int N;
    vector<vector<int>> adjList;
    vector<bool> visited;
    vector<int> nodeLst;
    vector<int> subSize;
    vector<int> nodeValsVect;
    BinIndTree nodeVals = BinIndTree(1);

public:
    Graph(int N)
    {
        this->N = N;
        adjList = vector<vector<int>>(N);
        subSize = vector<int>(N);
        visited = vector<bool>(N);
        nodeVals = BinIndTree(9);

        for (int i = 0; i < N; i++) {
            subSize[i] = 1;
            visited[i] = false;
        }
    }

    void addEdge(int a, int b) {
        adjList[a].push_back(b);
    }

    void getDataDFS(int curr) {
        visited[curr] = true;
        nodeLst.push_back(curr);

        for(int i :adjList[curr]) {
            if(!visited[i]) {
                getDataDFS(i);
                subSize[curr] += subSize[i];
            }
        }
    }

    void getNodeVals() {
        nodeVals.construct(nodeValsVect);
        nodeVals.expressBinIndTree();
    }

    void generateVals(int vals[]) {
        for(int i:nodeLst) {
            nodeValsVect.push_back(vals[i]);
        }
    }

    void showData() {
        for(int i:nodeValsVect) {
            cout << i << " ";
        }
        cout << "\n";
    }

    void getSubtreeSum() {
        cout << nodeVals.getSum(7) - nodeVals.getSum(3);
    }
};

int main()
{
    Graph subQuerry(9);

    subQuerry.addEdge(0, 1);
    subQuerry.addEdge(0, 2);
    subQuerry.addEdge(0, 3);
    subQuerry.addEdge(0, 4);
    subQuerry.addEdge(1, 5);
    subQuerry.addEdge(3, 6);
    subQuerry.addEdge(3, 7);
    subQuerry.addEdge(3, 8);

    subQuerry.getDataDFS(0);
    int nodeVals[] = {2, 3, 5, 3, 1, 4, 4, 3, 1};
    subQuerry.generateVals(nodeVals);
    subQuerry.getNodeVals();

    subQuerry.getSubtreeSum();
}