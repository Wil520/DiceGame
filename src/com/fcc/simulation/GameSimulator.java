package com.fcc.simulation;

import com.fcc.game.DiceGame;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates multiple iterations of the dice game and collects statistics.
 */
public class GameSimulator {
    private final int numberOfSimulations;
    private final int numberOfDice;
    private final Map<Integer, Integer> scoreFrequency;
    
    
    public GameSimulator(int numberOfSimulations, int numberOfDice) {
        if (numberOfSimulations < 1) {
            throw new IllegalArgumentException("Number of simulations must be at least 1");
        }
        if (numberOfDice < 1) {
            throw new IllegalArgumentException("Number of dice must be at least 1");
        }
        
        this.numberOfSimulations = numberOfSimulations;
        this.numberOfDice = numberOfDice;
        this.scoreFrequency = new HashMap<>();
    }
    

    public double runSimulation() {
        long startTime = System.nanoTime();
        
        for (int i = 0; i < numberOfSimulations; i++) {
            DiceGame game = new DiceGame(numberOfDice);
            int score = game.play();
            
            // Update score frequency
            scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
        }
        
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }
    
    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }
    

    public int getNumberOfDice() {
        return numberOfDice;
    }
    

    public Map<Integer, Integer> getScoreFrequency() {
        return new HashMap<>(scoreFrequency);
    }
} 