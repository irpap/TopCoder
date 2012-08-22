import org.junit.Test;
import static org.junit.Assert.*;

public class OrderOfTheHatsTest {
	
	@Test
	public void test0() {
		String[] spellChart = new String[] {"Y"};
		assertEquals(1, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test1() {
		String[] spellChart = new String[] {"NYN",
 "NNY",
 "NNN"}
;
		assertEquals(0, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test2() {
		String[] spellChart = new String[] {"NYN",
 "NNY",
 "YNN"};
		assertEquals(1, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test3() {
		String[] spellChart = new String[] {"NYYYYYY",
 "YNYYYYY",
 "YYNYYYY",
 "YYYNYYY",
 "YYYYNYY",
 "YYYYYNY",
 "YYYYYYN"};
		assertEquals(21, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test4() {
		String[] spellChart = new String[] {"NNNY",
 "YNYN",
 "YNNN",
 "YYYN"};
		assertEquals(1, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test5() {
		String[] spellChart = new String[] {"YYYYYNNYYYNYNNNNYNNY",
 "NYNNNYYNNYNYYYNYYYYY",
 "NNYNNNYYNNNNNNYYYYNY",
 "YYNYNYYNNYYYNYNNNYYY",
 "NYYNNYNYNYNNNNYYYNYN",
 "NNNNNYYNYNNYYYYNYYYN",
 "YNYNYYNNNYNNNNNYNNYY",
 "NYYYYNYNYNNYNNYNNNNY",
 "YYYYNYYNNYYYNNYNNYNY",
 "YYYYYYNYNYNYNNNNNNYN",
 "NNYYYYYNNNYNNNYNNNNY",
 "YYNNNYNYYNYYNYYNYNYN",
 "NNYNYYNYYNYYNYNYNYYN",
 "YNYNYYNYNNNYNYNYYNYY",
 "NNYNNNYYYYYYYYYYYNYY",
 "YYYYYNYYNYYYYYNNYNNN",
 "NYYYYYYYYNNNNNYYNNYN",
 "YNNYNNNYYNYYYNYNYYYY",
 "YYNNYNYYYNYYNNNYYNNY",
 "NNYNYNYYYNYYNYNNYNNN"};
		assertEquals(79, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test6() {
		String[] spellChart = new String[] {"YYNYNN",
 "YNYNNY",
 "YYYYNN",
 "NNNYNN",
 "NNNYNN",
 "YNYNYN"};
		assertEquals(5, new OrderOfTheHats().minChanged(spellChart));
	}
	
	@Test
	public void test7() {
		String[] spellChart = new String[] {"NNNNNNNNNN",
 "NNNNNNNNNN",
 "NNNYNNYNNN",
 "NNNYNNYNNN",
 "NNNYNNYNNN",
 "NNNNNNNNNN",
 "NNYYYYYYNN",
 "NNYNNNNYNN",
 "NNNYYYYNNN",
 "NNNNNNNNNN"};
		assertEquals(6, new OrderOfTheHats().minChanged(spellChart));
	}
}
