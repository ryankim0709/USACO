#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void balanceQueens(int q, int (&board)[4][4], int n, int (&data)[4][4]) {
    // Data
    // Row [False, False, False, False]
    // Column [False, False, False, False]
    // Diag 1(from the top left) [False, False, False, False]
    // Diag2 (from the bottom left) [False, False, False, False]

    // How do you pass any size 2-D array in C++. Realistically would need for USACO
    if(q == n-1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cout << board[i][j];
            }
            cout << "\n";
        }
        cout << "\n\n";
    }
    for (int y = 0; y < 4; y ++) {
        if(!data[0][q] && !data[1][y] && data[2][q + y] && data[3][q-y+n-1]) {
            data[0][q] = true;
            data[1][y] = true;
            data[2][q + y] = true;
            data[3][q - y + n - 1] = true;
            board[q][y] = 'Q';
            balanceQueens(q + 1, board, n, data);
            data[0][q] = false;
            data[1][y] = false;
            data[2][q + y] = false;
            data[3][q - y + n - 1] = false;
            board[q][y] = '*';
        }
    }
}

int main() {
    int board[4][4];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            board[i][j] = '*';
        }
    }
    balanceQueens(0, board, 4, board);
}