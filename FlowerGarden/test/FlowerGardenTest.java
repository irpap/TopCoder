import org.junit.Test;
import static org.junit.Assert.*;

public class FlowerGardenTest {
	
	@Test
	public void test0() {
		int[] height = new int[] {5,4,3,2,1};
		int[] bloom = new int[] {1,1,1,1,1};
		int[] wilt = new int[] {365,365,365,365,365};
		assertArrayEquals(new int[] { 1,  2,  3,  4,  5 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
	
	@Test
	public void test1() {
		int[] height = new int[] {5,4,3,2,1};
		int[] bloom = new int[] {1,5,10,15,20};
		int[] wilt = new int[] {4,9,14,19,24};
		assertArrayEquals(new int[] { 5,  4,  3,  2,  1 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
	
	@Test
	public void test2() {
		int[] height = new int[] {5,4,3,2,1};
		int[] bloom = new int[] {1,5,10,15,20};
		int[] wilt = new int[] {5,10,15,20,25};
		assertArrayEquals(new int[] { 1,  2,  3,  4,  5 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
	
	@Test
	public void test3() {
		int[] height = new int[] {5,4,3,2,1};
		int[] bloom = new int[] {1,5,10,15,20};
		int[] wilt = new int[] {5,10,14,20,25};
		assertArrayEquals(new int[] { 3,  4,  5,  1,  2 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
	
	@Test
	public void test4() {
		int[] height = new int[] {1,2,3,4,5,6};
		int[] bloom = new int[] {1,3,1,3,1,3};
		int[] wilt = new int[] {2,4,2,4,2,4};
		assertArrayEquals(new int[] { 2,  4,  6,  1,  3,  5 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
	
	@Test
	public void test5() {
		int[] height = new int[] {3,2,5,4};
		int[] bloom = new int[] {1,2,11,10};
		int[] wilt = new int[] {4,3,12,13};
		assertArrayEquals(new int[] { 4,  5,  2,  3 }, new FlowerGarden().getOrdering(height, bloom, wilt));
	}
}
