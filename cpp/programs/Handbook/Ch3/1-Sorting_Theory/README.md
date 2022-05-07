# Bubble Sort

Bubble sort is a ```O(n^2)``` algorithm which can be useful for sorting. As the name suggests, we are going to bubble each element to the correct position.

Given the array ```[1,4,2,5,7,4,9,7]```, we are going to "bubble" the largest value by comparing each adjacent value, and if the left hand value ```(arr[j])``` > the right hand value ```(arr[j + 1])```, then we swap the elements. After one iteration of this, our list transforms from ```[1,4,2,5,7,4,9,7]``` to ```[1,2,4,5,4,7,7,9]```. As you can see, the 9 "bubbled" to the top. Using the same idea, after the next iteration, 7 will bubble to the top, etc until the whole array has been sorted.

Code:
```
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
