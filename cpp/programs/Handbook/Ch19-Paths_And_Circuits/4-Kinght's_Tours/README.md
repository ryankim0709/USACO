# Knight's Tours
A **knight's tour** is a set a moves a knight can take on a `n x n` chess board to visit all of the squares. A *closed* knights tour is a knights tour in which the knight can move back to its starting position while an *open* knights tour is a knights tour in which the knight can't return to its original position.

By definition, a knights tour is simply a Hamiltonion path in a graph whose nodes are the squares of the board with edges such that the knight can move from node `a` to node `b`.

## Warnsdorf's Rule
This rule is a simple rule for finding a knight's tour. The rule states that the knight should move to the square with the *smallest* number of possible moves as possible. Using this rule, we can find a knight's tour.