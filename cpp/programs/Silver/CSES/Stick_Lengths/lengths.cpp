// To minimize the sum, the greedy algorithm is to use the median to set all of the sticks

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n;
    cin >> n;

    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    ll median;

    if(n % 2 == 1) {
        median = arr[n / 2];
    } else {
        median = (arr[n / 2 - 1] + arr[n / 2]) / 2;
    }

    ll ans = 0;
    for(ll i:arr) {
        ans += abs(i - median);
    }

    cout << ans;
}