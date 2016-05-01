package br.ufpe.cin.heap;

import java.util.Arrays;

public abstract class Heap {

	public int nn;
	public int n;
	public int heap[];

	public Heap(int nn) {
		this.nn = nn;
		this.n = 0;
		this.heap = new int[nn];
	}

	public Heap(int array[]) {
		this(array.length);
		this.n = array.length;
		for (int c = 0; c < n; c++) {
			heap[c] = array[c];
		}
		buildHeap();
	}

	public void buildHeap() {
		int i = (n - 2) / 2;

		while (i >= 0) {
			bubbleDown(i);

			i--;
		}
	}

	public void bubbleDown(int i) { // heapify
		while (hasLeftChild(i)) {
			int priority = getLeftChild(i);

			if (hasRightChild(i) && compare(heap[getRightChild(i)], heap[priority])) {
				priority = getRightChild(i);
			}

			if (compare(heap[priority], heap[i])) {
				swap(i, priority);
				i = priority;
			} else {
				break;
			}
		}
	}

	public void bubbleUp() {
		int i = n;

		while (hasParent(i)) {
			if (compare(heap[i], heap[getParent(i)])) {
				swap(i, getParent(i));
			}

			i = getParent(i);
		}
	}

	public abstract boolean compare(int a, int b);

	public int peek() {
		return heap[0];
	}

	public int pop() {
		int top = peek();

		remove();

		return top;
	}

	public void remove() {
		swap(0, --n);

		bubbleDown(0);
	}

	public void push(int data) {
		if (n < nn) {
			heap[n] = data;

			bubbleUp();

			n++;
		}
	}

	public boolean contains(int data) {
		for (int c = 0; c < n; c++) {
			if (heap[c] == data) {
				return true;
			}
		}

		return false;
	}

	public int[] sort() {
		while (n > 1) {
			remove();
		}

		return heap;
	}

	private int getParent(int i) {
		return (i - 1) / 2;
	}

	private int getLeftChild(int i) {
		return (2 * i) + 1;
	}

	private int getRightChild(int i) {
		return (2 * i) + 2;
	}

	private boolean hasParent(int i) {
		return i > 0;
	}

	private boolean hasLeftChild(int i) {
		return getLeftChild(i) < n;
	}

	private boolean hasRightChild(int i) {
		return getRightChild(i) < n;
	}

	private void swap(int a, int b) {
		int aux = heap[a];
		heap[a] = heap[b];
		heap[b] = aux;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(heap, n));
	}

	public int[] toArray() {
		return heap;
	}

}
