import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerGardenTest {

	@Test
	public void test0() {
		int[] height = new int[]{5, 4, 3, 2, 1};
		int[] bloom = new int[]{1, 1, 1, 1, 1};
		int[] wilt = new int[]{365, 365, 365, 365, 365};
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test
	public void test1() {
		int[] height = new int[]{5, 4, 3, 2, 1};
		int[] bloom = new int[]{1, 5, 10, 15, 20};
		int[] wilt = new int[]{4, 9, 14, 19, 24};
		assertArrayEquals(new int[]{5, 4, 3, 2, 1}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test
	public void test2() {
		int[] height = new int[]{5, 4, 3, 2, 1};
		int[] bloom = new int[]{1, 5, 10, 15, 20};
		int[] wilt = new int[]{5, 10, 15, 20, 25};
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test(timeout = 2000)
	public void test3() {
		int[] height = new int[]{5, 4, 3, 2, 1};
		int[] bloom = new int[]{1, 5, 10, 15, 20};
		int[] wilt = new int[]{5, 10, 14, 20, 25};
		assertArrayEquals(new int[]{3, 4, 5, 1, 2}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test(timeout = 2000)
	public void test4() {
		int[] height = new int[]{1, 2, 3, 4, 5, 6};
		int[] bloom = new int[]{1, 3, 1, 3, 1, 3};
		int[] wilt = new int[]{2, 4, 2, 4, 2, 4};
		assertArrayEquals(new int[]{2, 4, 6, 1, 3, 5}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test(timeout = 2000)
	public void test5() {
		int[] height = new int[]{3, 2, 5, 4};
		int[] bloom = new int[]{1, 2, 11, 10};
		int[] wilt = new int[]{4, 3, 12, 13};
		assertArrayEquals(new int[]{4, 5, 2, 3}, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

	@Test(timeout = 2000)
	public void test6() {
		int[] height = new int[]{310, 856, 224, 225, 895, 731, 68, 164, 243, 862, 492, 423, 628, 500, 883, 4, 615, 223, 627, 65, 361, 123, 884, 427, 636, 618, 812, 37, 44, 325, 555};
		int[] bloom = new int[]{235, 73, 255, 10, 280, 9, 8, 333, 24, 74, 141, 226, 1, 89, 8, 319, 226, 139, 247, 212, 226, 356, 144, 359, 241, 77, 158, 28, 237, 362, 173};
		int[] wilt = new int[]{331, 236, 326, 283, 342, 268, 55, 359, 214, 329, 287, 237, 172, 229, 142, 355, 304, 324, 251, 291, 247, 362, 228, 365, 365, 109, 299, 246, 341, 365, 196};
		assertArrayEquals(new int[]{123, 325, 37, 68, 4, 44, 164, 427, 65, 223, 224, 225, 310, 361, 423, 243, 492, 500, 618, 628, 615, 627, 636, 555, 731, 812, 856, 862, 895, 884, 883}
				, new FlowerGarden().getOrdering(height, bloom, wilt));
	}

}
