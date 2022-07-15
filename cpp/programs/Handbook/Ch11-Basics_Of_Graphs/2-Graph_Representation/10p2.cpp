#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    // In the graph we are representing, A = 0, B = 1, C = 2, D = 3


    // Representing graphs using an adjacency list
    int n = 4; // n is the number of nodes
    vector<int> adjList[n];
    adjList[0].push_back(1);
    adjList[1].push_back(3);
    adjList[2].push_back(0);
    adjList[2].push_back(1);
    adjList[3];
}