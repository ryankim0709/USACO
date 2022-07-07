#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; // Array size
    cin >> N;

    int arr[N];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    stack<int> solStack; // Solution stack

    for (int i = 0; i < N; i++) {
        int currElem = arr[i];

        if(solStack.size() == 0) {
            cout << -1 << "\n";
            solStack.push(currElem);
        }
        else
        {
            if(solStack.top() < currElem) {
                cout << solStack.top() << "\n";
                solStack.push(currElem);
            } else {
                while(solStack.size() > 0) {
                    if(solStack.top() < currElem) {
                        cout << solStack.top() << "\n";
                        break;
                    } else {
                        solStack.pop();
                    }
                }

                if(solStack.size() == 0) {
                    cout << -1 << "\n";
                }
                solStack.push(currElem);
            }
        }
    }
}
