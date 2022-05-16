package src.util;

import src.sort.SalaryDTO;

import java.util.ArrayList;

public class QuicksortGeneric<T extends Comparable<? super T>> {

    public void quicksort(ArrayList<T> array, int startIndex, int endIndex)
    {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex)
        {
            // calculate the pivotIndex
            int pivotIndex = partition(array, startIndex, endIndex);
            // sort the left sub-array
            quicksort(array, startIndex, pivotIndex);
            // sort the right sub-array
            quicksort(array, pivotIndex + 1, endIndex);
        }
    }
    private int partition(ArrayList<T> array, int startIndex, int endIndex)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array.get(pivotIndex);
        startIndex--;
        endIndex++;
        while (true)
        {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (array.get(startIndex).compareTo(pivotValue) < 0) ;

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (array.get(endIndex).compareTo(pivotValue) > 0) ;

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = array.get(startIndex);
            array.set(startIndex, array.get(endIndex));
            array.set(endIndex, temp);
        }
    }
}