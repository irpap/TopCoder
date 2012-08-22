import org.junit.Test;
import static org.junit.Assert.*;

public class LotteryTest {
	
	@Test
	public void test0() {
		String[] rules = new String[] {"PICK ANY TWO: 10 2 F F"
,"PICK TWO IN ORDER: 10 2 T F"
,"PICK TWO DIFFERENT: 10 2 F T"
,"PICK TWO LIMITED: 10 2 T T"};
		assertArrayEquals(new String[] { "PICK TWO LIMITED",  "PICK TWO IN ORDER",  "PICK TWO DIFFERENT",  "PICK ANY TWO" }, new Lottery().sortByOdds(rules));
	}
	
	@Test
	public void test1() {
		String[] rules = new String[] {"INDIGO: 93 8 T F",
 "ORANGE: 29 8 F T",
 "VIOLET: 76 6 F F",
 "BLUE: 100 8 T T",
 "RED: 99 8 T T",
 "GREEN: 78 6 F T",
 "YELLOW: 75 6 F F"}
;
		assertArrayEquals(new String[] { "RED",  "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "INDIGO",  "VIOLET" }, new Lottery().sortByOdds(rules));
	}
	
	@Test
	public void test2() {
		String[] rules = new String[] {};
		assertArrayEquals(new String[] { }, new Lottery().sortByOdds(rules));
	}
}
