import org.junit.Test;
import static org.junit.Assert.*;

public class DigitsSumTest {
	
	@Test
	public void test0() {
		int n = 12345;
		assertEquals(6, new DigitsSum().lastDigit(n));
	}
	
	@Test
	public void test1() {
		int n = 6;
		assertEquals(6, new DigitsSum().lastDigit(n));
	}
	
	@Test
	public void test2() {
		int n = 999999999;
		assertEquals(9, new DigitsSum().lastDigit(n));
	}
	
	@Test
	public void test3() {
		int n = 213413512;
		assertEquals(4, new DigitsSum().lastDigit(n));
	}
	
	@Test
	public void test4() {
		int n = 314;
		assertEquals(8, new DigitsSum().lastDigit(n));
	}
	
	@Test
	public void test5() {
		int n = 2147483647;
		assertEquals(1, new DigitsSum().lastDigit(n));
	}
}
