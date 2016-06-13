/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Adarsh.Demo.SortingAlgorithms;

import java.util.Random;

/**
 *
 * @author adkhare
 */
public abstract class NumberSortingSession {
    private String sessionId;
    private String algorithmId;
    private int[] numbers;

    public NumberSortingSession(String algorithmId, int[] numbers) {
        this.algorithmId = algorithmId;
        if(numbers != null)
        {
            this.numbers = numbers;
        }
        else
        {
            //generate a random number array if none specified
            this.numbers = this.generateNumbersArray(100, 0, 10000);
        }
    }

    public String getSessionId() {
        return sessionId;
    }

    /**
     * Get the value of algorithmId
     *
     * @return the value of algorithmId
     */
    public String getAlgorithmId() {
        return algorithmId;
    }

    /**
     * Set the value of algorithmId
     *
     * @param algorithmId new value of algorithmId
     */
    protected void setAlgorithmId(String algorithmId) {
        this.algorithmId = algorithmId;
    }

    public int[] getNumbers() {
        return numbers;
    }

    protected void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    
    public abstract void executeSortingIteration();

    
    private int[] generateNumbersArray(int size, int min, int max) 
    {
        int[] numberList = new int[size];
        Random generator = new Random();
        for(int i =0; i < 100; i++)
        {
            numberList[i] = generator.nextInt(max);
        }
        return numberList;
    }   
}
