// This algorithm gives the customer who needs the greatest space a room and goes down.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m, k;
    cin >> n >> m >> k;

    int sizes[n];
    int available[m];

    for (int i = 0; i < n; i++) {
        cin >> sizes[i];
    }
    for (int i = 0; i < m; i++)
    {
        cin >> available[i];
    }

    sort(sizes, sizes + n);
    sort(available, available + m);
    int ans = 0;

    int roomInd = m - 1;
    for (int i = n - 1; i >= 0; i--)
    {
        int curr = sizes[i];
        bool found = false;
        while(!found) {
            if(roomInd == -1) {
                found = true;
                break;
            }
            int possibleRoom = available[roomInd];
            if(possibleRoom <= curr + k && possibleRoom >= curr - k) {
                ans++;
                roomInd--;
                found = true;
            } else if(possibleRoom > curr + k) {
                roomInd--;
            } else if(possibleRoom < curr - k) {
                found = true;
            }
        }
    }
    cout << ans;
}