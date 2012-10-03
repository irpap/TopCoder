public class XorBoardDivTwo {
    public int theMax(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = board[i].charAt(j) - '0';
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            flipRow(i, a);
            for (int j = 0; j < m; j++) {
                flipColumn(j, a);
                max = Math.max(max, ones(a));
                flipColumn(j, a);
            }
            flipRow(i, a);
        }
        return max;
    }

    private void flipColumn(int col, int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i][col] = (a[i][col] == 1) ? 0 : 1;
        }
    }

    private void flipRow(int row, int[][] a) {
        for (int i = 0; i < a[row].length; i++) {
            a[row][i] = (a[row][i] == 1) ? 0 : 1;
        }
    }

    private int ones(int[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) count++;
            }
        }
        return count;
    }
}
