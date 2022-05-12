import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ForkJoinPool;
import java.util.*;

import org.junit.jupiter.api.Test;

class QuickSortTest {
     
	@Test
	void test() {
	      final int SIZE = 101;
	      
	        List<Integer> myList = new ArrayList<Integer>(SIZE);
	        System.out.println("\nBefore sorting");
	        for (int i=0; i<SIZE; i++){
	            int value = (int) (Math.random() * 100);
	            myList.add(value);
	            System.out.print(" "+myList.get(i));
	        } 
	        List<Integer> sortlist=myList;
	        
	        if(SIZE<=100) {
	        	SelectionSort o = new SelectionSort(myList);
	        	o.sortGivenArray();
	        	for (int i=0; i<SIZE; i++){
	        		System.out.print(" " + myList.get(i));
	        	}	
	        }
	        else { 
	        	Collections.sort(sortlist);
	            long start = System.nanoTime();

		        QuickSort<Integer> quickSort = new QuickSort<Integer>(myList);
		        ForkJoinPool pool = new ForkJoinPool();
		        pool.invoke(quickSort);
	            long end = System.nanoTime();
	        	System.out.println("\nsorted list Using Quick sort");

		        for (int i=0; i<SIZE; i++){
		            System.out.print(" "+myList.get(i));
		            assertEquals(sortlist.get(i), myList.get(i));
		        }
	            System.out.println(String.format("%f [msec]", (end - start) / 1000000.0));

	        }
                
                
               
            } 
	
	@Test
	void testTwo() {
	      final int SIZE = 50;
	      
	        List<Integer> myList = new ArrayList<Integer>(SIZE);
	        System.out.println("\nBefore sorting");
	        for (int i=0; i<SIZE; i++){
	            int value = (int) (Math.random() * 100);
	            myList.add(value);
	            System.out.print(" "+myList.get(i));
	        } 
	        List<Integer> sortlist=myList;
	        
	        if(SIZE<=100) {
	        	Collections.sort(sortlist);
	        	SelectionSort o = new SelectionSort(myList);
	        	o.sortGivenArray();
	        	System.out.println("\nsorted list Using Selection sort");
	        	for (int i=0; i<SIZE; i++){
	        		System.out.print(" " + myList.get(i));
	        	}	
	        }
	        else { 
	        	Collections.sort(sortlist);
	            long start = System.nanoTime();

		        QuickSort<Integer> quickSort = new QuickSort<Integer>(myList);
		        ForkJoinPool pool = new ForkJoinPool();
		        pool.invoke(quickSort);
	            long end = System.nanoTime();
                System.out.println("\nsorted list");
		        for (int i=0; i<SIZE; i++){
		            System.out.print(" "+ myList.get(i));
		            assertEquals(sortlist.get(i), myList.get(i));
		        }
	            System.out.println(String.format("%f [msec]", (end - start) / 1000000.0));

	        }
	
	
	

	
}
	}