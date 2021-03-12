#!/usr/bin/env pyhton3
""" Description of main.py """

import re


def parse(group) -> float:
    """ Description of parse()
    This function takes a regex capture group and extracts any floating point number as a string, replace comma
    separator with a dot and return the floating point number as a float.

    Args:
        - group (tuple): The regex capture group.

    Return:
        - _ (float): The extracted floating point number.
    """
    buffer: str = ""
    for index in range(len(group)):
        hlp: str = group[index]

        if not hlp:
            continue

        buffer = buffer + hlp

    return float(buffer.replace(",", "."))


def main():
    rgp = re.compile('([+-])?([0-9]*[.,])?([0-9]+)')
    values: list = ["x5y", "x5,y", "x5,01y", "x,53y", "x050y", "x00,03y", "x5,0y"]

    for string in values:
        matching: list = rgp.findall(string)
        for group in matching:
            print(f"Found: {repr(parse(group))} for given string: {repr(string)}")


if __name__ == "__main__":
    main()
