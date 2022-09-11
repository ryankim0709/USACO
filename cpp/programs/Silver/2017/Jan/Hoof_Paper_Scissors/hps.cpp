#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    int N;
    cin >> N;

    int hoof[N + 1];
    int paper[N + 1];
    int scissors[N + 1];

    hoof[0] = 0;
    paper[0] = 0;
    scissors[0] = 0;

    for (int i = 1; i <= N; i++) {
        hoof[i] = hoof[i - 1];
        paper[i] = paper[i - 1];
        scissors[i] = scissors[i - 1];

        char a;
        cin >> a;

        if(a == 'P')
            paper[i]++;
        else if(a == 'H')
            hoof[i]++;
        else
            scissors[i]++;
    }

    int ans = 0;

    for (int i = 1; i < N; i++)
    {
        int firstRound = max(paper[i], max(hoof[i], scissors[i]));
        int hoofRoundTwo = hoof[N] - hoof[i];
        int paperRoundTwo = paper[N] - paper[i];
        int scissorsRoundTwo = scissors[N] - scissors[i];
        int secondRound = max(hoofRoundTwo, max(paperRoundTwo, scissorsRoundTwo));
        ans = max(ans, firstRound + secondRound);
    }
    cout << ans;
}