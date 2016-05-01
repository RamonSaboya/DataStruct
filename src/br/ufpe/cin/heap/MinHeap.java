package br.ufpe.cin.heap;

public class MinHeap extends Heap {

	public MinHeap(int nn) {
		super(nn);
	}

	public MinHeap(int array[]) {
		super(array);
	}

	@Override
	public boolean compare(int a, int b) {
		return a < b;
	}

}
