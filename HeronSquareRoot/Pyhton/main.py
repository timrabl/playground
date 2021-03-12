#!/usr/bin/env python3
""" Description of main.py """

import sys


def main():
    radiant: float = 131

    if radiant < 0:
        print(f"Invalid Radiant {radiant} !")
        sys.exit(2)

    hlp: float = radiant
    e: float = 0.000000001

    while abs(hlp - (radiant / hlp )) / hlp > e:
        hlp = ( radiant / hlp + hlp) / 2

    print(float("{:.3f}".format(hlp)))


if __name__ == "__main__":
    main()
