package parrot

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFoo(t *testing.T) {
	parrot := CreateParrot(TypeEuropean, 0, 0, false)
	speed, _ := parrot.Speed()
	assert.Equal(t, 0.0, speed)
}
