package com.fcc.game;

import com.fcc.model.Die;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the logic for the dice game.
 */
public class DiceGame {
    private static final int SPECIAL_NUMBER = 3;
    
    private final int numberOfDice;
    

    public DiceGame(int numberOfDice) {
        if (numberOfDice < 1) {
            throw new IllegalArgumentException("Game must have at least 1 die");
        }
        this.numberOfDice = numberOfDice;
    }
    
    
    public int play() {
        List<Die> dice = initializeDice();
        int totalScore = 0;
        
        while (!dice.isEmpty()) {
            // Roll all remaining dice
            rollAllDice(dice);
            
            // Calculate score for this roll
            int rollScore = calculateRollScore(dice);
            totalScore += rollScore;
        }
        
        return totalScore;
    }
    

    private List<Die> initializeDice() {
        List<Die> dice = new ArrayList<>(numberOfDice);
        for (int i = 0; i < numberOfDice; i++) {
            dice.add(new Die());
        }
        return dice;
    }
    
    private void rollAllDice(List<Die> dice) {
        for (Die die : dice) {
            die.roll();
        }
    }
    
    /**
     * Calculates the score for the current roll and removes appropriate dice.
     * 
     * @param dice the current list of dice
     * @return the score for this roll
     */
    private int calculateRollScore(List<Die> dice) {
        // Check if there are any 3's
        List<Die> threes = new ArrayList<>();
        for (Die die : dice) {
            if (die.getValue() == SPECIAL_NUMBER) {
                threes.add(die);
            }
        }
        
        if (!threes.isEmpty()) {
            // Remove all 3's and score 0
            dice.removeAll(threes);
            return 0;
        } else {
            // Find and remove the lowest die
            Die lowestDie = findLowestDie(dice);
            dice.remove(lowestDie);
            return lowestDie.getValue();
        }
    }
    

    private Die findLowestDie(List<Die> dice) {
        Die lowest = dice.get(0);
        for (Die die : dice) {
            if (die.getValue() < lowest.getValue()) {
                lowest = die;
            }
        }
        return lowest;
    }
} 