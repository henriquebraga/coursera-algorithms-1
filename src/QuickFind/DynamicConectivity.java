package QuickFind;

public abstract class DynamicConectivity {
	
	public int id[];
	
	public abstract boolean areConnected(int p, int q);
	public abstract void union(int p, int q);
	
	public DynamicConectivity(int size){
		id = new int[size];	
		for(int i = 0; i < id.length; i++){
			id[i] = i;
		}
	}
	
}
