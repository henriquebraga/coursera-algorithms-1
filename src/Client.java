
public class Client {
	
	public static int rank(int key, int [] a){
		return rank(key, a, 0, a.length - 1);
	}
	
	public static int rank(int key, int[] a, int lo, int hi){
		if(lo > hi) return -1;
		int avg = lo + (hi - lo) / 2;
		
		//5 3 4 2 1
		//0 + (3 - 0) = 3 / 2 = 1
		//0 + (3 - 0) / 2 -> 3 / 2 -> 1
		if(key < a[avg]) return rank(key, a, lo, avg - 1);
		else if(key > a[avg]) return rank(key, a, avg + 1, hi);
		else return avg;
		
	}
	
	public static void main(String args[]){
		int[] arr = new int[5];
		arr[0] = 4;
		arr[1] = 5;
		arr[2] = 12;
		arr[3] = 21;
		arr[4] = 27;
		
		int rank = rank(2, arr);
		System.out.println(rank);
	}

}
