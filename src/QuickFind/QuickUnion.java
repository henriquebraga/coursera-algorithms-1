package QuickFind;

public class QuickUnion extends DynamicConectivity {

	public QuickUnion(int size){
		super(size);		
	}

	@Override
	public boolean areConnected(int p, int q)
	/**
	 * Check if p and q have the same root
	 * (which means they are connected) :)
	 */
	{
		return getRoot(p) == getRoot(q);
	}

	@Override
	public void union(int p, int q)
	/**
	 * Set id of each object to itself
	 */
	{
		int rootP = this.getRoot(p);
		int rootQ = this.getRoot(q);
		this.id[rootP] = rootQ;
	}
	
	private int getRoot(int i)
	/**
	 * Chase parent pointers until reach root(depth
	 * of i array accesses)
	 */
	{
		while (i != id[i]){
			i = id[i];
		} 
		
		return i;
		
	}

}
