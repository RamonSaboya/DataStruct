package br.ufpe.cin;

public enum SortOrder {

	ASCENDING {
		public boolean compare(int a, int b) {
			return a < b;
		}
	},
	DESCENDING {
		public boolean compare(int a, int b) {
			return a > b;
		}
	};
	
	public abstract boolean compare(int a, int b);

}
