import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryCodeTest {
	
	@Test
	public void test0() {
		String message = "123210122";
		assertArrayEquals(new String[] { "011100011",  "NONE" }, new BinaryCode().decode(message));
	}
	
	@Test
	public void test1() {
		String message = "11";
		assertArrayEquals(new String[] { "01",  "10" }, new BinaryCode().decode(message));
	}
	
	@Test
	public void test2() {
		String message = "22111";
		assertArrayEquals(new String[] { "NONE",  "11001" }, new BinaryCode().decode(message));
	}
	
	@Test
	public void test3() {
		String message = "123210120";
		assertArrayEquals(new String[] { "NONE",  "NONE" }, new BinaryCode().decode(message));
	}
	
	@Test
	public void test4() {
		String message = "3";
		assertArrayEquals(new String[] { "NONE",  "NONE" }, new BinaryCode().decode(message));
	}
	
	@Test
	public void test5() {
		String message = "12221112222221112221111111112221111";
		assertArrayEquals(new String[] { "01101001101101001101001001001101001",  "10110010110110010110010010010110010" }, new BinaryCode().decode(message));
	}
}
