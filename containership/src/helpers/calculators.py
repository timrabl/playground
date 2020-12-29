#!/usr/bin/env python3

from dataclasses import is_dataclass


def get_min_row_index(bay: list) -> int:
    """Description of get_min_row_index()
    This function takes a list of list's as arg, sum every list and return the index position of the lowest summed list.

    Arg:
        bay (list): The list of list's where to get the index position of the lowest summed list.

    Return:
        res (int): The index position of the lowest summed list.
    """
    res: list = []
    for x in bay:
        res.append(
            sum(
                y.weight if is_dataclass(y) else y for y in x
            )
        )
    return res.index(min(res))


def get_min_tier_index(row: list) -> int:
    """ Description of get_min_tier_index()
    This function takes a list as arg and returns the min index position of the list.

    Arg:
        row (list): The list to get the min index from.

    Return:
        converted (int): The index of the min position.
    """
    converted: list = [y.weight if is_dataclass(y) else y for y in row]
    return converted.index(min(converted))
