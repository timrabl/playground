# Magic Square

The Magic square (a square where the sum of every column, line or diagonal is the same - the magic number)

In the following, the tasks 1-2 are left out.
Tasks 3 is done in python instead of java.


# Run

Replace **AMOUNT_OF_COLUMNS** with your amount of columns.

```sh
python3 run.py -l {AMOUNT OF COLUMNS}
```

The test.py file test the generation of squars from 3 to 30 (step = 1)
```sh
python3 test.py
```

# Specification`

```
16  3  2 13
 5 10 11  8
 9  6  7 12
 4 15 14  1
```

If the number of columns or lines n is odd, the problem can be solved with the following algorithm:

- In the first row, start in the middle with 1
- if possible, write the next number in the box at the top diagonally on the right.
- Please note the following exceptions:
    - If the last number entered is divisible by n, you continue in the box below this.
    - if the last e-filled box is at the top, you continue at the very bottom in the next column.
    - Arrived at the right edge, continue in the line above on the left at the beginning.

As you can easily see, it is not easy to come up with the algorithm in the above example.
You have to deal with the problem for a long time. The theory of algorithms therefore plays a central role in programming.

Tasks:

- Draw a magic square with n = 5 and n = 7 by hand.
- Draw a structogramm or a pseudocode for the above algorithm.
- Program the magic square in java. The user should be able to determine the size of the magic square.
