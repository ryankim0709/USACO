#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio();
    cin.tie();

    int n, x;
    cin >> n >> x;

    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int total = 0;

    int p1 = 0;
    int p2 = 0;

    int currSum = arr[0];
    while (p2 < n)
    {
        if(currSum == x) {
            total++;
        }
        if(p1 == n - 1 && p2 == n - 1) {
            break;
        }
        if(currSum + arr[p2 + 1] > x) {
            currSum -= arr[p1];
            p1++;
        } else {
            currSum += arr[p2 + 1];
            p2++;
        }
    }
    cout << total;
}