import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class FavouriteDigits {

    public long findNext(long N, int digit1, int count1, int digit2, int count2) {
        final String number = String.valueOf(N);
        final LinkedList<Character> needToAdd = digitsToAdd(digit1, count1, digit2, count2, number);

        Collections.sort(needToAdd);
        Collections.reverse(needToAdd);

        final ArrayList<Character> characters = toList(number);
        Collections.reverse(characters);

        Character next = needToAdd.poll();
        int startFrom = 0;
        while (next != null) {
            startFrom = replace(digit1, digit2, characters, next, startFrom);
            next = needToAdd.poll();
        }

        Collections.reverse(characters);

        return toLong(characters);

    }

    private ArrayList<Character> toList(String number) {
        final ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : number.toCharArray()) characters.add(c);
        return characters;
    }

    private LinkedList<Character> digitsToAdd(int digit1, int count1, int digit2, int count2, String number) {
        int existingDigit1s = number.length() - number.replaceAll(String.valueOf(digit1), "").length();
        int existingDigit2s = number.length() - number.replaceAll(String.valueOf(digit2), "").length();

        final LinkedList<Character> needToAdd = new LinkedList<Character>();
        for (int i = 0; i < count1 - existingDigit1s; i++) {
            needToAdd.add((char) toChar(digit1));
        }
        for (int i = 0; i < count2 - existingDigit2s; i++) {
            needToAdd.add((char) toChar(digit2));
        }
        return needToAdd;
    }

    private long toLong(ArrayList<Character> characters) {
        final StringBuilder builder = new StringBuilder(characters.size());
        for (Character character : characters) {
            builder.append(character);
        }
        final String stringResult = builder.toString();
        return Long.parseLong(stringResult);
    }


    private int replace(int digit1, int digit2, ArrayList<Character> chars, char nextToInsert, int startIndex) {
        for (int i = startIndex; i < chars.size(); i++) {
            final char c = chars.get(i);
            if (c < nextToInsert && c != toChar(digit1) && c != toChar(digit2)) {
                chars.set(i, nextToInsert);
                return i;
            }
        }
        chars.add(nextToInsert);
        return chars.size() - 1;
    }

    private char toChar(int digit1) {
        return (char) (digit1 + '0');
    }
}
