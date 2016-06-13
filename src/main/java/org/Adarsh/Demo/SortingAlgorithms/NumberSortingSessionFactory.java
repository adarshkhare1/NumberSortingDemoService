/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Adarsh.Demo.SortingAlgorithms;

/**
 *
 * @author adkhare
 */
public class NumberSortingSessionFactory {
    public static NumberSortingSession CreateSortingSession(String algorithmId, int[] numbers)
    {
        switch(algorithmId)
        {
            case BubbleSortingSession.ALGORITHM_ID:
                return new BubbleSortingSession(numbers); 
             case MergeSortingSession.ALGORITHM_ID:
                return new MergeSortingSession(numbers);
        }
        throw new UnsupportedOperationException();
    }
    
}
