import org.junit.Test;
import static org.junit.Assert.*;

public class SmartWordToyTest {
	
	@Test
	public void test0() {
		String start = "aaaa";
		String finish = "zzzz";
		String[] forbid = new String[] {"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"};
		assertEquals(8, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test1() {
		String start = "aaaa";
		String finish = "bbbb";
		String[] forbid = new String[] {};
		assertEquals(4, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test2() {
		String start = "aaaa";
		String finish = "mmnn";
		String[] forbid = new String[] {};
		assertEquals(50, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test3() {
		String start = "aaaa";
		String finish = "zzzz";
		String[] forbid = new String[] {"bz a a a", "a bz a a", "a a bz a", "a a a bz"};
		assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test4() {
		String start = "aaaa";
		String finish = "zzzz";
		String[] forbid = new String[] {"cdefghijklmnopqrstuvwxyz a a a", 
 "a cdefghijklmnopqrstuvwxyz a a", 
 "a a cdefghijklmnopqrstuvwxyz a", 
 "a a a cdefghijklmnopqrstuvwxyz"};
		assertEquals(6, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test5() {
		String start = "aaaa";
		String finish = "bbbb";
		String[] forbid = new String[] {"b b b b"};
		assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
	}
	
	@Test
	public void test6() {
		String start = "zzzz";
		String finish = "aaaa";
		String[] forbid = new String[] {"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"};
		assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
	}
}
