#include <iostream>
#include <bits/stdc++.h>
#define INF 100000
using namespace std;

class Graph {
    int N;
    int matrix[5][5];

public:
    Graph(int N) {
        this->N = N;
        for (int i = 0; i < N;i ++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = INF;
            }
        }
    }
    void addPath(int s, int e, int w) {
        matrix[s][e] = w;
    }

    void floyd_warshall() {
        int distance[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) {
                    cout << i << ' ' << j << "\n";
                    distance[i][j] = 0;
                }
                else if(matrix[i][j] != INF)
                    distance[i][j] = matrix[i][j];
                else
                    distance[i][j] = INF;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            cout << "\n";
            for (int j = 0; j < N; j++) {
                cout << distance[i][j] << " ";
            }
        }
    }
};

int main() {
    Graph floyd(5);
    floyd.addPath(0, 1, 5);
    floyd.addPath(0, 3, 9);
    floyd.addPath(0, 4, 1);
    floyd.addPath(1, 0, 5);
    floyd.addPath(1, 2, 2);
    floyd.addPath(2, 1, 2);
    floyd.addPath(2, 3, 7);
    floyd.addPath(3, 2, 7);
    floyd.addPath(3, 0, 9);
    floyd.addPath(3, 4, 2);
    floyd.addPath(4, 3, 2);
    floyd.addPath(4, 0, 1);

    floyd.floyd_warshall();
}