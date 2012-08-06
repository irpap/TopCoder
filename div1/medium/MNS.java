package div1.medium;

import java.util.HashSet;

public class MNS {

    static int N;
    private HashSet<Integer> counted;

    public int combos(int[] numbers) {
        N = numbers.length;
        counted = new HashSet<Integer>();
        uniqueMagicSquarePermutationsCount(numbers, 0);
        return counted.size();
    }


    private boolean isMagicSquare(int[] permutation) {
        int size = (int) Math.sqrt(permutation.length);
        int sum = rowSum(permutation, 0, size);
        for (int i = 1; i < size; i++) {
            if (sum != rowSum(permutation, i, size)) return false;
            if (sum != columnSum(permutation, i, size)) return false;
        }
        return true;
    }

    private int columnSum(int[] permutation, int start, int length) {
        int sum = 0;
        for (int i = start; i < permutation.length; i += length) {
            sum += permutation[i];
        }
        return sum;
    }

    private int rowSum(int[] permutation, int start, int length) {
        int sum = 0;
        for (int i = start * length; i < start * length + length; i++) {
            sum += permutation[i];
        }
        return sum;
    }

    void uniqueMagicSquarePermutationsCount(int[] seq, int index) {
        if (index == 8) {
            if (isMagicSquare(seq)){
                Integer value = 0;
                for (int n : seq) value = value * 10 + n;
                counted.add(value);
            }
        } else {
            for (int i = index; i < 9; i++) {
                swap(index, i, seq);
                uniqueMagicSquarePermutationsCount(seq, index + 1);
                swap(index, i, seq);
            }
        }
    }



    private void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}