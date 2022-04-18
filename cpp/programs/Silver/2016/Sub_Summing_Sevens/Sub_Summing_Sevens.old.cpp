#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int find(int arr[], int n)
{
    for (int i = n; i >= 0; i--) {
        if(i == 0) {
            return 0;
        } else {
            for (int j = 1; j <= n - i + 1; j++) {
                if((arr[i + j - 1] - arr[j - 1])%7 == 0) {
                    return i;
                }
            }
        }
    }
    return 0;
}

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    int n;
    cin >> n;

    int prefix[n + 1];
    prefix[0] = 0;
    for (int i = 1; i <= n; i++)
    {
        int next;
        cin >> next;
        prefix[i] = (prefix[i - 1] + next) % 7;
    }

    cout << find(prefix, n) << endl;
}