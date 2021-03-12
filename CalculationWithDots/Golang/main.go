package main

import (
	"timrabl/calculationwithdots/app"
)

func main() {
	p := new(calculationwithdots.Point)
	p.SetName("P")
	p.SetCoordinates(-2, 1)

	q := new(calculationwithdots.Point)
	q.SetName("Q")
	q.SetCoordinates(3, 5)

	distanceStatic := new(calculationwithdots.Distance)
	distanceStatic.GetDistance(*p, *q)
	distanceStatic.PrintDistance()

	distanceDynamic := new(calculationwithdots.Distance)
	distanceDynamic.GetDistanceFromUser()
	distanceDynamic.PrintDistance()
}