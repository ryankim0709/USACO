#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int cases;
    cin >> cases;

    for (int i = 0; i < cases; i ++) {
        int n;
        cin >> n;
        int arr[n];

        for (int j = 0; j < n; j ++) {
            cin >> arr[j];
        }
        sort(arr, arr + n);

        int total = 0;
        for (int j = 1; j < n; j ++) {
            total += arr[j] - arr[0];
        }
        cout << total << "\n";
    }
}