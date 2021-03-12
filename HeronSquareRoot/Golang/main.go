package main

import (
	"fmt"
	"math"
)

func main() {
	var radiant float64 = 131

	const e float64 = 0.0000001
	var z float64 = 100.0

	step := func() float64 { return z - (z*z - radiant) / (2 * z) }

	for zz := step(); math.Abs(zz - z) > e
	{
		z = zz
		zz = step()
	}

	fmt.Printf("The square root of %f is %.3f !", radiant, z)
}
