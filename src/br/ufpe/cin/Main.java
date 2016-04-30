package br.ufpe.cin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int array[] = new int[size];

		while (size-- > 0) {
			array[array.length - size - 1] = scanner.nextInt();
		}

		System.out.println(Arrays.toString(array));

		array = Sort.heapSort(array, SortOrder.DESCENDING);

		System.out.println(Arrays.toString(array));

		scanner.close();
	}

}
