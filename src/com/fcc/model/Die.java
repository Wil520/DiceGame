package com.fcc.model;

import java.util.Random;

/**
 * Represents a single die in the dice game for generating random values when rolled.
 */
public class Die {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_SIDES = 6;
    
    private final int sides;
    private int value;
    
 
    public Die() {
        this(DEFAULT_SIDES);
    }
    
 
    public Die(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("A die must have at least 1 side");
        }
        this.sides = sides;
        roll();
    }
    
    /**
     * Rolls the die to generate a new random value.
     * 
     * @return the new value of the die
     */
    public int roll() {
        value = RANDOM.nextInt(sides) + 1;
        return value;
    }
    
    
    public int getValue() {
        return value;
    }
} 