package src.sort;


import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    private static ArrayList<Salary> inputArray = new ArrayList<Salary>();

    public QuickSort(ArrayList<Salary> inputArray){
        QuickSort.inputArray = inputArray;
    }

    public void startQuickStart(int start,int end){
        int q;
        if(start<end){
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q+1, end);
        }
    }

    public ArrayList<Salary> getSortedArray(){
        return QuickSort.inputArray;
    }

    int partition(int start,int end){

        int init = start;
        int length = end;

        Random r = new Random();
        int pivotIndex = nextIntInRange(start,end,r);
        int pivot = inputArray.get(pivotIndex).getSalary();
        while(true){
            while(inputArray.get(length).getSalary() > pivot && length>start){
                length--;
            }

            while(inputArray.get(init).getSalary() < pivot && init < end){
                init++;
            }

            if(init<length){
                Salary temp;
                temp = inputArray.get(init);
                inputArray.set(init,inputArray.get(length));
                inputArray.set(length,temp);
                length--;
                init++;

                for(int i=start;i<=end;i++){
                    System.out.print(inputArray.get(i)+" ");
                }
            }else{
                return length;
            }
        }

    }

    static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }
}