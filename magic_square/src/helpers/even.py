#!/usr/bin/env python3
from src.helpers.odd import calc_odd_square


def calc_double_even_square(n: int) -> list:
    square: list = [
        list(
            range(
                1 + i * n,
                n + (i * n) + 1
            )
        ) for i in range(n)
    ]

    # integer division; --> n1 is always int
    n1: int = n // 4
    for r in range(n1):
        r1 = square[r][n1:-n1]
        r2 = square[n - r - 1][n1:-n1]

        r1.reverse()
        r2.reverse()

        square[r][n1:-n1] = r2
        square[n - r - 1][n1:-n1] = r1

    for r in range(n1, n - n1):
        r1 = square[r][:n1]
        r2 = square[n - r - 1][n - n1:]

        r1.reverse()
        r2.reverse()

        square[r][:n1] = r2
        square[n - r - 1][n - n1:] = r1

    return square


def calc_single_even_square(n: int) -> list:
    if n % 2 == 1:
        n += 1

    while n % 4 == 0:
        n += 2

    square: list = [
        [
            0 for _ in range(n)
        ] for _ in range(n)
    ]

    # integer division operator; result 'll be integer
    z: int = n // 2

    # int * int = int
    b: int = z * z

    # 2 * int = int
    c: int = 2 * b

    # 3 * int = int
    d: int = 3 * b

    o = calc_odd_square(n=z)

    for j in range(0, z):
        for i in range(0, z):
            a = o[i][j]
            square[i][j] = a
            square[i + z][j + z] = a + b
            square[i + z][j] = a + c
            square[i][j + z] = a + d

    lc: int = z // 2
    rc: int = lc
    for j in range(0, z):
        for i in range(0, n):
            if i < lc or i > n - rc or (i == lc and j == lc):
                if not (i == 0 and j == lc):
                    t = square[i][j]
                    square[i][j] = square[i][j + z]
                    square[i][j + z] = t

    return square
