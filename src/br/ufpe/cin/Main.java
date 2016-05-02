package br.ufpe.cin;

import br.ufpe.cin.tree.AVL;

public class Main {

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(5);
		System.out.println(tree);
		tree.insert(7);
		System.out.println(tree);
	}

}
