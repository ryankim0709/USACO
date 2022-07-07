#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {

    freopen("pairup.in", "r", stdin);
    freopen("pairup.out", "w", stdout);

    int N;
    cin >> N;

    map<ll, ll> input;
    ll occurences[N];
    ll outputs[N];

    for (int i = 0; i < N; i++) {
        ll num, production;
        cin >> num >> production;
        input.insert({production, num});
        outputs[i] = production;
    }

    sort(outputs, outputs + N);
    for (int i = 0; i < N; i++) {
        occurences[i] = input[outputs[i]];
    }

    int lower = 0;
    int higher = N - 1;

    ll ans = 0;
    while (lower < higher)
    {
        int minOccur = min(occurences[lower], occurences[higher]);
        ans = max(ans, outputs[lower] + outputs[higher]);

        occurences[lower] -= minOccur;
        occurences[higher] -= minOccur;

        if(occurences[lower] == 0) {
            lower++;
        } 
        if(occurences[higher] == 0) {
            higher--;
        }
    }
    cout << max(ans, 2 * outputs[lower]);
}