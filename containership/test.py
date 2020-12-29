#!/usr/bin/env python3

from pprint import pprint as print
from src.helpers.classes import NRowsNTiersShip, Stauplan


def test(rows: int, tiers: int, data: list):
    ship: NRowsNTiersShip = NRowsNTiersShip(rows=rows, tiers=tiers)
    #ship.insert(data=data)
    print(ship.bay)
    #stpl: Stauplan = Stauplan(ship=ship)
    #print(stpl)


if __name__ == '__main__':
    sample_container_list: list = [
        [1, 23],
        [2, 22],
        [3, 11],
        [4, 10],
        [5, 9],
        [6, 9],
        [7, 8],
        [8, 8],
        [9, 8],
        [10, 7],
        [11, 7],
        [12, 6]
    ]

    test(rows=3, tiers=4, data=sample_container_list)
