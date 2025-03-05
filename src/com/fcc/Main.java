package com.fcc;

import com.fcc.simulation.GameSimulator;
import com.fcc.simulation.SimulationResult;

/**
 * Main class to run the dice game simulation.
 */
public class Main {
    private static final int DEFAULT_SIMULATIONS = 10000;
    private static final int DEFAULT_DICE = 5;
    
    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create and run the simulation
        GameSimulator simulator = new GameSimulator(DEFAULT_SIMULATIONS, DEFAULT_DICE);
        double timeTaken = simulator.runSimulation();
                
        SimulationResult result = new SimulationResult(
            simulator.getNumberOfSimulations(),
            simulator.getNumberOfDice(),
            simulator.getScoreFrequency(),
            timeTaken
        );
        
        result.printResults();
    }
} 