import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

 
public class QuickSort<T extends Comparable> extends RecursiveAction {
 
    private List<T> data;
    private int left;
    private int right;
 
    public QuickSort(List<T> data){
        this.data = data;
        this.left = 0;
        this.right = data.size() - 1;
    }
 
    public QuickSort(List<T> data, int left, int right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
 
    @Override
    protected void compute() 
    {
        if (left < right)
        {
            int pivotIndex = left + ((right - left)/2);
 
            pivotIndex = partition(pivotIndex);
 
            invokeAll(new QuickSort(data, left, pivotIndex-1),
                      new QuickSort(data, pivotIndex+1, right));
        }
 
    }
 
    private int partition(int pivotIndex)
    {
        T pivotValue = data.get(pivotIndex);
 
        swap(pivotIndex, right);
 
        int storeIndex = left;
        for (int i=left; i<right; i++)
        {
            if (data.get(i).compareTo(pivotValue) < 0)
            {
                swap(i, storeIndex);
                storeIndex++;
            }
        }
 
        swap(storeIndex, right);
        return storeIndex;
    }
 
    private void swap(int i, int j){
        if (i != j){
            T iValue = data.get(i);
 
            data.set(i, data.get(j));
            data.set(j, iValue);
        }
    }
    
    public static void main(String[] args) {
        final int SIZE = 100000 ;
 
        List<Integer> myList = new ArrayList<Integer>(SIZE);
 
        for (int i=0; i<SIZE; i++){
            int value = (int) (Math.random() * 500);
            myList.add(value);
        }
        QuickSort<Integer> quickSort = new QuickSort<Integer>(myList);

        if(SIZE<=100) {
        	SelectionSort o = new SelectionSort(myList);
        	o.sortGivenArray();
        	for (int i=0; i<SIZE; i++){
        		System.out.print(" " + myList.get(i));
        	}	
        }
        else {
            long start = System.nanoTime();
	        ForkJoinPool pool = new ForkJoinPool();
	        pool.invoke(quickSort);
            long end = System.nanoTime();

	        for (int i=0; i<SIZE; i++){
	            System.out.println(myList.get(i));
	        }
            System.out.println(String.format("%f [msec]", (end - start) / 1000000.0));

        }
    }
}
