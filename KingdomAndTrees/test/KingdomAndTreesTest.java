import org.junit.Test;
import static org.junit.Assert.*;

public class KingdomAndTreesTest {
	
	@Test
	public void test0() {
		int[] heights = new int[] {9, 5, 11};
		assertEquals(3, new KingdomAndTrees().minLevel(heights));
	}
	
	@Test
	public void test1() {
		int[] heights = new int[] {5, 8};
		assertEquals(0, new KingdomAndTrees().minLevel(heights));
	}
	
	@Test
	public void test2() {
		int[] heights = new int[] {1, 1, 1, 1, 1};
		assertEquals(4, new KingdomAndTrees().minLevel(heights));
	}
	
	@Test
	public void test3() {
		int[] heights = new int[] {548, 47, 58, 250, 2012};
		assertEquals(251, new KingdomAndTrees().minLevel(heights));
	}
}
