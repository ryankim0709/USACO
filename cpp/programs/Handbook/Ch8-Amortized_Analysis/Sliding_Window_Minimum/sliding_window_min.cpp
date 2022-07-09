#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k; // n is size of array and k is size of sliding window
    cin >> n >> k;

    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    deque<int> queue;

    for (int i = 0; i < k; i++) {
        if(queue.size() == 0)
            queue.push_back(arr[i]);
        else if (arr[i] < queue.front())
        {
            queue.clear();
            queue.push_back(arr[i]);
        }
        else if (arr[i] > queue.back())
        {
            queue.push_back(arr[i]);
        }
    }
    cout << queue.front() << "\n";
    for (int i = 1; i < n - k; i++)
    {
        int removed = arr[i - 1];
        int added = arr[i + k - 1];
        if(queue.front() == removed) {
            queue.pop_front();
        }
        while(queue.size() > 0 && queue.back() >= added) {
            queue.pop_back();
        }
        queue.push_back(added);
        cout << queue.front() << "\n";
    }
}