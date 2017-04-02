package Tests;

import QuickFind.DynamicConectivity;
import QuickFind.WeightedQuickUnion;
import junit.framework.TestCase;
import org.junit.Assert;


public class TestWeightedQuickUnion extends TestCase {
    private WeightedQuickUnion weightedQuickUnion;


    @Override
    protected void setUp() throws Exception {
        this.weightedQuickUnion = new WeightedQuickUnion(10);
        super.setUp();
    }

    public void test_shouldCreateTenSizeArray(){
        assertEquals(10, this.weightedQuickUnion.id.length);
    }

    public void test_shouldHaveCountArrayWithOneValue(){
        int [] expectedCount = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        Assert.assertArrayEquals(expectedCount, this.weightedQuickUnion.count);
    }

    public void test_afterUnionShouldIncrementTreeSizeForIdFourByOne(){
        int p = 4;
        this.weightedQuickUnion.union(p, 3);

        assertEquals(2, this.weightedQuickUnion.count[p]);
    }

    public void test_afterUnionsIdThreeShouldHaveFourPointingElements(){
        this.weightedQuickUnion.union(4, 3);
        this.weightedQuickUnion.union(3, 8);
        this.weightedQuickUnion.union(6, 5);
        this.weightedQuickUnion.union(9, 4);

        assertEquals(4, this.weightedQuickUnion.count[4]);
    }

    public void test_afterUnionsShouldConnectTheSmallerTreesToTheLargerOnes() {
        this.weightedQuickUnion.union(4, 3);
        this.weightedQuickUnion.union(3, 8);
        this.weightedQuickUnion.union(6, 5);
        this.weightedQuickUnion.union(9, 4);
        this.weightedQuickUnion.union(2, 1);
        this.weightedQuickUnion.union(5, 0);
        this.weightedQuickUnion.union(7, 2);
        this.weightedQuickUnion.union(6, 1);
        this.weightedQuickUnion.union(7, 3);

        int[] expectedTree = {6, 2, 6, 4, 6, 6, 6, 2, 4, 4};

        Assert.assertArrayEquals(expectedTree, this.weightedQuickUnion.id);

    }

    private void printId()
    /**
     * Prints id array.
     * Use it to debug after union calls and understand what's going on
     * under the hoods. :)
     */

    {
        System.out.print("weightedQuickUnion.id: ");
        for(int i = 0; i < 10; i++){
            System.out.print(this.weightedQuickUnion.id[i] + " ");
        }
        System.out.print('\n');
    }
}

