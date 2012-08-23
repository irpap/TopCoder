import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleStrengthTest {
	
	@Test
	public void test0() {
		String[] teams = new String[] {"BEARS",
 "GIANTS",
 "COWBOYS",
 "BRONCOS",
 "DOLPHINS",
 "LIONS"};
		String[] results = new String[] {"-WLWW-",
 "L-WL-W",
 "WL---W",
 "LW--L-",
 "L--W--",
 "-LL---"};
		assertArrayEquals(new String[] {"BEARS", "DOLPHINS", "BRONCOS", "COWBOYS", "GIANTS", "LIONS" }, new ScheduleStrength().calculate(teams, results));
	}
	
	@Test
	public void test1() {
		String[] teams = new String[] {"BEARS",
 "COWBOYS",
 "GIANTS",
 "PACKERS"}
;
		String[] results = new String[] {"-LLW",
 "W-WW",
 "WL--",
 "LL--"};
		assertArrayEquals(new String[] {"GIANTS", "BEARS", "COWBOYS", "PACKERS" }, new ScheduleStrength().calculate(teams, results));
	}
	
	@Test
	public void test2() {
		String[] teams = new String[] {"AZTECS",
 "COUGARS",
 "COWBOYS",
 "FALCONS",
 "HORNEDFROGS",
 "LOBOS",
 "RAMS",
 "REBELS",
 "UTES"}
;
		String[] results = new String[] {"---L-L--W",
 "--LL-LWL-",
 "-W--WWLLW",
 "WW---L--W",
 "--L--W-L-",
 "WWLWL-LW-",
 "-LW--W-L-",
 "-WW-WLW--",
 "L-LL-----"}
;
		assertArrayEquals(new String[] {"HORNEDFROGS", "COUGARS", "RAMS", "LOBOS", "REBELS", "UTES", "COWBOYS", "AZTECS", "FALCONS" }, new ScheduleStrength().calculate(teams, results));
	}
	
	@Test
	public void test3() {
		String[] teams = new String[] {"E", "D", "C", "B", "Z"};
		String[] results = new String[] {
"--LLL",
"---LL",
"W---L",
"WW---",
"WWW--"
};
		assertArrayEquals(new String[] {"D", "E", "C", "Z", "B" }, new ScheduleStrength().calculate(teams, results));
	}
}
