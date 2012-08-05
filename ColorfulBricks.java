public class ColorfulBricks {

    public int countLayouts(String bricks) {
        boolean[] colors = new boolean[26];
        for (char c : bricks.toCharArray()) {
            colors[c - 'A'] = true;
        }
        int count = 0;
        for (boolean c : colors) if (c) count++;

        if (count == 2) return 2;
        if (count == 1) return 1;
        return 0;
    }
}
