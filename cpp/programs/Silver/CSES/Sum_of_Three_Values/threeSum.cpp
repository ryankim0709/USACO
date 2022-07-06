#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio();
    cin.tie(0);

    int n, x;
    cin >> n >> x;

    map<int, vector<int>> count;
    int vals[n];

    for (int i = 0; i < n; i++) {
        cin >> vals[i];
        count[vals[i]];
        count[vals[i]].push_back(i);
    }

    sort(vals, vals + n);
    bool found = false;
    for (int i = 0; i < n; i++)
    {
        if(found)
            break;
        ll first = vals[i];
        ll target = x - first;

        ll lower = 0;
        ll upper = n - 1;

        while(lower < upper) {
            if(lower == i)
                lower++;
            else if(upper == i)
                upper--;
            if(upper == lower)
                continue;
            ll currSum = vals[lower] + vals[upper];
            if(currSum == target) {
                found = true;
                // FOUND
                if(first != vals[lower] && vals[lower] != vals[upper]) {
                    // All different
                    cout << count[first][0] + 1 << ' ' << count[vals[lower]][0] + 1 << ' ' << count[vals[upper]][0] + 1;
                } else if(first == vals[lower] && vals[lower] == vals[upper]) {
                    // All the same
                    cout << count[first][0] + 1 << ' ' << count[first][1] + 1 << ' ' << count[first][2] + 1;
                } else {
                    // Two are the same
                    if(first == vals[lower]) {
                        cout << count[first][0] + 1 << ' ' << count[first][1] + 1 << ' ' << count[vals[upper]][0] + 1;
                    } else if(first == vals[upper]) {
                        cout << count[first][0] + 1 << ' ' << count[first][1] + 1 << ' ' << count[vals[lower]][0] + 1;
                    } else {
                        cout << count[first][0] + 1 << ' ' << count[vals[lower]][0] + 1 << ' ' << count[vals[upper]][1] + 1;
                    }
                }
                break;
            }
            else if (currSum < target)
            {
                lower++;
            }
            else
            {
                upper--;
            }
        }
    }
    if(!found)
            cout << "IMPOSSIBLE";
}