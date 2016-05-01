package br.ufpe.cin.heap;

public class MaxHeap extends Heap {

	public MaxHeap(int nn) {
		super(nn);
	}

	public MaxHeap(int array[]) {
		super(array);
	}

	@Override
	public boolean compare(int a, int b) {
		return a > b;
	}

}
