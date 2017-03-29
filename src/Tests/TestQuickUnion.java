package Tests;

import static org.junit.Assert.assertArrayEquals;

import QuickFind.DynamicConectivity;
import QuickFind.QuickUnion;
import junit.framework.TestCase;

public class TestQuickUnion extends TestCase {
	private DynamicConectivity quickUnion;
	int p;
	int q;
	@Override
	protected void setUp() throws Exception {
		this.p = 2;
		this.q = 3;
		this.quickUnion = new QuickUnion(10);
		super.setUp();
	}
	public void test_shouldCreateTenSizeArray(){
		assertEquals(10, this.quickUnion.id.length);
	}
	
	public void test_whenCreatesPositionsShouldHaveTheSameValueFromIndex(){
		int expectedIds[] = new int[10];
		for (int i = 0; i < expectedIds.length; i++){
			expectedIds[i] = i;
		}
		assertArrayEquals(expectedIds, this.quickUnion.id);
	}
	
	public void test_pAndQShouldNotBeConnected(){
		this.quickUnion.areConnected(this.p, this.q);
	}
	
	public void test_afterUnionPandQShouldHaveSameParent(){
		this.quickUnion.union(p, q);
		assertEquals(this.quickUnion.id[q],this.quickUnion.id[p]);
	}
	
	public void test_afterUnionPanQShouldHaveSameRoot(){
		this.quickUnion.union(p, q);
		assertTrue(this.quickUnion.areConnected(p, q));
	}
	
	public void test_afterFourUnionsValuesShouldBeConnected(){
		this.quickUnion.union(3, 4);
		this.quickUnion.union(0, 1);
		this.quickUnion.union(1, 3);
		assertTrue(this.quickUnion.areConnected(0, 3));
	}
	
}