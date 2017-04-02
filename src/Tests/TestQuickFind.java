package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import QuickFind.DynamicConectivity;
import QuickFind.QuickFind;
import junit.framework.TestCase;

public class TestQuickFind extends TestCase {
	
	private DynamicConectivity quickFind;

	private int p;
	private int q;
	
	protected void setUp() 
	{
		this.p = 3;
		this.q = 4;
		this.quickFind = new QuickFind(10);
	}
	
	public void test_afterCreatingQuickFindShouldHaveTenSizeArray()
	{
		assertEquals(this.quickFind.id.length, 10);	
	}
	
	public void test_WhenCreatePositionsShouldHaveTheSameValueFromIndex()
	{
		int expectedIds[] = new int[10];
		
		for (int i = 0; i < expectedIds.length; i++){
			expectedIds[i] = i;
		}
		
		assertArrayEquals(expectedIds, this.quickFind.id);
	}
	
	public void test_PandQshouldNotBeConnected()
	{
		assertFalse(this.quickFind.areConnected(this.p, q));
	}
	
	public void test_AfterUnionComponentsShouldHaveSameIds(){
		this.quickFind.union(p, q);
		assertEquals(this.quickFind.id[p], this.quickFind.id[q]);
	}
	
	public void test_ShouldUnionTwoComponents()/**
	* Here are the steps executed for this test:
	* 
	*   Step 1. 0 1 2 3 4 5 6 7 8 9 initial state
	    Step 2. 0 1 2 3 3 5 6 7 8 9 union(3, 4)
		Step 3. 0 0 2 3 3 5 6 7 8 9 union(0, 1)
		Step 4. 0 0 2 0 0 5 6 7 8 9 union(1, 3): should union elements containing id 3.
      */
	
	{
		this.quickFind.union(3, 4);
		this.quickFind.union(0, 1);
		this.quickFind.union(1, 3);		
		int[] expectedIds = {0, 0, 2, 0, 0, 5, 6, 7, 8, 9};

		assertArrayEquals(expectedIds, this.quickFind.id);		
	}

}
