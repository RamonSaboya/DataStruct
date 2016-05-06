package br.ufpe.cin;

import br.ufpe.cin.heap.Heap;
import br.ufpe.cin.heap.MaxHeap;
import br.ufpe.cin.heap.MinHeap;

public class Sort {

	public static int[] heapSort(int array[], SortOrder order) {
		Heap heap;
		if (order == SortOrder.ASCENDING) {
			heap = new MaxHeap(array);
		} else {
			heap = new MinHeap(array);
		}

		return heap.sort();
	}

	public static int[] mergeSort(int array[], SortOrder order) {
		int temp[] = new int[array.length];
		return mergeSort(array, temp, 0, array.length - 1, order);
	}

	private static int[] mergeSort(int array[], int temp[], int start, int end, SortOrder order) {
		if (start == end) {
			return array;
		}

		mergeSort(array, temp, start, (end + start) / 2, order);
		mergeSort(array, temp, (end + start) / 2 + 1, end, order);

		merge(array, temp, start, (end + start) / 2 + 1, (end - start) + 1, order);

		return array;
	}

	private static void merge(int array[], int temp[], int lStart, int rStart, int length, SortOrder order) {
		int i = lStart, l = lStart, r = rStart;

		while ((l < rStart) && (r < (lStart + length))) {
			if (order.compare(array[l], array[r])) {
				temp[i++] = array[l++];
			} else {
				temp[i++] = array[r++];
			}
		}

		while (l < rStart) {
			temp[i++] = array[l++];
		}
		while (r < (lStart + length)) {
			temp[i++] = array[r++];
		}

		for (int c = 0; c < length; c++, lStart++) {
			array[lStart] = temp[lStart];
		}
	}
	
	public static int[] quickSort(int array[]) {
		return quickSort(array, 0, array.length - 1);
	}
	
	private static int[] quickSort(int array[], int left, int right) {
		if(left < right) {
			int split = partition(array, left, right);
			quickSort(array, left, split - 1);
			quickSort(array, split + 1, right);
		}
		return array;
	}
	
	private static int partition(int array[], int left, int right) {
		int i = left, j = right, pivot = array[left];
		while(i < j) {
			while(i <= right && array[i] <= pivot) {
				i++;
			}
			while(j >= 0 && array[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(array, i, j);
			}
		}
		swap(array, left, j);
		return j;
	}
	
	private static void swap(int array[], int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
