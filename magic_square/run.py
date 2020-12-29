#!/usr/bin/env python3
import argparse

from src.helpers.even import calc_double_even_square as cdes, calc_single_even_square as cses
from src.helpers.odd import calc_odd_square as cos
from src.exceptions import InvalidIntegerValue


class MagicSquare:
    def __init__(self, n: int):
        """ Description of __init__()
        __init__ initializes the MagicSquare class, checks the proveded n arg and initializes self.n with the value of n.

        Args:
            n (int): The amount of columns / rows which the square exits off.
        """

        if n > 2:
            self.n: int = n
        else:
            raise InvalidIntegerValue

    def gen(self):
        """ Description of gen()
        This gen function - which stand for generate - decides which helper function to call,
        and calls the helper function, while passing self.n as arg.
        """
        if self.n % 2 == 0:
            if self.n % 4 == 0:
                self.square: list = cdes(n=self.n)
            else:
                self.square: list = cses(n=self.n)
        else:
            self.square: list = cos(n=self.n)

    def __str__(self):
        """ Description of __str__()
        __str__ is used to display the final MagicSquare to the cli.
        """

        res: list = []
        for y in range(0, self.n):
            for x in range(0, self.n):
                res.append('%2d ' % self.square[y][x])

                if x == self.n - 1:
                    res.append('\n')

        return ''.join(res)


def main():
    """ Description of main()
    The main function parses the cli args with the argparse module.
    Then create a new MagicSquare instance and runs the gen() function.
    After that the ms is printed to the cli.
    """

    parser = argparse.ArgumentParser(
        description='Magic Square generator.'
    )

    parser.add_argument(
        '-l',
        '--length',
        action='store',
        dest='length',
        type=int,
        help='Amount of square columns and rows'
    )

    args = parser.parse_args()

    ms = MagicSquare(n=args.length)
    ms.gen()
    print(ms)


if __name__ == '__main__':
    main()
