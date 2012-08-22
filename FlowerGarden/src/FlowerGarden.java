import java.util.Arrays;
import java.util.Comparator;

/**
 * 2004 TCCC Online Round 1 - Division I, Level Two
 */

public class FlowerGarden {


    private Flower[] flowers;

    public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
        flowers = new Flower[height.length];
        for (int i = 0; i < height.length; i++) {
            flowers[i] = new Flower(height[i], bloom[i], wilt[i]);
        }


        Arrays.sort(flowers, new Comparator<Flower>() {
            public int compare(Flower f1, Flower f2) {
                if (livesOverlap(f1, f2)) {
                    f1.born = f2.born = Math.min(f1.born, f2.born);
                    f1.die = f2.die = Math.max(f1.die, f2.die);
                    return f1.height - f2.height;

                } else return (f2.height - f1.height);
            }
        });

        int[] order = new int[flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            order[i] = flowers[i].height;
        }
        return order;
    }

    private boolean livesOverlap(Flower f1, Flower f2) {
        return Math.min(f1.die, f2.die) >= Math.max(f1.born, f2.born);
    }


    private static class Flower {
        int height;
        int born;
        int die;

        private Flower(int height, int born, int die) {
            this.height = height;
            this.born = born;
            this.die = die;
        }
    }
}
