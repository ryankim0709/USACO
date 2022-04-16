#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

int main() {
    int n{10};
    int array[10] = {1, 3, 8, 2, 9, 2, 5, 6};

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - 1; j++) {
            if (array[j] > array[j+1]) {
                swap(array[j], array[j + 1]);
            }
        }
    }
    for (int i:array) {
        cout << i << endl;
    }

    return 0;
}