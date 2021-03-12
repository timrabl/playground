package calculationwithdots

import (
	"regexp"
	"math"
	"fmt"
	"bufio"
	"os"
)

// setName function
func (p *Point) SetName(name string) {
	if len(name) > 1 {
		panic("Point name is too long !")
	}

	rgx := regexp.MustCompile("^[A-Za-z0-9]$")
	if ! rgx.MatchString(name) {
		panic("Invalid char forpoint name !")
	}

	p.Name = name
}

// SetCoordinates function
func (p *Point) SetCoordinates(x float64, y float64) {
	if math.IsNaN(x) {
		panic(fmt.Sprintf("Infinite float: %d are not allowed !", x))
	}

	if math.IsNaN(y) {
		panic(fmt.Sprintf("Infinite float: %d are not allowed !", y))
	}

	p.X = x
	p.Y = y
}

// GetDistanceFromUser function
func (d *Distance) GetDistanceFromUser() {
	d.Primary = d.askForCoordinate("A")
	d.Secondary = d.askForCoordinate("B")
	d.GetDistance(d.Primary, d.Secondary)
}

// askForCoordinate function
func (d *Distance) askForCoordinate(name string) (point Point) {
	point.SetName(name)

	var x float64
	var y float64

	reader := bufio.NewReader(os.Stdin)

	fmt.Printf("X coordinate for point: %s\n>> ", name)
	_, err := fmt.Fscan(reader, &x)
	if err != nil {
		panic(fmt.Sprintf("Error while scanning X coordinate for point %s", name))
	}

	fmt.Printf("Y coordinate for point: %s\n>> ", name)
	_, err = fmt.Fscan(reader, &y)
	if err != nil {
		panic(fmt.Sprintf("Error while scanning Y coordinate for point %s", name))
	}

	point.SetCoordinates(float64(x), float64(y))

	return point
}

// GetDistance function
func (d *Distance) GetDistance(primary Point, secondary Point) {
	d.Primary = primary
	d.Secondary = secondary

	var ac float64 = math.Abs(d.Primary.X - d.Primary.Y)
	var cb float64 = math.Abs(d.Secondary.X - d.Secondary.Y)

	d.Value = math.Hypot(ac, cb)
}

// PrintDistance function
func (d *Distance) PrintDistance() {
	fmt.Printf("Distance between: %s and %s is: %f !\n", d.Primary.Name, d.Secondary.Name, d.Value)
}