# NumFromString
Extract any number from a string in Golang, Python, Java.

## Task

The first valid positive number according to normal scale should be found and returned from a string.
The following numbers should be tested as an example:  

Any number of characters can be placed in front of (x) and behind (y) the respective number. 

#### Given numbers:

|    string |  return |
| :-------: | :-----: |
| `x5y`     | `5`     |
| `x5,y`    | `5`     |
| `5,01Y`   | `5,01`  |
| `x,53y`   | `0,53`  |
| `x00,03y` | `0,03`  |
| `x5,0y`   | `5,0`   |

The problem can be solved with an automat. The state diagram is best suited for the planning phase (is standardized in the UML).
Tasks:
- Draw the state diagram of the above program. For now, floating point numbers should be
   not be considered. Imagine that character by character of the string run in the machine. The initial state is that no number has yet been found.
- Program the program in Java and test the function with the above examples.
- Expand the state diagram so that you can also find negative numbers.
- Extend and test the program appropriately. 