#!/usr/bin/env python3
""" This is the exceptions file foi the CalculationsWithDots project """


class InvalidName(Exception):
    """ Description of InvalidName
    This Exception class is raised, if the given name is invalid.
    """
    pass


class InvalidCoordinate(Exception):
    """ Description of InvalidCoordinate
    This Exception class is raised, if the given coordinate is invalid.
    """
    pass