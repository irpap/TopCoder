import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftRightDigitsGameTest {
	
	@Test
	public void test0() {
		String digits = "565";
		assertEquals("556", new LeftRightDigitsGame().minNumber(digits));
	}
	
	@Test
	public void test1() {
		String digits = "9876543210";
		assertEquals("1234567890", new LeftRightDigitsGame().minNumber(digits));
	}
	
	@Test
	public void test2() {
		String digits = "8016352";
		assertEquals("1086352", new LeftRightDigitsGame().minNumber(digits));
	}
	@Test
	public void test3() {
		String digits = "01";
		assertEquals("10", new LeftRightDigitsGame().minNumber(digits));
	}
}
