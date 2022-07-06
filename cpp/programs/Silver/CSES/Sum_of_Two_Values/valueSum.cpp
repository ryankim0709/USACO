#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, x;
    cin >> n >> x;
    vector<pair<int, int>> arr;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        arr.push_back({num, i + 1});
    }
    sort(arr.begin(), arr.end());

    int p1 = 0;
    int p2 = n - 1;

    while(p1 < p2) {
        int currSum = arr[p1].first + arr[p2].first;

        if(currSum == x) {
            cout << min(arr[p1].second, arr[p2].second) << " " << max(arr[p1].second, arr[p2].second) << "\n";
            break;
        }
        else if(currSum < x) {
            p1++;
        } else {
            p2--;
        }
    }
    if(p1 == p2)
        cout << "IMPOSSIBLE";
}