package br.ufpe.cin;

import br.ufpe.cin.tree.AVL;

public class Main {

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		System.out.println(tree);
	}

}
