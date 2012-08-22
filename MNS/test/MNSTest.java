import org.junit.Test;
import static org.junit.Assert.*;

public class MNSTest {
	
	@Test
	public void test0() {
		int[] numbers = new int[] {1,2,3,3,2,1,2,2,2};
		assertEquals(18, new MNS().combos(numbers));
	}
	
	@Test
	public void test1() {
		int[] numbers = new int[] {4,4,4,4,4,4,4,4,4};
		assertEquals(1, new MNS().combos(numbers));
	}
	
	@Test
	public void test2() {
		int[] numbers = new int[] {1,5,1,2,5,6,2,3,2};
		assertEquals(36, new MNS().combos(numbers));
	}
	
	@Test
	public void test3() {
		int[] numbers = new int[] {1,2,6,6,6,4,2,6,4};
		assertEquals(0, new MNS().combos(numbers));
	}
}
