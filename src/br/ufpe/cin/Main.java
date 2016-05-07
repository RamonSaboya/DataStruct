package br.ufpe.cin;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int array[] = { 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(Sort.quickSort(array)));
	}

}
