import java.util.*;

/**
 * 2004 TCCC Online Round 1 - Division I, Level Two
 */

public class FlowerGarden {

    public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {

        Flower[] flowers = new Flower[height.length];
        for (int i = 0; i < height.length; i++) {
            flowers[i] = new Flower(height[i], bloom[i], wilt[i]);
        }

        Arrays.sort(flowers, new Comparator<Flower>() {
            public int compare(Flower f1, Flower f2) {
                return f1.height - f2.height;
            }
        });

        List<Flower> result = new LinkedList<Flower>();
        result.add(flowers[0]);

        for (int i = 1; i < flowers.length; i++) {
            Flower current = flowers[i];
            int insertIndex = 0;

            for (int j = 0; j < result.size(); j++) {
                // Starting from the end, if we see a flower that we would block stay behind it.
                Flower e = result.get(result.size() - 1 - j);
                if (livesOverlap(e, current)) {
                    insertIndex = result.size() - j;
                    break;
                }
            }
            result.add(insertIndex, current);
        }


        int[] resultHeights = new int[height.length];
        for (int i = 0; i < result.size(); i++) {
            resultHeights[i] = result.get(i).height;
        }
        return resultHeights;
    }

    private boolean livesOverlap(Flower f1, Flower f2) {
        return Math.min(f1.die, f2.die) >= Math.max(f1.born, f2.born);
    }

    private static class Flower {
        final int height;
        final int born;
        final int die;

        private Flower(int height, int born, int die) {
            this.height = height;
            this.born = born;
            this.die = die;
        }
    }
}

