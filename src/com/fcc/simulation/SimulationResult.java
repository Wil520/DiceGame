package com.fcc.simulation;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents the results of a dice game simulation and provides methods to format and display the results.
 */
public class SimulationResult {
    private final int numberOfSimulations;
    private final int numberOfDice;
    private final Map<Integer, Integer> scoreFrequency;
    private final double timeTaken;
    

    public SimulationResult(int numberOfSimulations, int numberOfDice, 
                           Map<Integer, Integer> scoreFrequency, double timeTaken) {
        this.numberOfSimulations = numberOfSimulations;
        this.numberOfDice = numberOfDice;
        this.scoreFrequency = new TreeMap<>(scoreFrequency); // Sort by score
        this.timeTaken = timeTaken;
    }
    

    public String formatResults() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("Number of simulations was %d using %d dice.\n", 
                               numberOfSimulations, numberOfDice));
        
        for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
            int score = entry.getKey();
            int frequency = entry.getValue();
            double proportion = (double) frequency / numberOfSimulations;
            
            sb.append(String.format("Total %d occurs %.2f occurred %.1f times.\n", 
                                   score, proportion, (double) frequency));
        }
        
        sb.append(String.format("Total simulation took %.1f seconds.", timeTaken));
        
        return sb.toString();
    }
    
    public void printResults() {
        System.out.println(formatResults());
    }
} 