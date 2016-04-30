package br.ufpe.cin.heap;

import java.util.Arrays;

import br.ufpe.cin.LinearStructure;

public abstract class Heap implements LinearStructure {

	private int nn;
	private int n;
	private int heap[];

	public Heap(int nn) {
		this.nn = nn;
		this.n = 0;
		this.heap = new int[nn];
	}

	public Heap(int array[]) {
		this(array.length);
		this.n = array.length;
		for (int c = 0; c < nn; c++) {
			heap[c] = array[c];
		}
		buildHeap();
	}

	private void buildHeap() {
		int i = (n - 2) / 2;

		while (i >= 0) {
			bubbleDown(i);

			i--;
		}
	}

	private void bubbleDown(int i) { // heapify
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

	private void bubbleUp() {
		int i = n;

		while (hasParent(i)) {
			if (compare(heap[i], heap[getParent(i)])) {
				swap(i, getParent(i));
			}

			i = getParent(i);
		}
	}

	protected abstract boolean compare(int a, int b);

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

	public void push(int k) {
		heap[n] = k;

		bubbleUp();

		n++;
	}

	public boolean contains(int k) {
		for (int c = 0; c < n; c++) {
			if (heap[c] == k) {
				return true;
			}
		}

		return false;
	}

	public int[] sort() {
		while (n > 0) {
			swap(0, n - 1);
			bubbleDown(0);

			n--;
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
		return i <= (n - 1) / 2;
	}

	private boolean hasRightChild(int i) {
		return i < (n - 1) / 2;
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
