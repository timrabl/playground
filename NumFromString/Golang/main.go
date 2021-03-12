package main

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

// parse function
func parse(compiled *regexp.Regexp, string string) (value float64, err error) {
	matches := compiled.FindAllString(string, -1)
	joined := strings.Join(matches[:], " ")
	replaced := strings.ReplaceAll(joined, ",", ".")
	floated, err := strconv.ParseFloat(replaced, 64)
	if err != nil {
		return 0.0, err
	}
	return floated, nil
}

// main function
func main() {
	pattern := "([+-])?([0-9]*[.,])?([0-9]+)"
	rgx := regexp.MustCompile(pattern)

	var values []string = []string{
		"x5y", "x5,y", "x5,01y", "x,53y", "x050y", "x00,03y", "x5,0y",
	}

	for _, element := range values {
		result, err := parse(rgx, element)
		if err != nil {
			panic("An error occurred, while processing a value !")
		}

		fmt.Printf("Extracted floating point number of: '%s' is: '%.5f' !\n", element, result)
	}
}
