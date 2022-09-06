#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> arr(N + 2, 0);

    for (int i = 0; i < K; i++) {
        int a, b;
        cin >> a >> b;

        arr[a]++;
        arr[b + 1]--;
    }

    vector<int> prefix(N + 1, 0);
    vector<int> ans;
    for (int i = 1; i <= N; i++)
    {
        prefix[i] = arr[i] + prefix[i - 1];
        ans.push_back(prefix[i]);
    }

    sort(ans.begin(), ans.end());
    cout << ans[N / 2] << "\n";
}