# Sorting in C++

## Comparison Operators

Comparison Operators are discussing how a data structure or objects are sorted.

1. Integer, Double, Float, Byte, etc = By Value
2. String = alphabetically; capital letters are before lowercase letters
3. Pairs = (First), (Second), (Third), ...

## User defined objects – ```struct```

Structs are very useful because they allow users to **create they own objects**. Users can define personal variables for each object. This greatly simiplifies code because they can have a struct keep a massive amount of information instead of storing them in multiple arrays.

In the following code, you can see that these objects **can be sorted** by creating a funciton named ```bool operator<(const struct_name &variable_name) const {}```. This function must return a true or false value. If the value is **true, the current object is smaller than the comparing parameter** and if the value is **false, the current object is larger than the comparing parameter**.

## User defined sorting

Sometimes we want to sort an array in our own manner, to do this we can simply create a function. For example the function
```c++
bool comp(string a, string b) {
    // Return if one is smaller
    if (a.size() != b.size()) return a.size() < b.size();
    // Return by ascii value
    return a < b
}
```