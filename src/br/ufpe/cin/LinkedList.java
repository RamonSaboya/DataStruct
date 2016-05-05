package br.ufpe.cin;

public class LinkedList {

	public int n;
	public Node head;

	public LinkedList() {
		this.n = 0;
		this.head = null;
	}

	public LinkedList(int data) {
		this.n = 1;
		this.head = new Node(data);
	}

	public LinkedList(int array[]) {
		if (array.length == 0) {
			this.head = null;
		} else {
			this.n = array.length;
			this.head = new Node(array[0]);
			Node last = head;
			for (int c = 1; c < array.length; c++) {
				last.next = new Node(array[c]);
				last = last.next;
			}
		}
	}

	public void add(int data) {
		addLast(data);
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		n++;
	}

	public void addLast(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node(data);
		}
		n++;
	}

	public int get(int index) {
		if ((index < 0) || (index >= n)) {
			return Integer.MIN_VALUE; // O certo seria disparar exceção, mas....
		}

		Node current = head;
		for (int c = 0; c < index; c++) {
			current = current.next;
		}

		return current.data;
	}

	public int getFirst() {
		return get(0);
	}

	public int getLast() {
		return get(n - 1);
	}

	public boolean remove(int index) {
		if ((index < 0) || (index >= n) || (head == null)) {
			return false;
		}

		if (index == 0) {
			head = head.next;
			return true;
		}

		Node previous = head;
		for (int c = 1; c < index; c++) { // Vai executar *index* - 1 vezes
			previous = previous.next;
		}

		if (previous.next != null) {
			previous.next = previous.next.next;
		}

		return true;
	}

	public

	public int size() {
		return n;
	}

	public void clear() {
		head = null;
	}

	@Override
	public String toString() {
		if (head != null) {
			return "[ " + head.toString() + " ]";
		} else {
			return "[]";
		}
	}

	private class Node {

		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			if (next != null) {
				return data + " " + next.toString();
			} else {
				return data + "";
			}
		}

	}

}
