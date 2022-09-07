#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    int n, q;
    cin >> n >> q;

    vector<int> one, two, three;
    one.push_back(0);
    two.push_back(0);
    three.push_back(0);

    for (int i = 1; i <= n; i ++) {
        int id;
        cin >> id;

        one.push_back(one[i - 1]);
        two.push_back(two[i - 1]);
        three.push_back(three[i - 1]);

        if(id == 1) one[i]++;
        else if (id == 2) two[i]++;
        else three[i]++;
    }
    for (int i = 0; i < q; i++)
    {
        int a, b;
        cin >> a >> b;

        int hVal = one[b] - one[a - 1];
        int gVal = two[b] - two[a - 1];
        int jVal = three[b] - three[a - 1];

        cout << hVal << " " << gVal << " " << jVal << "\n";
    }
}