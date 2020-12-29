package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Coordinate struct {
    x int
    y int
}

type CoordList struct {
    list []Coordinate
}

type Polygon struct {
    area float64
    scope float64
    Points CoordList
}

func area(lst CoordList) float64 {
    for coord := range lst {
       fmt.Println(coord)
    }
    return 0
}


func read(question string, start string) int {
    reader := bufio.NewReader(os.Stdin)

    fmt.Println(question)
    fmt.Printf(start)

    reares, _ := reader.ReadString('\n')
    repres := strings.Replace(reares, "\n", "", -1)

    atores, err := strconv.Atoi(repres)
    if err != nil {
        fmt.Println(err)
        os.Exit(13)
    }

    return atores
}

func main() {
    res := read("Polygon with how much corners ?", ">>> ")

    var lst []CoordList

    for corner := range []res {
        coord == Coordinate{
            x: read("X coordinate: ", ">>> "),
            y: read("Y coordinate: ", ">>> ")
        }

        append(lst, coord)
    }
}
