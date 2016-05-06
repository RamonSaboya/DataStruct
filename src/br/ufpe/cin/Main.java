package br.ufpe.cin;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int array[] = { 3, 5, 7, 1, 8, 4, 9, 6 };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(Sort.quickSort(array)));
	}

}
