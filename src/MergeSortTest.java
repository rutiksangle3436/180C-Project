import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ForkJoinPool;
import java.util.*;

import org.junit.jupiter.api.Test;

class MergeSortTest {
     
	@Test
	void test() {
		System.out.println("\nTestCase"); 
		    int SIZE = 200;
	        ArrayList<Integer> myList = new ArrayList<>();//(Arrays.asList(1,3,5,7,2,6,3));

	        System.out.print("\nBefore sorting ");
	        for (int i = 0; i < SIZE; i++) {
	            int value = (int) (Math.random() * SIZE);
	            myList.add(value);
	            System.out.print(" " +myList.get(i));
	        } 
	        System.out.println(" ");
	        ArrayList<Integer> slist=myList;

	        MergeSort<Integer> ob = new MergeSort<Integer>(myList);
	        ForkJoinPool forkJoinPool = new ForkJoinPool();

            forkJoinPool.invoke(new MergeSort<Integer>(myList, 0, myList.size() - 1));
            
	        //assertEquals(3,3);
            ArrayList<Integer> arraySorted= ob.getArrayAfterSorting();
            Collections.sort(slist);
            System.out.print("\nSorted array ");
            for(int i=0;i<arraySorted.size();i++) {
            	
            	 System.out.print(arraySorted.get(i)+" ");
            	assertEquals(slist.get(i),arraySorted.get(i));
            }
                
                
               
            } 
	
	
	
//another test case
	@Test
	void testtwo() {
		System.out.println("\nTestCase"); 
	    int SIZE = 200;
        ArrayList<Integer> myList = new ArrayList<>();//(Arrays.asList(-1,0,-9,7,2,6,3));

        System.out.print("\nBefore sorting ");
        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * SIZE);
            myList.add(value);
            System.out.print(" " +myList.get(i));
        } 
        myList.add(-1);
        myList.add(0);
        
        System.out.println(" ");
        ArrayList<Integer> slist=myList;

        MergeSort<Integer> ob = new MergeSort<Integer>(myList);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new MergeSort<Integer>(myList, 0, myList.size() - 1));
        
        //assertEquals(3,3);
        ArrayList<Integer> arraySorted= ob.getArrayAfterSorting();
        Collections.sort(slist);
        System.out.print("\nSorted array ");
        for(int i=0;i<arraySorted.size();i++) {
        	
        	 System.out.print(arraySorted.get(i)+" ");
        	assertEquals(slist.get(i),arraySorted.get(i));
        }
            
            
	
	}
	
	@Test
	void testthree() {
		System.out.println("\nTestCase"); 
	    int SIZE = 10;
        ArrayList<Integer> myList = new ArrayList<>();//(Arrays.asList(-1,0,-9,7,2,6,3));
        myList.add(-9);
        myList.add(-2);
        System.out.print("\nBefore sorting ");
        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * SIZE);
            myList.add(value);
            System.out.print(" " +myList.get(i));
        } 
        
        
        System.out.println(" ");
        ArrayList<Integer> slist=myList;

        MergeSort<Integer> ob = new MergeSort<Integer>(myList);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new MergeSort<Integer>(myList, 0, myList.size() - 1));
        
        //assertEquals(3,3);
        ArrayList<Integer> arraySorted= ob.getArrayAfterSorting();
        Collections.sort(slist);
        System.out.print("\nSorted array using Selection Sort ");
        for(int i=0;i<arraySorted.size();i++) {
        	
        	 System.out.print(arraySorted.get(i)+" ");
        	assertEquals(slist.get(i),arraySorted.get(i));
        }
            
            
	
	}
	
}