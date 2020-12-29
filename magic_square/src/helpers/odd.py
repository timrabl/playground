#!/usr/bin/env python3

def calc_odd_square(n: int) -> list:
    if n % 2 == 0:
        n += 1

    square: list = [
        [
            0 for _ in range(n)
        ] for _ in range(n)
    ]

    p: int = 1
    j: int = 0

    # // = integer division operator; result 'll be a integer
    i: int = n // 2

    while p <= (n * n):
        square[i][j] = p

        ti: int = i + 1
        if ti >= n:
            ti = 0

        tj: int = j - 1
        if tj < 0:
            tj = n - 1

        if square[ti][tj] != 0:
            ti = i
            tj = j + 1

        i = ti
        j = tj
        p = p + 1

    return square
