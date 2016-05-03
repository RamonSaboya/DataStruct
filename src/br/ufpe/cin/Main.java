package br.ufpe.cin;

import br.ufpe.cin.tree.AVL;

public class Main {

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(15);
		tree.insert(13);
		tree.insert(11);
		tree.insert(9);
		tree.insert(7);
		tree.insert(12);
		tree.insert(10);
		System.out.println(tree);
	}

}
