package div1.easy;

import java.util.HashMap;

/**
 * Single Round Match 232 Round 1 - Division I, Level One
 * Single Round Match 232 Round 1 - Division II, Level Two
 */
public class WordFind {

    public String[] findWords(String[] grid, String[] wordList) {
        HashMap<String, String> wordPositions = new HashMap<String, String>();
        //visit lowest index rows first
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (String word : wordList) {
                    if (!wordPositions.containsKey(word)) {
                        if (wordStartsHere(word, i, j, grid)) wordPositions.put(word, i + " " + j);
                    }
                }
            }
        }
        String[] result = new String[wordList.length];
        for (int i = 0; i < wordList.length; i++) {
            if (!wordPositions.containsKey(wordList[i]))
                result[i] = "";
            else
                result[i] = wordPositions.get(wordList[i]);
        }
        return result;
    }

    private boolean wordStartsHere(String word, int row, int column, String[] grid) {
        //horizontal
        if (column + word.length() <= grid[0].length() &&
                grid[row].substring(column, column + word.length()).equals(word))
            return true;
        //vertical
        if (row + word.length() <= grid.length) {
            char[] found = new char[word.length()];
            for (int i = 0; i < word.length(); i++) found[i] = grid[row + i].charAt(column);
            if (new String(found).equals(word)) return true;
        }
        //diagonally
        if (column + word.length() <= grid[0].length() && row + word.length() <= grid.length) {
            char[] found = new char[word.length()];
            for (int i = 0; i < word.length(); i++) found[i] = grid[row + i].charAt(column + i);
            if (new String(found).equals(word)) return true;
        }

        return false;
    }
}
