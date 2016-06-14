package org.Adarsh.Demo.SortingAlgorithms;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adkhare
 */
public abstract class NumberSortingSession
{

    private String sessionId;
    private String algorithmId;
    private int[] numbers;

    private boolean completed = false;
    private boolean started = false;
    private final Object monitor = new Object();
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    public NumberSortingSession(String algorithmId, int[] numbers)
    {
        this.algorithmId = algorithmId;
        if (numbers != null)
        {
            this.numbers = numbers;
        }
        else
        {
            //generate a random number array if none specified
            this.numbers = this.generateNumbersArray(100, 0, 10000);
        }
    }

    public String getSessionId()
    {
        return sessionId;
    }

    /**
     * Get the value of algorithmId
     *
     * @return the value of algorithmId
     */
    public final String getAlgorithmId()
    {
        return algorithmId;
    }

    /**
     * Set the value of algorithmId
     *
     * @param algorithmId new value of algorithmId
     */
    protected final void setAlgorithmId(String algorithmId)
    {
        this.algorithmId = algorithmId;
    }

    public final int[] getNumbers()
    {
        return numbers;
    }

    protected final void setNumbers(int[] numbers)
    {
        this.numbers = numbers;
    }

    public abstract void executeSortingIteration();

    public final boolean isCompleted()
    {
        return completed;
    }

    public final void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public final boolean isStarted()
    {
        return started;
    }

    public final void setStarted(boolean started)
    {
        this.started = started;
    }

    protected final void startSession(Callable<Boolean> method)
    {
        executorService.submit(method);
    }

    protected final void resumeSession()
    {
        synchronized (monitor)
        {
            monitor.notify();
        }

    }

    protected final void pauseSession()
    {
        synchronized (monitor)
        {
            try
            {
                monitor.wait();
            } 
            catch (InterruptedException ex)
            {
                Logger.getLogger(MergeSortingSession.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private int[] generateNumbersArray(int size, int min, int max)
    {
        int[] numberList = new int[size];
        Random generator = new Random();
        for (int i = 0; i < 100; i++)
        {
            numberList[i] = generator.nextInt(max);
        }
        return numberList;
    }
}
