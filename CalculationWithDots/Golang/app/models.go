package calculationwithdots

// Point struct
type Point struct {
	Name            string
	X               float64
	Y               float64
}

// Distance struct
type Distance struct {
	Primary         Point
	Secondary       Point
	Value           float64
}
