package QuickFind;

public abstract class DynamicConectivity {
	
	protected int id[];
	
	public abstract boolean areConnected(int p, int q);
	public abstract void union(int p, int q);
	
}
