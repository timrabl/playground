#/usr/bin/env python3

import sys

from src.dataclasses import Point, Distance
from src.exceptions import InvalidName, InvalidCoordinate


def main():
    """ Description of main()
    This is the main function, which handles the execution and instance creation.
    """

    p: Point = Point()
    try:
        p.setName("P")
    except InvalidName:
        sys.exit(1)

    try:
        p.setCoordinates(-2, 1)
    except InvalidCoordinate:
        sys.exit(1)

    q: Point = Point("q", 3, 5)

    try:
        q.setName("Q")
    except InvalidName:
        sys.exit(1)

    try:
        q.setCoordinates(3, 5)
    except InvalidCoordinate:
        sys.Exit(1)

    distanceStatic: Distance = Distance()
    distanceStatic.getDistance(p, q)
    distanceStatic.printDistance()

    distanceDynamic: Distance = Distance()
    distanceDynamic.getDistanceFromUser()
    distanceDynamic.printDistance()


if __name__ == "__main__":
    main()
