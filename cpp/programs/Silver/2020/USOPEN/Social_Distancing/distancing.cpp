#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MAX pow(10,9)+1

ll N, M;
vector<pair<ll, ll>> unions;

bool simulate(ll D) {
    ll ind = 0;
    ll currCows = 1;
    ll currPos = unions[0].first;

    // cout << D << '\n';
    while(ind < M) {
        ll start = unions[ind].first;
        ll end = unions[ind].second;
        //cout << start << " " << end << " " << currCows << " " << currPos << " " << ind << "\n";
        if(currPos + D <= start) {
            currCows ++;
            currPos = start;
            if(currCows == N) return true;
        }

        while(currPos + D >= start && currPos + D <= end) {
            currCows ++;
            currPos += D;
            if(currCows == N) return true;
        }
        ind++;
    }
    return false;
}

int main() {
    freopen("socdist.in", "r", stdin);
    freopen("socdist.out", "w", stdout);
    cin >> N >> M;
    
    for(ll i = 0; i < M; i++){
        ll first, second;
        cin >> first >> second;
        unions.push_back({first, second});
    }
    sort(unions.begin(), unions.end());
    ll lo = 2;
    ll hi = MAX;
    ll ans = -1;
    while (lo <= hi)
    {
        ll mid = lo + (hi - lo)/2;
        if(simulate(mid)) {
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
        // cout << lo << " " << hi << " " << mid << " " << ans << " " <<  "\n";
    }

    cout << ans;
}