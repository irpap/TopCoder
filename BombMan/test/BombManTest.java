import org.junit.Test;
import static org.junit.Assert.*;

public class BombManTest {
	
	@Test
	public void test0() {
		String[] maze = new String[] {".....B.",
 ".#####.",
 ".#...#.",
 ".#E#.#.",
 ".###.#.",
 "......."}
;
		int bombs = 1;
		assertEquals(8, new BombMan().shortestPath(maze, bombs));
	}
	
	@Test
	public void test1() {
		String[] maze = new String[] {"B.#.#.#...E"};
		int bombs = 2;
		assertEquals(-1, new BombMan().shortestPath(maze, bombs));
	}
	
	@Test
	public void test2() {
		String[] maze = new String[] {"..#####",
 "B.#####",
 "..#####",
 "#######",
 "####...",
 "####.E."}
;
		int bombs = 4;
		assertEquals(17, new BombMan().shortestPath(maze, bombs));
	}
	
	@Test
	public void test3() {
		String[] maze = new String[] {".#.#.#.#B#...#.#...#.#...#.#...#.#...#.#.#.......",
 ".#.#.#.#.#.###.###.#.###.#.#.###.###.#.#.#.###.##",
 ".#.#.#...#.#.#.#.#.#...#.....#.#.#...#...#.#.#...",
 ".#.#.###.#.#.#.#.#.###.#.#####.#.###.###.#.#.###.",
 ".............#.#...#...#.....#.#.#...#.#.#.....#.",
 "##.#######.###.#.#####.#.#####.#.###.#.#.#.#.####",
 ".#.#.....#...#...#.#...#...#.#.#...#...#...#.....",
 ".#######.#.#####.#.#.#.#.###.#.###.#.#####.#.####",
 ".#.#.#.#...#.#.#.#.#.#.......#...#.#...#.#.#.....",
 ".#.#.#.###.#.#.#.#.#####.#####.###.###.#.#.######",
 ".....#...#.#...#...#...#...#...#...#.#.#.........",
 "####.###.#.###.###.#.###.#.#.###.###.#.#.########",
 ".......#.........#.#.#.#.#.#.#.#.........#...#...",
 ".#.###.#########.#.#.#.#.###.#.#####.#.#.#.###.##",
 ".#.#.........#.#.#.#.#.....#.#.#.....#.#.........",
 "############.#.#.#.#.#.#####.#.#.################",
 ".#...........#...#.#.#.#...#.#.#...#.#.#.....#...",
 ".#####.#####.###.#.#.#.#.###.#.#.###.#.#.#####.##",
 ".......#...#.#.#.....#...#...#.#.#.#.#...........",
 "##########.#.#.#####.#.###.###.#.#.#.#.##########",
 ".....#...#.....#.#...#.......#.#...#.......#.....",
 "##.#.###.#.###.#.#.#.#.#####.#.#.###.#######.####",
 "...#...#...#.......#.....#.#...#...#.......#.....",
 "####.#.#.#########.#.###.#.#####.###.#.#######.##",
 ".#...#...#.........#.#.....#.........#.#.#.#.....",
 ".#####.#.#.###.#######.#.###.#.#########.#.#.####",
 ".......#.#.#...#.......#.....#.#.#.......#.#.#.#.",
 "########.#.#.#.#####.#.###.#.###.#.#######.#.#.#.",
 ".........#.#.#.#.....#...#.#.........#.#.........",
 "################.#.#.#.#.#.#.#.#######.#.########",
 ".................#.#.#.#.#.#.#...........#.......",
 "########.#####.#.###.#.#.#####.###.#.#####.###.##",
 ".........#...#.#...#.#.#...#.....#.#.........#...",
 ".#####.#####.#.###.#.###.#.#.#.#.#.#####.#.###.#.",
 ".#.....#.........#.#.#...#.#.#.#.#.#.....#...#.#.",
 "####.#####.###.#.#.#.#.#.#.###.###.#.#.#.#.#####.",
 ".....#.....#.#.#.#.#.#.#.#.#...#...#.#.#.#...#...",
 "####.#.#.###.#.#.###.#.###.#.#.#####.#.#.#.######",
 ".....#.#.#.#...#...#.#...#.#.#...#...#.#.#.......",
 "##########.#.#.#.#####.###.#.#.###.#.###.#####.##",
 "...#.#...#...#.#.....#.#...#.#...#.#.#.......#...",
 ".#.#.#.#.#.#.#.#.#.#.###.#.#########.###.#.#.#.#.",
 ".#.#...#...#.#.#.#.#...#.#...#.......#...#.#.#.#.",
 "##.###.#.#.###.#.#.#.#.#####.#.#.#.###.#.########",
 ".......#.#...#.#.#.#.#.#.....#.#.#...#.#.........",
 "####.#######.#.#####.#.###.#.#.###.#.#.#.########",
 "E..#.......#.#.....#.#.#.#.#.#.#...#.#.#.........",
 "##.#.#.#.###.###.###.###.#.#.###.#.#.#.#.#######.",
 ".....#.#...#.#.....#.#.....#...#.#.#.#.#.....#..."};
		int bombs = 3;
		assertEquals(76, new BombMan().shortestPath(maze, bombs));
	}
}
