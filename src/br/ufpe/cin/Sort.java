package br.ufpe.cin;

import br.ufpe.cin.heap.Heap;
import br.ufpe.cin.heap.MaxHeap;
import br.ufpe.cin.heap.MinHeap;

public class Sort {

	public static int[] heapSort(int array[], SortOrder order) {
		Heap heap;
		if(order == SortOrder.DESCENDING) {
			heap = new MaxHeap(array);
		} else {
			heap = new MinHeap(array);
		}
		
		return heap.sort();
	}

}
