#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool ok(int* arr, int k, int max, int size) {
    int ending[k];
    for (int i = 0; i < k; i ++) {
        ending[i] = arr[i];
    }
    for (int i = 0 + k; i < size; i++)
    {
        int &smallest = *min_element(ending, ending + k);
        for (int j = 0; j < k; j++) {
            if(ending[j] == smallest) {
                ending[j] += arr[i];
                break;
            }
        }
    }
    int &greatest = *max_element(ending, ending + k);
    return greatest <= max;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    freopen("cowdance.in", "r", stdin);
    freopen("cowdance.out", "w", stdout);

    int n, t;
    cin >> n >> t;

    int times[n];
    for (int i = 0; i < n; i++) {
        cin >> times[i];
    }

    int min = 0, high = n;
    while(min < high) {
        int mid = min + (high - min) / 2;

        if(ok(times, mid, t, n)) {
            high = mid;
        } else {
            min = mid + 1;
        }
    }
    cout << high;
}