#include <iostream>
#include <bits/stdc++.h>
typedef long long ll;
using namespace std;

vector<ll> cows;
vector<pair<ll, ll>> markets;
vector<ll> rents;

ll N, M, R;

int main()  {
    freopen("rental.in", "r", stdin);
    // Get Input
    cin >> N >> M >> R;

    for(ll i = 0; i < N; i++) {
        ll val;
        cin >> val;
        cows.push_back(val);
    }
    for(ll i = 0; i < M; i++) {
        pair<ll, ll> currMarket;
        cin >> currMarket.second >> currMarket.first;
        markets.push_back(currMarket);
    }
    for(ll i = 0; i < R; i++) {
        ll val;
        cin >> val;
        rents.push_back(val);
    }

    // Sorting
    sort(cows.rbegin(), cows.rend());
    sort(markets.rbegin(), markets.rend());
    sort(rents.rbegin(), rents.rend());

    ll max_profit = 0;
    ll p_sale = 0;
    ll p_rent = 0;
    ll p_cow = 0;

    while(p_cow < N) {
        ll milk_amt = cows[p_cow];
        ll last = 0;
        ll curr_profit = 0;
        ll curr_shop = p_sale;

        while(curr_shop < M) {
            ll milk_to_sell = min(milk_amt, markets[curr_shop].second);
            milk_amt -= milk_to_sell;
            curr_profit += milk_to_sell * markets[curr_shop].first;

            if(milk_amt == 0) {
                last = milk_to_sell;
                break;
            }
            else {
                curr_shop += 1;
            }
        }

        if(p_rent == R or rents[p_rent] < curr_profit) {
            max_profit += curr_profit;
            markets[curr_shop].second -= last;
            p_sale = curr_shop;
            p_cow += 1;
        } else {
            max_profit += rents[p_rent];
            p_rent += 1;
            N -= 1;
        }
    }

    freopen("rental.out", "w", stdout);
    cout << max_profit;
}