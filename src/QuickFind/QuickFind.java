package QuickFind;

public class QuickFind {
	/*
	 * Quick Find: Eager approach
	 * Data Strucutre.
	 * Integer array id[] of size n
	 * Interpretation: p and q are connected if they have the same id.
	 * 
	 * -> Find. Check if p and q have the same id
	 * 
	 * -> Union. To merge components containing p and q, change all entries 
	 * whose id equals id[p] to o id[q]
	 * 
	 * 
	 * Example:
	 * 
	 * id [] 
	 * Sets: {0, 5, 6}, {1, 2, 7}, {3, 4, 8, 9}
	 * 
	 * pos  id 
	 * 0    0
	 * 1    1
	 * 2    1
	 * 3    8
	 * 4    8
	 * 5    0
	 * 6    0
	 * 7    1
	 * 8    8
	 * 9    8
	 */
	int id[];
	
	public QuickFind(int size){
		id = new int[size];	
		
		for(int i = 0; i < id.length; i++){
			id[i] = i;
		}
	}

	public boolean areConnected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
 
		int qId = this.id[q];
		
		for (int i = 0; i < this.id.length; i++){			
			if(this.id[i] == qId){
				this.id[i] = this.id[p];
				
			}
			
		}
	}

}
