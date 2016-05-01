package br.ufpe.cin;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int array[] = {5, 1, 10, 9, 15};
		System.err.println(Arrays.toString(Sort.mergeSort(array, SortOrder.DESCENDING)));
	}

}
