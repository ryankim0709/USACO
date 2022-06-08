#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool works(int* arrivals, int size, int maxWait, int buses, int maxCapacity) {
    int totalBuses = 0;
    int currTime = arrivals[0];
    int currOnBus = 0;

    for (int i = 0; i < size; i++) {
        int currArrival = arrivals[i];

        if(currArrival - currTime <= maxWait) { // now - arrival <= max wait time, add to bus
            currOnBus++;
        } else {
            totalBuses++;
            currTime = currArrival;
            currOnBus = 1;
        }
        if(currOnBus == maxCapacity) { // If max capacity
            totalBuses++;
            currTime = arrivals[i + 1]; // Could cause errors
            currOnBus = 0;
        }
    }

    if(currOnBus > 0) {
        totalBuses++;
    }

    return totalBuses <= buses;
}

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    freopen("convention.in", "r", stdin);
    freopen("convention.out", "w", stdout);
    int N, M, C;
    cin >> N >> M >> C;

    int arrivals[N];
    for (int i = 0; i < N; i++) {
        cin >> arrivals[i];
    }
    sort(arrivals, arrivals + N);

    int low = 0;
    int high = arrivals[N - 1];

    while(low < high) {
        int mid = low + (high - low) / 2;

        if(works(arrivals, N, mid, M, C)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    cout << high;
}