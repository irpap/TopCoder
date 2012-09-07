import org.junit.Test;
import static org.junit.Assert.*;

public class TheBrickTowerMediumDivTwoTest {
	
	@Test
	public void test0() {
		int[] heights = new int[] {4, 7, 5};
		assertArrayEquals(new int[] {0, 2, 1 }, new TheBrickTowerMediumDivTwo().find(heights));
	}
	
	@Test
	public void test1() {
		int[] heights = new int[] {4, 4, 4, 4, 4, 4, 4};
		assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6 }, new TheBrickTowerMediumDivTwo().find(heights));
	}
	
	@Test
	public void test2() {
		int[] heights = new int[] {2, 3, 3, 2};
		assertArrayEquals(new int[] {0, 3, 1, 2 }, new TheBrickTowerMediumDivTwo().find(heights));
	}
	
	@Test
	public void test3() {
		int[] heights = new int[] {13, 32, 38, 25, 43, 47, 6};
		assertArrayEquals(new int[] {0, 6, 3, 1, 2, 4, 5 }, new TheBrickTowerMediumDivTwo().find(heights));
	}
}
