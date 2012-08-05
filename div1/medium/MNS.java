package div1.medium;

import java.util.HashSet;
import java.util.LinkedList;

public class MNS {
    public int combos(int[] numbers) {

        String numString = "";
        for (int i : numbers) numString += i;
        LinkedList<String> allPerms = allPermutations(numString);
        int count = 0;
        HashSet<String> counted = new HashSet<String>();
        for (String permutation : allPerms) {
            if (!counted.contains(permutation)) {
                counted.add(permutation);
                int[] permutationNums = new int[permutation.length()];
                for (int i = 0; i < permutation.length(); i++) permutationNums[i] = permutation.toCharArray()[i] - '0';
                if (isMagicSquare(permutationNums)) count++;
            }
        }

        return count;
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
        for (int i = start; i < length; i++) {
            sum += permutation[i];
        }
        return sum;
    }


    LinkedList<String> allPermutations(String s) {
        LinkedList<String> result = new LinkedList<String>();

        if (s.length() == 1) {
            result.add(s);
            return result;
        }

        for (int i = 0; i < s.length(); i++) {
            String rest = s.substring(0, i) + s.substring(i + 1);
            LinkedList<String> perms = allPermutations(rest);
            for (int j = 0; j < perms.size(); j++) {
                perms.set(j, s.charAt(i) + perms.get(j));
            }
            result.addAll(perms);
        }
        return result;
    }
}
