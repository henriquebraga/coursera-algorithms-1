package QuickFind;

public class WeightedQuickUnion extends QuickUnion {

    public int[] count;


    public WeightedQuickUnion(int size) {
        super(size);

        count = new int[size];

        for(int i = 0; i < size; i++){
            this.count[i] = 1;
        }
    }

    @Override
    public void union(int p, int q){
        int rootP = this.getRoot(p);
        int rootQ = this.getRoot(q);

        if(this.count[rootP] < this.count[rootQ]){
            this.id[rootP] = rootQ;
            this.count[rootQ] += this.count[rootP];
        } else {
            this.id[rootQ] = rootP;
            this.count[rootP] += this.count[rootQ];
        }
    }

}
