package br.ufpe.cin.tree;

public class AVL {

	public Node root;

	public AVL() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, new Node(data)).node;
	}

	private DoubleReturn insert(Node root, Node data) {
		DoubleReturn dr = new DoubleReturn();
		dr.heightChanged = false;

		if (root == null) {
			root = data;
			dr.heightChanged = true;
		} else if (root.data > data.data) {
			DoubleReturn insertDR = insert(root.left, data);

			root.left = insertDR.node;
			if (insertDR.heightChanged) {
				root.balance--;
				if (Math.abs(root.balance) == 1) {
					dr.heightChanged = true;
				} else if (Math.abs(root.balance) == 2) {
					if (root.left.data > data.data) {
						root = rotateLeft(root);
					} else {
						root = doubleRotateLeft(root);
					}
				}
			}
		} else {
			DoubleReturn insertDR = insert(root.right, data);

			root.right = insertDR.node;
			if (insertDR.heightChanged) {
				root.balance++;
				if (Math.abs(root.balance) == 1) {
					dr.heightChanged = true;
				} else if (Math.abs(root.balance) == 2) {
					if (root.right.data < data.data) {
						root = rotateRight(root);
					} else {
						root = doubleRotateRight(root);
					}
				}
			}
		}

		dr.node = root;
		return dr;
	}

	private Node rotateLeft(Node node) {
		Node root = node.left;

		node.left = root.right;
		root.right = node;

		root.balance = 0;
		node.balance = 0;

		return root;
	}

	private Node rotateRight(Node node) {
		Node root = node.right;

		node.right = root.left;
		root.left = node;

		root.balance = 0;
		node.balance = 0;

		return root;
	}

	private Node doubleRotateLeft(Node node) {
		Node root = node.left.right;

		Node rRight = root.right;
		Node rLeft = root.left;

		root.left = node.left;
		root.right = node;

		root.right.left = rRight;
		root.left.right = rLeft;

		root.balance = 0;
		root.right.balance = 0;

		root.left.balance = 1;
		if (root.left.right == null) {
			root.left.balance = -1;
		}

		return root;
	}

	private Node doubleRotateRight(Node node) {
		Node root = node.right.left;

		Node rLeft = root.left;
		Node rRight = root.right;

		root.right = node.right;
		root.left = node;

		root.left.right = rLeft;
		root.right.left = rRight;

		root.balance = 0;
		root.left.balance = 0;

		root.right.balance = 1;
		if (root.right.right == null) {
			root.right.balance = -1;
		}

		return root;
	}

	@Override
	public String toString() {
		return root.toString();
	}

	public class Node {

		public int data;

		public Node left;
		public Node right;

		public int balance;

		public Node(int data) {
			this.data = data;

			this.left = null;
			this.right = null;

			this.balance = 0;
		}

		@Override
		public String toString() {
			return data + " " + (left != null ? left.toString() : "") + (right != null ? right.toString() : "");
		}

	}

	private class DoubleReturn {

		public boolean heightChanged;
		public Node node;

	}
}
