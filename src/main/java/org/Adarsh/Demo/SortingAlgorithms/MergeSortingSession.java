package org.Adarsh.Demo.SortingAlgorithms;

import java.util.concurrent.Callable;

/**
 *
 * @author adkhare
 */
public class MergeSortingSession extends NumberSortingSession
{

    public static final String ALGORITHM_ID = "MergeSort";
    private final int[] tempMergArr;
    
    public MergeSortingSession(int[] numbers)
    {
        super(ALGORITHM_ID, numbers);
        this.tempMergArr = new int[this.getNumbers().length];
    }

    @Override
    public void executeSortingIteration()
    {
        if (!this.isCompleted())
        {
            if (this.isStarted())
            {
                this.resumeSession();
            }
            else
            {
                final MergeSortingSession session = this;
                this.startSession(new Callable<Boolean>()
                {
                    @Override
                    public Boolean call() throws Exception
                    {
                        int length = session.getNumbers().length;
                        doMergeSort(session.getNumbers(), 0, length - 1);
                        session.setCompleted(true);
                        return session.isCompleted();
                    }
                });
            }
        }
    }

    private void doMergeSort(int[] array, int lowerIndex, int higherIndex)
    {

        if (lowerIndex < higherIndex)
        {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(array, lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(array, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(array, lowerIndex, middle, higherIndex);
            this.pauseSession();
        }
    }

    private void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex)
    {
        for (int i = lowerIndex; i <= higherIndex; i++)
        {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex)
        {
            if (tempMergArr[i] <= tempMergArr[j])
            {
                array[k] = tempMergArr[i];
                i++;
            }
            else
            {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle)
        {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
