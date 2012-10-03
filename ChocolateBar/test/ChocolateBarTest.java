import org.junit.Test;
import static org.junit.Assert.*;

public class ChocolateBarTest {
	
	@Test
	public void test0() {
		String letters = "srm";
		assertEquals(3, new ChocolateBar().maxLength(letters));
	}
	
	@Test
	public void test1() {
		String letters = "dengklek";
		assertEquals(6, new ChocolateBar().maxLength(letters));
	}
	
	@Test
	public void test2() {
		String letters = "haha";
		assertEquals(2, new ChocolateBar().maxLength(letters));
	}
	
	@Test
	public void test3() {
		String letters = "www";
		assertEquals(1, new ChocolateBar().maxLength(letters));
	}
	
	@Test
	public void test4() {
		String letters = "thisisansrmbeforetopcoderopenfinals";
		assertEquals(9, new ChocolateBar().maxLength(letters));
	}
}
