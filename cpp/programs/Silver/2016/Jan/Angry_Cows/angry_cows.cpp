#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool blowupAll(int* bales, int size, int R, int K) {
    int bombsUsed = 0;
    int blowedUntil = -1;
    for (int i = 0; i < size; i++) {
        int currLoc = bales[i];

        if(currLoc <= blowedUntil) {
            continue;
        }

        // Not blown up yet
        bombsUsed++;
        blowedUntil = currLoc + 2 * R;
    }

    return bombsUsed <= K;
}

int main() {

    freopen("angry.in", "r", stdin);
    freopen("angry.out", "w", stdout);

    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, K;
    cin >> N >> K;

    int bales[N];
    for (int i = 0; i < N; i++) {
        cin >> bales[i];
    }

    sort(bales, bales + N);

    int low = 0;
    int high = (bales[N - 1] - bales[0]) / 2 + 1;

    while(low < high) {
        int mid = low + (high - low) / 2;

        if(blowupAll(bales, N, mid, K)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }

    cout << high;
}