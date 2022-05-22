#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void merge(int array[], int const left, int const mid, int const right) {
    auto const subArrayOne = mid - left + 1;
    auto const subArrayTwo = right - mid;

    auto *leftArray = new int[subArrayOne];
    auto *rightArray = new int[subArrayTwo];

    // Fill the temporary arrays
    for (auto i = 0; i < subArrayOne; i++)
        leftArray[i] = array[left + i];
    for (auto i = 0; i < subArrayTwo; i++)
        rightArray[i] = array[mid + 1 + i];

    auto indexOfSubArrayOne = 0;
    auto indexOfSubArrayTwo = 0;
    int indexOfMergedArray = left;

    while (indexOfSubArrayOne < subArrayOne && indexOfSubArrayTwo < subArrayTwo) {
        // Since both are in order, we check which one is larger, and add that one
        if (leftArray[indexOfSubArrayOne] <= rightArray[indexOfSubArrayTwo]) {
            array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
            indexOfSubArrayOne++;
        } else {
            array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
            indexOfSubArrayTwo++;
        }
        indexOfMergedArray++;
    }

    // Fill in missing values
    while(indexOfSubArrayOne < subArrayOne) {
        array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
        indexOfSubArrayOne++;
        indexOfMergedArray++;
    }
    while(indexOfSubArrayTwo < subArrayTwo) {
        array[indexOfMergedArray] = leftArray[indexOfSubArrayTwo];
        indexOfSubArrayTwo++;
        indexOfMergedArray++;
    }
}
void mergeSort(int array[], int const begin, int const end) {
    // Begin is the right pointer and end is the left pointer
    if(begin >= end) {
        return;
    }

    auto mid = begin + (end - begin) / 2;
    mergeSort(array, begin, mid);
    mergeSort(array, mid + 1, end);
    merge(array, begin, mid, end);
}

void printArray(int A[], int size) {
    for (int i = 0; i < size; i++)
    {
        cout << A[i] << " ";
    }
}

int main() {
    int arr[] = {12, 13, 5, 11, 6, 7};
    int arr_size = sizeof(arr) / sizeof(arr[0]);

    cout << "Given array is \n";
    printArray(arr, arr_size);

    cout << "\nSorted array is \n";
    mergeSort(arr, 0, arr_size - 1);
    printArray(arr, arr_size);
}