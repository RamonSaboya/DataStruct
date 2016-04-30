package br.ufpe.cin;

import java.util.Scanner;

import br.ufpe.cin.heap.Heap;
import br.ufpe.cin.heap.MaxHeap;
import br.ufpe.cin.heap.MinHeap;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		Heap heap = new MinHeap(size);
		while (size-- > 0) {
			heap.push(scanner.nextInt());
		}

		System.out.println(heap);
		System.out.println(new MaxHeap(heap.toArray()).toString());

		scanner.close();
	}

}
