#include <iostream>
#include <bits/stdc++.h>
typedef long long ll;
using namespace std;

int main() {
    ll N, K;
    freopen("paintbarn.in", "r", stdin);
    cin >> N >> K;

    int fj_orig[1001][1001];
    int prefix[1002][1002];

    for(int i = 0; i < N; i++) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        
        fj_orig[x1][y1] += 1;
        fj_orig[x1][y2] -= 1;
        fj_orig[x2][y1] -= 1;
        fj_orig[x2][y2] += 1;
    }

    int ans = 0;
    for(int i = 1; i < 1002; i++) {
        for(int j = 1; j < 1002; j++) {
            prefix[i][j] = fj_orig[i - 1][j - 1] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            if(prefix[i][j] == K ) {
                //cout << i << ", " << j << "\n";
                ans ++;
            }
        }
    } 
    freopen("paintbarn.out", "w", stdout);
    cout << ans;
}