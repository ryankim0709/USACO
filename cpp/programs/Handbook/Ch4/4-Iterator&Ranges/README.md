# Competitive Guide For Programmers Ch4 Section 4

When passing an array into a function, you can pass the reference or a copy. 
If you have ```int arr[5] = {4,3,2,5,1}``` and you define ```void printArr(int *arr)``` or ```void printArr(int arr[])```, you are passing the reference. However, if you define ```void printArr(int arr[5])``` you are **passing in a copy of the first 5 elements of whatever you passed in**.