import org.junit.Test;
import static org.junit.Assert.*;

public class DerivativeSequenceTest {
	
	@Test
	public void test0() {
		int[] a = new int[] {5,6,3,9,-1};
		int n = 1;
		assertArrayEquals(new int[] {1, -3, 6, -10 }, new DerivativeSequence().derSeq(a, n));
	}
	
	@Test
	public void test1() {
		int[] a = new int[] {5,6,3,9,-1};
		int n = 2;
		assertArrayEquals(new int[] {-4, 9, -16 }, new DerivativeSequence().derSeq(a, n));
	}
	
	@Test
	public void test2() {
		int[] a = new int[] {5,6,3,9,-1};
		int n = 4;
		assertArrayEquals(new int[] {-38 }, new DerivativeSequence().derSeq(a, n));
	}
	
	@Test
	public void test3() {
		int[] a = new int[] {4,4,4,4,4,4,4,4};
		int n = 3;
		assertArrayEquals(new int[] {0, 0, 0, 0, 0 }, new DerivativeSequence().derSeq(a, n));
	}
	
	@Test
	public void test4() {
		int[] a = new int[] {-100,100};
		int n = 0;
		assertArrayEquals(new int[] {-100, 100 }, new DerivativeSequence().derSeq(a, n));
	}
}
