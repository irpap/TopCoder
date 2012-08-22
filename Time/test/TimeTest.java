import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTest {
	
	@Test
	public void test0() {
		int seconds = 0;
		assertEquals("0:0:0", new Time().whatTime(seconds));
	}
	
	@Test
	public void test1() {
		int seconds = 3661;
		assertEquals("1:1:1", new Time().whatTime(seconds));
	}
	
	@Test
	public void test2() {
		int seconds = 5436;
		assertEquals("1:30:36", new Time().whatTime(seconds));
	}
	
	@Test
	public void test3() {
		int seconds = 86399;
		assertEquals("23:59:59", new Time().whatTime(seconds));
	}
}
