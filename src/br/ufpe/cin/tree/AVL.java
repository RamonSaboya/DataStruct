package br.ufpe.cin.tree;

public class AVL {

	public Node root;

	public AVL() {
		root = null;
	}
	
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
		} else {
			root = insert(root, new Node(data));
		}
	}

	private Node insert(Node root, Node data) {
		if(root.data > data.data) {
			if(root.left == null) {
				root.balance--;
				root.left = data;
				return root;
			} else {
				root.left = insert(root.left, data);
				if(root.balance == -1) {
					root = rotateLeft(root);
				} else {
					root.balance--;
				}
			}
		} else {
			if(root.right == null) {
				root.balance++;
				root.right = data;
				return root;
			} else {
				root.right = insert(root.right, data);
				if(root.balance == 1) {
					root = rotateRight(root);
				} else {
					root.balance++;
				}
			}
		}
		
		return root;
	}

	private Node rotateLeft(Node node) {
		Node root = node.left;

		node.left = root.right;
		root.right = node;
		
		root.balance = 0;
		root.left.balance = 0;
		root.right.balance = 0;

		return root;
	}

	private Node rotateRight(Node node) {
		Node root = node.right;

		node.right = root.left;
		root.left = node;
		
		root.balance = 0;
		root.left.balance = 0;
		root.right.balance = 0;

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

		return root;
	}

	private Node doubleRotateLeft(Node node) {
		Node root = node.left.right;

		Node rLeft = root.right;
		Node rRight = root.left;

		root.left = node.left;
		root.right = node;

		root.right.left = rLeft;
		root.left.right = rRight;

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

		public boolean bool;
		public Node node;

	}
}
