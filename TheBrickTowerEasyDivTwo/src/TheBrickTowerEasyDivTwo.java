import static java.lang.Math.min;

public class TheBrickTowerEasyDivTwo {
    public int find(int redCount, int redHeight, int blueCount, int blueHeight) {
        int smallerCount = min(redCount, blueCount);
        if (redHeight == blueHeight) {
            return (redCount == blueCount) ? 2 * smallerCount : 2 * smallerCount + 1;
        }
        return (redCount == blueCount) ? 3 * smallerCount : 3 * smallerCount + 1;
    }
}
