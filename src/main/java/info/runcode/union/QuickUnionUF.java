package info.runcode.union;

public class QuickUnionUF {
	public int[] roots;
	public QuickUnionUF(int N) {
		roots = new int[N];
		for (int i=0;i<N;i++) {
			roots[i] = i;
		}
	}
	
	private int findRoot(int i){
		int root = i;
		while (root != roots[root]) {
			root = roots[root];
		}
		
		while(i != roots[i]) {
			int tmp = roots[i]; roots[i] =root; i = tmp;
			//i = roots[i] ; roots[i] = root;
		}
		return root;
	}
	
	public boolean connected(int i,int j) {
		return findRoot(i) == findRoot(j);
	}
	
	public void union(int p,int q) {
		int proot = findRoot(p);
		int qroot = findRoot(q);
		for(int i=0;i<roots.length;i++) {
			int tmp = roots[proot];
			if (tmp == roots[i]) {
				roots[i] = qroot;
			}
		}
	}
}

