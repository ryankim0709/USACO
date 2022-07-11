#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {

    // Static range queries
    
    // Static array sums

    // 1-D array
    int n = 8;
    int arr[] = {1, 3, 4, 8, 6, 1, 4, 2};
    int prefix[n + 1];

    for (int i = 1; i < n + 1; i++) 
        prefix[i] = prefix[i - 1] + arr[i - 1];
    
    // sum(a, b) = sum(0,b) - sum(0,a-1)
    // Makes sense because you are subtracting the portion you don't want (0, a-1) from the whole, (0,b)

    int sum58 = prefix[8] - prefix[5 - 1]; // 6 + 1 + 4 + 2 = 13
    cout << "1-D prefix " << sum58 << "\n";

    // 2-D array
    n = 4;
    int arr2d[4][4] = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    int prefix2d[n+1][n+1]; // Generate sums from (0,0) to (x,y)

    // preifx[row][col] = prefix[row - 1][col] + prefix[row][col - 1] - prefix[row - 1][col - 1] + arr[row - 1][col - 1]
    for (int row = 0; row < n + 1; row ++) {
        for (int col = 0; col < n + 1; col ++) {
            if(row == 0 || col == 0) {
                prefix2d[row][col] = 0;
                continue;
                
            }
            prefix2d[row][col] = prefix2d[row - 1][col] + prefix2d[row][col - 1] - prefix2d[row - 1][col - 1] + arr2d[row - 1][col - 1];
        }
    }

    // Sum from (1,2) to (3,3);
    int fx = 1;
    int fy = 2;
    int sx = 3;
    int sy = 3;
    int sum1223 = prefix2d[sx][sy] - prefix2d[sx][fy - 1] - prefix2d[fx - 1][sy] + prefix2d[fx - 1][fy - 1];
    cout << "2-D prefix " << sum1223 << "\n";

    // Minimum queries
}