#!/usr/bin/env python3
""" This is the dataclasses module from the CalculationWithDots project. """

import sys
import re
import math

from dataclasses import dataclass
from src.exceptions import InvalidName, InvalidCoordinate


@dataclass
class Point:
    """ Description of class Point
    """
    name: str = ""
    x: float = 0.0
    y: float = 0.0

    @staticmethod
    def _checkName_(name: str) -> bool:
        """ Description of _checkName_()
        This functions validates the name and return a boolean value.

        Args:
            - name (str): The name to validate.

        Return:
            - _ (bool): The boolean value.

        """
        if len(name) > 1:
            return False

        rgx = re.compile(r"^[A-Za-z0-9]$")
        if not rgx.match(name):
            return False

        return True

    @staticmethod
    def _checkCoordinate_(coordinate: float) -> bool:
        """ Description of _checkCoordinate_()
        This function validates a single coordinate.
        If the Coordinate is infinite, the assertion fails.

        Args:
            - coordinate (float): The coordinate that should be validated.

        Return:
            - _ (bool): The boolean value.

        """
        if math.isinf(coordinate):
            return False

        return True

    def setName(self, name: str):
        """ Description of setName()
        This function sets the name of the instance (this.name) to the provided
        name, if it passed the _checkName_ validator fucntion.

        Args:
            - name (str): The name of the Point.

        """
        if not self._checkName_(name):
            raise InvalidName from AssertionError

        self.name = name

    def _setX_(self, x: float):
        """ Description of _setX_()
        This function sets the X coordinate of this instance.

        Args:
            - x (float): The X coordinate to set.

        """
        self.x = x

    def _setY_(self, y: float):
        """ Description of _setY_()
        This function sets the Y coordinate of this instance.

        Args:
            - y (float): The Y coordinate to set.

        """
        self.y = y

    def setCoordinates(self, x: float, y: float):
        """ Description of setCoordinates()
        This function sets the coordinates of point instance, after they
        passed the validator function.

        Args:
            - x (float): The X coordinate of the Point.
            - y (float): The Y coordinate of the Point.

        """

        if not self._checkCoordinate_(x):
            raise InvalidCoordinate from AssertionError

        if not self._checkCoordinate_(y):
            raise InvalidCoordinate from AssertionError

        self._setX_(x)
        self._setY_(y)

@dataclass
class Distance:
    """ Description of data class Distance
    """
    primary: Point = Point()
    secondary: Point = Point()
    distance: float = 0.0

    def getDistanceFromUser(self):
        """ Description of getDistanceFromUser()
        This function calls the interactive call function and
        calculates the distance from this result.

        """

        self.primary: Point = self._askForCoordinates_("A")
        self.secondary: Point = self._askForCoordinates_("B")
        self.getDistance(self.primary, self.secondary)

    def _askForCoordinates_(self, name: str) -> Point:
        """ Description of _askForCoordinates_()
        This function initializes a new Point and asks the user for
        the X and Y coordinate of this point.

        Args:
            - name (str): The name of the coordinate.

        Return:
            - point (Point): The Point instance.

        """
        point: Point = Point()

        try:
            point.setName(name)
        except InvalidName:
            sys.exit(2)

        try:
            x: float = float(input("X coordinate for point: " + name + "\n>> "))
        except ValueError:
            raise InvalidCoordinate

        try:
            y: float = float(input("Y coordinate for point: " + name + "\n>> "))
        except ValueError:
            raise InvalidCoordinate

        try:
            point.setCoordinates(x, y)
        except InvalidCoordinate:
            sys.exit(2)

        return point

    def getDistance(self, primary: Point, secondary: Point):
        """ Description of _getDistance_()
        This function calculates the distance between two given Point instances.

        Args:
            - primary (Point): The first coordinate.
            - secondary (Point): The second coordinate.

        """
        self.primary: Point = primary
        self.secondary: Point = secondary

        ac: float = abs(self.secondary.x - self.primary.x)
        cb: float = abs(self.secondary.y - self.primary.y)

        self.distance: float = math.hypot(ac, cb)

    def printDistance(self):
        """ Description of printDistance()
        This function print the distance ( formatted ) to the CLI.

        """
        print("Distance between: " + self.primary.name + " and "
              + self.secondary.name + " is: " + str(self.distance))
