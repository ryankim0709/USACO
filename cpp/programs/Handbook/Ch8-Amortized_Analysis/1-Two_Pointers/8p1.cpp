#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    int x;
    cin >> n;
    cin >> x;
    int arr[n];

    for (int i = 0; i < n; i++) 
        cin >> arr[i];

    int p1 = 0;
    int p2 = 0;
    int currSum = arr[0];

    while(p2 < n && p1 < n) {
        if(currSum == x) {
            cout << "Found! Between Index " << p1 << " and " << p2 << "\n";
            break;
        }
        int nextRight = p2 + 1;
        if(nextRight == n) {
            p1++;
            continue;
        } else if(currSum + arr[nextRight] <= x) {
            currSum += arr[nextRight];
            p2++;
        } else if(currSum + arr[nextRight] > x) {
            currSum -= arr[p1];
            p1++;
        }
    }

    cin >> n;
    cin >> x;
    int tsum[n];

    for (int i = 0; i < n; i++) 
        cin >> tsum[i];

    sort(tsum, tsum + n);

    p1 = 0;
    p2 = n - 1;
    while(p1 < p2) {
        int currSum = tsum[p1] + tsum[p2];
        if(currSum == x) {
            cout << tsum[p1] << " and " << tsum[p2] << " exist in the array and sum to " << x;
            break;
        }
        if(currSum > x) {
            p2--;
        } else {
            p1++;
        }
    }
}