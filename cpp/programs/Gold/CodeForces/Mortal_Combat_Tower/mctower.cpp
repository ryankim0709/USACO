#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define INF 300000

int main() {
    int cases;
    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int n;
        cin >> n;
        int boses[n];

        for (int j = 0; j < n; j ++) {
            cin >> boses[j];
        }

        int dp[4][n];
        dp[0][0] = INF;
        dp[1][0] = INF;
        dp[2][0] = boses[0];
        dp[3][0] = INF;

        if(n >= 2) {
            dp[0][1] = dp[2][0];
            dp[1][1] = INF;
            dp[2][1] = INF;
            dp[3][1] = boses[0] + boses[1];
        }
        for (int col = 2; col < n; col++)
        {
            for (int row = 0; row < 4; row++)
            {
                // for (int j = 0; j < 4; j++) {
                //     for(int k:dp[j]) {
                //         cout << k << " ";
                //     }
                //     cout << "\n";
                // }
                //cout << "\n";
                if (row == 0)
                { // Yourself 1
                    int f1 = dp[2][col - 1];
                    int f2 = dp[3][col - 1];
                    dp[row][col] = min(f1, f2);
                }
                else if (row == 1)
                { // Yourself 2
                    int f1 = dp[2][col - 2];
                    int f2 = dp[3][col - 2];
                    dp[row][col] = min(f1, f2);
                }
                else if (row == 2)
                { // Friend 1
                    int y1 = dp[0][col - 1];
                    int y2 = dp[1][col - 1];
                    if (y1 != INF)
                    {
                        y1 += boses[col];
                    }
                    if (y2 != INF)
                    {
                        y2 += boses[col];
                    }
                    dp[row][col] = min(y1, y2);
                }
                else if (row == 3)
                { // Friend 2
                    int y1 = dp[0][col - 2];
                    int y2 = dp[1][col - 2];
                    if (y1 != INF)
                    {
                        y1 = y1 + boses[col - 1] + boses[col];
                    }
                    if (y2 != INF)
                    {
                        y2 = y2 + boses[col - 1] + boses[col];
                    }
                    dp[row][col] = min(y1, y2);
                }
            }
        }
        cout << min(min(dp[0][n - 1], dp[1][n - 1]), min(dp[2][n - 1], dp[3][n - 1])) << "\n";
    }
}