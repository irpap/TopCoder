import org.junit.Test;
import static org.junit.Assert.*;

public class WordFindTest {
	
	@Test
	public void test0() {
		String[] grid = new String[] {"TEST",
 "GOAT",
 "BOAT"};
		String[] wordList = new String[] {"GOAT", "BOAT", "TEST"};
		assertArrayEquals(new String[] { "1 0",
  "2 0",
  "0 0" }, new WordFind().findWords(grid, wordList));
	}
	
	@Test
	public void test1() {
		String[] grid = new String[] {"SXXX",
 "XQXM",
 "XXLA",
 "XXXR"};
		String[] wordList = new String[] {"SQL", "RAM"};
		assertArrayEquals(new String[] { "0 0",
  "" }, new WordFind().findWords(grid, wordList));
	}
	
	@Test
	public void test2() {
		String[] grid = new String[] {"EASYTOFINDEAGSRVHOTCJYG",
 "FLVENKDHCESOXXXXFAGJKEO",
 "YHEDYNAIRQGIZECGXQLKDBI",
 "DEIJFKABAQSIHSNDLOMYJIN",
 "CKXINIMMNGRNSNRGIWQLWOG",
 "VOFQDROQGCWDKOUYRAFUCDO",
 "PFLXWTYKOITSURQJGEGSPGG"};
		String[] wordList = new String[] {"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"};
		assertArrayEquals(new String[] { "0 0",
  "1 6",
  "0 22",
  "" }, new WordFind().findWords(grid, wordList));
	}
}
