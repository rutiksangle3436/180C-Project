import java.util.ArrayList;
import java.util.concurrent.*;

public class MergeSort<N extends Comparable> extends RecursiveAction {

    int indexStart;
    int indexEnd;
    int arr[];

    private final ArrayList<Integer> arrayToSort;

    public MergeSort(ArrayList<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public MergeSort(ArrayList<Integer> arr, int low, int high) {
        this.arrayToSort = arr;
        this.indexStart = low;
        this.indexEnd = high;
    }

    public ArrayList<Integer> getArrayAfterSorting() {
        return arrayToSort;
    }

    @Override
    protected void compute() {
    	
        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) 
        {
            int middleElement = (indexEnd + indexStart) / 2;
            MergeSort<Integer> left = new MergeSort<Integer>(arrayToSort, indexStart, middleElement);
            MergeSort<Integer> right = new MergeSort<Integer>(arrayToSort, middleElement + 1, indexEnd);
            invokeAll(left, right);
            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
        
    }

    // MERGE CODE
    
    
    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) 
    {
        ArrayList<Integer> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) 
        {
            if (arrayToSort.get(getLeftIndex).compareTo((arrayToSort.get(getRightIndex))) <= 0) 
            {
                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;
            } 
            else 
            {
                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;
            }
        }
        while (getLeftIndex <= indexMiddle) 
        {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }
        while (getRightIndex <= indexEnd) 
        {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }
        for (int i = 0; i < tempArray.size(); indexStart++) 
        {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }

    // MAIN
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int SIZE = 100000;
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * SIZE);
            myList.add(value);
        }

        MergeSort<Integer> ob = new MergeSort<Integer>(myList);

        System.out.println("Array Before Sort: ");

        for (Integer integer : ob.getArrayAfterSorting()) {
            System.out.println(integer);
        }
        if (SIZE <= 100) {
            SelectionSort o = new SelectionSort(myList);
            o.sortGivenArray();
            System.out.println("Array After Selection Sort: ");
            for (int i = 0; i < SIZE; i++) {
                System.out.println(myList.get(i));
            }
        }

        else {
            long start = System.nanoTime();

            ForkJoinPool forkJoinPool = new ForkJoinPool();

            forkJoinPool.invoke(new MergeSort<Integer>(myList, 0, myList.size() - 1));
            long end = System.nanoTime();

            System.out.println("Array After Merge Sort: ");
            for (Integer integer : ob.getArrayAfterSorting()) {
                System.out.println(integer);
            }
            System.out.println(String.format("%f [msec]", (end - start) / 1000000.0));
        }
    }
}
