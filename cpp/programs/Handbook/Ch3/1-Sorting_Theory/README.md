# Sorting Theory

## Bubble Sort

Bubble sort is a ```O(n^2)``` algorithm which can be useful for sorting. As the name suggests, we are going to bubble each element to the correct position.

Given the array ```[1,4,2,5,7,4,9,7]```, we are going to "bubble" the largest value by comparing each adjacent value, and if the left hand value ```(arr[j])``` > the right hand value ```(arr[j + 1])```, then we swap the elements. After one iteration of this, our list transforms from ```[1,4,2,5,7,4,9,7]``` to ```[1,2,4,5,4,7,7,9]```. As you can see, the 9 "bubbled" to the top. Using the same idea, after the next iteration, 7 will bubble to the top, etc until the whole array has been sorted.

Code
```c++
int* bubble_sort(int arr[], int n) {
    // You have to pass in the size because we can't use the array (arr) to find out size
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j ++) {
            if(arr[j + 1] < arr[j]) {
                // Swapping

                // Function swapping
                swap(arr[j], arr[j + 1]);
            }
        }
    }
        return arr;
}
```
## Counting sort

Counting sort is a ```O(n)``` sorting algorithm and is very efficient. The premise of this type of sorting is using an array to "bookkeep" the number of occurences of an element there are. The greatest limitation to this method is that **all of the elements must be an integer between 0 and n**. If the elements are not an integer, we can use maps to emulate the proces, but the time complexity would rise to ```O(nlogn)``` because the automatic sorting of maps take ```O(logn)```.

Code (arrays)
```c++
void counting_sort(int arr[], int n) {
    // * is used when when determining the adress of the variable
    // & is used to display the value of the asterisk

    int finale[100] = {0};
    for (int i = 0; i < n; i++) {
        finale[arr[i]] += 1;
    }
    for(int i = 0; i < 100; i ++) {
        for(int j = 0; j < finale[i]; j ++) {
            cout << i << "\n";
        }
    }
}
```

Code (maps)
```c++
vector<int> counting_sort_map(int arr[], int n) {
    map<int, int> freq;

    for (int i = 0; i < n; i++) {
        int curr = arr[i];
        if(freq.find(curr) == freq.end()) {
            freq[curr] = 0;
        }
        freq[curr] += 1;
    }
    vector<int> finale;
    for (map<int, int>::iterator it = freq.begin(); it != freq.end(); ++it)
    {
        for (int j = 0; j < it->second; j++) {
            finale.push_back(it->first);
        }
    }
    return finale;
}
```