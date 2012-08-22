import org.junit.Test;
import static org.junit.Assert.*;

public class EvenRouteTest {
	
	@Test
	public void test0() {
		int[] x = new int[] {-1,-1,1,1};
		int[] y = new int[] {-1,1,1,-1};
		int wantedParity = 0;
		assertEquals("CAN", new EvenRoute().isItPossible(x, y, wantedParity));
	}
	
	@Test
	public void test1() {
		int[] x = new int[] {-5,-3,2};
		int[] y = new int[] {2,0,3};
		int wantedParity = 1;
		assertEquals("CAN", new EvenRoute().isItPossible(x, y, wantedParity));
	}
	
	@Test
	public void test2() {
		int[] x = new int[] {1001, -4000};
		int[] y = new int[] {0,0};
		int wantedParity = 1;
		assertEquals("CAN", new EvenRoute().isItPossible(x, y, wantedParity));
	}
	
	@Test
	public void test3() {
		int[] x = new int[] {11, 21, 0};
		int[] y = new int[] {-20, 42, 7};
		int wantedParity = 0;
		assertEquals("CANNOT", new EvenRoute().isItPossible(x, y, wantedParity));
	}
	
	@Test
	public void test4() {
		int[] x = new int[] {0, 6};
		int[] y = new int[] {10, -20};
		int wantedParity = 1;
		assertEquals("CANNOT", new EvenRoute().isItPossible(x, y, wantedParity));
	}
}
