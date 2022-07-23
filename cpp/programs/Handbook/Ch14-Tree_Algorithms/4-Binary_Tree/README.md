# Binary Trees
A binary tree is a tree in which every node has a left and right child except the leaf nodes(or the parents of the leaf nodes). Essentially, a binary tree is a **completely filled** graph in which each node has `0`, `1`, or `2` children nodes.

![Binary Tree](../images/binary_tree.png)

There are **`3`** ways we can recursively traverse a binary tree
* Pre-order: root -> left -> right
* In-order: left -> root -> right
* Post-order: left -> right -> root

In the above tree,
* Pre-order: `[8, 3, 16, 4, 7, 10, 14, 13]`
* In-order: `[1, 3, 4, 6, 7, 8, 10, 13, 14]`
* Post-order: `[1, 4, 7, 6, 3, 13, 14, 10, 8]`

If we are given the pre-order and in-order of a tree, we can recunstruct the tree exactly. Similarly, we can reconstruct the exact tree given the post-order and in-order of a tree. However, we can't find the tree structure given the pre-order and post-order of a tree because there could be more than `1` tree that matches the two.