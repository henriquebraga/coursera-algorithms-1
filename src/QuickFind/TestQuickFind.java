package QuickFind;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
public class TestQuickFind extends TestCase {
	
	private DynamicConectivity qf;

	private int p;
	private int q;
	
	protected void setUp() {
		this.p = 3;
		this.q = 4;
		this.qf = new QuickFind(10);
	}
	@Test
	public void testShouldCreateTenSizeArray() {
		assertEquals(this.qf.id.length, 10);	
	}
	
	@Test
	public void testWhenCreatesPositionsShouldHaveTheSameValueFromIndex(){
		int expectedIds[] = new int[10];
		
		for (int i = 0; i < expectedIds.length; i++){
			expectedIds[i] = i;
		}
		
		assertArrayEquals(expectedIds, this.qf.id);
	}
	
	@Test
	public void testPandQshouldNotBeConnected(){
		assertFalse(this.qf.areConnected(this.p, q));
	}
	
	@Test
	public void testAfterUnionComponentsShouldHaveSameIds(){
		this.qf.union(p, q);
		assertEquals(this.qf.id[p], this.qf.id[q]);
	}
	
	@Test
	public void testShouldUnionTwoComponents(){
		// 0 1 2 3 4 5 6 7 8 9 initial state
		// 0 1 2 3 3 5 6 7 8 9 union(3, 4)
		// 0 0 2 3 3 5 6 7 8 9 union(0, 1)
		// 0 0 2 0 0 5 6 7 8 9 union(1, 3): should union elements containing id 3.
		
		this.qf.union(3, 4);
		this.qf.union(0, 1);
		this.qf.union(1, 3);
		
		int[] expectedIds = {0, 0, 2, 0, 0, 5, 6, 7, 8, 9};
		
		assertArrayEquals(expectedIds, this.qf.id);		
	}

}
