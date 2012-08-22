import org.junit.Test;
import static org.junit.Assert.*;

public class TwoRectanglesTest {
	
	@Test
	public void test0() {
		int[] A = new int[] {0,0,3,2};
		int[] B = new int[] {1,1,5,3};
		assertEquals("rectangle", new TwoRectangles().describeIntersection(A, B));
	}
	
	@Test
	public void test1() {
		int[] A = new int[] {0,0,5,3};
		int[] B = new int[] {1,2,2,3};
		assertEquals("rectangle", new TwoRectangles().describeIntersection(A, B));
	}
	
	@Test
	public void test2() {
		int[] A = new int[] {1,1,6,2};
		int[] B = new int[] {3,2,5,4};
		assertEquals("segment", new TwoRectangles().describeIntersection(A, B));
	}
	
	@Test
	public void test3() {
		int[] A = new int[] {0,1,2,3};
		int[] B = new int[] {2,0,5,2};
		assertEquals("segment", new TwoRectangles().describeIntersection(A, B));
	}
	
	@Test
	public void test4() {
		int[] A = new int[] {0,0,1,1};
		int[] B = new int[] {1,1,5,2};
		assertEquals("point", new TwoRectangles().describeIntersection(A, B));
	}
	
	@Test
	public void test5() {
		int[] A = new int[] {1,1,2,2};
		int[] B = new int[] {3,1,4,2};
		assertEquals("none", new TwoRectangles().describeIntersection(A, B));
	}
}
