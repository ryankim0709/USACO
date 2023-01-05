#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("cardgame.in", "r", stdin);
    freopen("cardgame.out", "w", stdout);
    int N;
    cin >> N;

    vector<int> holder;
    vector<int> elsie;
    vector<int> bessie;

    for (int i = 0; i < N; i++){
        int curr;
        cin >> curr;
        elsie.push_back(curr);
        holder.push_back(curr);
        }
    sort(holder.begin(), holder.end());

    int ind = 0;
    for (int i = 1; i <= 2 * N; i++) {
        if(holder[ind] != i) {
            bessie.push_back(i);
        } else {
            ind++;
        }
    }

    vector<int> eh, el, bh, bl;
    for (int i = 0; i < N / 2; i++) {
        eh.push_back(elsie[i]);
        el.push_back(elsie[N - i - 1]);
        bh.push_back(bessie[N - i - 1]);
        bl.push_back(bessie[i]);
    }

    sort(eh.begin(), eh.end());
    sort(bh.begin(), bh.end());
    sort(el.rbegin(), el.rend());
    sort(bl.rbegin(), bl.rend());

    int ans = 0;

    ind = 0;
    for (int i = 0; i < N / 2; i++) {
        if(ind >= N/2) {
            break;
        }
        int curr = eh[i];

        while(bh[ind] < curr) {
            ind++;
            if(ind >= N/2)
                break;
        }
        if(ind >= N/2)
            break;
        ans++;
        ind++;
    }

    ind = 0;
    for (int i = 0; i < N / 2; i++) {
        if(ind >= N/2) {
            break;
        }
        int curr = el[i];

        while(bl[ind] > curr) {
            ind++;
            if(ind >= N/2)
                break;
        }
        if(ind >= N/2)
            break;
        ans++;
        ind++;
    }

    cout << ans;
}