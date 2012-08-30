import org.junit.Test;
import static org.junit.Assert.*;

public class StrangeCountryTest {
	
	@Test
	public void test0() {
		String[] g = new String[] {"NY",
 "YN"};
		assertEquals(0, new StrangeCountry().transform(g));
	}
	
	@Test
	public void test1() {
		String[] g = new String[] {"NYYNN",
 "YNYNN",
 "YYNNN",
 "NNNNY",
 "NNNYN"};
		assertEquals(1, new StrangeCountry().transform(g));
	}
	
	@Test
	public void test2() {
		String[] g = new String[] {"NYYNNNN",
 "YNYNNNN",
 "YYNNNNN",
 "NNNNYYN",
 "NNNYNYY",
 "NNNYYNY",
 "NNNNYYN"};
		assertEquals(1, new StrangeCountry().transform(g));
	}
	
	@Test
	public void test3() {
		String[] g = new String[] {"NYNYNNNNNNNN",
 "YNYNNNNNNNNN",
 "NYNYYNNNNNNN",
 "YNYNNNNNNNNN",
 "NNYNNYYNNNNN",
 "NNNNYNYNNNNN",
 "NNNNYYNNNNNN",
 "NNNNNNNNYYNN",
 "NNNNNNNYNYNN",
 "NNNNNNNYYNNN",
 "NNNNNNNNNNNY",
 "NNNNNNNNNNYN"};
		assertEquals(2, new StrangeCountry().transform(g));
	}
	
	@Test
	public void test4() {
		String[] g = new String[] {"NYNNNN",
 "YNYNNN",
 "NYNYNN",
 "NNYNNN",
 "NNNNNY",
 "NNNNYN"};
		assertEquals(-1, new StrangeCountry().transform(g));
	}
}
