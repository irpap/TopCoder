package div1.medium;

import java.util.HashSet;
import java.util.LinkedList;

public class MNS {

    static int N;

    public int combos(int[] numbers) {
        N = numbers.length;
        LinkedList<Integer> numbersList = new LinkedList<Integer>();
        for (int n : numbers) numbersList.add(n);
        LinkedList<LinkedList<Integer>> allPerms = allPermutations(numbersList);
        int count = 0;
        HashSet<String> counted = new HashSet<String>();
        for (LinkedList<Integer> permutation : allPerms) {
            if (!counted.contains(permutation.toString())) {
                counted.add(permutation.toString());
                Integer[] permArray = permutation.toArray(new Integer[permutation.size()]);
                if (isMagicSquare(permArray)) count++;
            }
        }

        return count;
    }

    private boolean isMagicSquare(Integer[] permutation) {
        int size = (int) Math.sqrt(permutation.length);
        int sum = rowSum(permutation, 0, size);
        for (int i = 1; i < size; i++) {
            if (sum != rowSum(permutation, i, size)) return false;
            if (sum != columnSum(permutation, i, size)) return false;
        }
        return true;
    }

    private int columnSum(Integer[] permutation, int start, int length) {
        int sum = 0;
        for (int i = start; i < permutation.length; i += length) {
            sum += permutation[i];
        }
        return sum;
    }

    private int rowSum(Integer[] permutation, int start, int length) {
        int sum = 0;
        for (int i = start * length; i < start * length + length; i++) {
            sum += permutation[i];
        }
        return sum;
    }

    LinkedList<LinkedList<Integer>> allPermutations(LinkedList<Integer> seq) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        if (seq.size() == 1) {
            result.add(seq);
            return result;
        }
        for (int i = 0; i < seq.size(); i++) {
            Integer first = seq.get(i);
            LinkedList<Integer> rest = new LinkedList<Integer>(seq);
            rest.remove(first);
            LinkedList<LinkedList<Integer>> restPermutations = allPermutations(rest);
            for (LinkedList<Integer> perm : restPermutations) {
                perm.addFirst(first);
                result.add(perm);
            }
        }
        return result;
    }


}
