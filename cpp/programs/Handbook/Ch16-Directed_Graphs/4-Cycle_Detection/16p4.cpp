#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    vector<int> function;

public:
    Graph(int N) {
        this->N = N;
        function = vector<int>(N);
    }
    void addEdge(int a, int b) {
        function[a] = b;
    }
    int succ(int a) {
        return function[a];
    }
    int floyds() {
        int a = succ(0);
        int b = succ(succ(0));

        while(a != b) {
            a = succ(a);
            b = succ(succ(b));
        }
        return a;
    }
    int cycleLength() {
        int first = floyds();
        int b = succ(first);
        int length = 1;

        while(b != first) {
            b = succ(b);
            length++;
        }

        return length;
    }
};

int main() {
    Graph successor(6);

    successor.addEdge(0, 1);
    successor.addEdge(1, 2);
    successor.addEdge(2, 3);
    successor.addEdge(3, 4);
    successor.addEdge(4, 5);
    successor.addEdge(5, 3);

    cout << "Start of the cycle is " << successor.floyds() << "\n";
    cout << "The length of the cycle is " << successor.cycleLength() << "\n";
}