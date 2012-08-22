import org.junit.Test;
import static org.junit.Assert.*;

public class PointyWizardHatsTest {
	
	@Test
	public void test0() {
		int[] topHeight = new int[] {30};
		int[] topRadius = new int[] {3};
		int[] bottomHeight = new int[] {3};
		int[] bottomRadius = new int[] {30};
		assertEquals(1, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test1() {
		int[] topHeight = new int[] {4,4};
		int[] topRadius = new int[] {4,3};
		int[] bottomHeight = new int[] {5,12};
		int[] bottomRadius = new int[] {5,4};
		assertEquals(1, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test2() {
		int[] topHeight = new int[] {3};
		int[] topRadius = new int[] {3};
		int[] bottomHeight = new int[] {1,1};
		int[] bottomRadius = new int[] {2,4};
		assertEquals(1, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test3() {
		int[] topHeight = new int[] {10,10};
		int[] topRadius = new int[] {2,5};
		int[] bottomHeight = new int[] {2,9};
		int[] bottomRadius = new int[] {3,6};
		assertEquals(2, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test4() {
		int[] topHeight = new int[] {3,4,5};
		int[] topRadius = new int[] {5,4,3};
		int[] bottomHeight = new int[] {3,4,5};
		int[] bottomRadius = new int[] {3,8,5};
		assertEquals(2, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test5() {
		int[] topHeight = new int[] {1,2,3,4,5};
		int[] topRadius = new int[] {2,3,4,5,6};
		int[] bottomHeight = new int[] {2,3,4,5,6};
		int[] bottomRadius = new int[] {1,2,3,4,5};
		assertEquals(0, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test6() {
		int[] topHeight = new int[] {123,214,232,323,342,343};
		int[] topRadius = new int[] {123,123,232,123,323,434};
		int[] bottomHeight = new int[] {545,322,123,545,777,999};
		int[] bottomRadius = new int[] {323,443,123,656,767,888};
		assertEquals(5, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
	
	@Test
	public void test7() {
		int[] topHeight = new int[] {999,999,999,10000,10000,10000};
		int[] topRadius = new int[] {10000,10000,10000,1,2,3};
		int[] bottomHeight = new int[] {2324,2323,234,5454,323,232};
		int[] bottomRadius = new int[] {1,2,3222,434,5454,23};
		assertEquals(3, new PointyWizardHats().getNumHats(topHeight, topRadius, bottomHeight, bottomRadius));
	}
}
