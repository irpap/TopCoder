import java.util.Arrays;

public class SuperSort {
    public String wordSort(String sentence) {
        //save punctuation
        //sort words case sensitively
        //create result string by putting punctuation back
        String[] words = sentence.split("[^a-zA-Z]+");
        String[] punctuation = sentence.split("[a-zA-Z]+");
        if (words.length == 0) return join(punctuation);
        if (punctuation.length == 0) return join(words);
        Arrays.sort(words);

        int wordIndex = 0;
        int punctIndex = 0;

        StringBuffer result = new StringBuffer();
        boolean startsWithPunctuation = words[0].equals("");
        if (startsWithPunctuation) wordIndex++; else punctIndex++;

        while (wordIndex < words.length || punctIndex < punctuation.length) {
            if (startsWithPunctuation) {
                if (punctIndex < punctuation.length) result.append(punctuation[punctIndex++]);
                if (wordIndex < words.length) result.append(words[wordIndex++]);
            } else {
                if (wordIndex < words.length) result.append(words[wordIndex++]);
                if (punctIndex < punctuation.length) result.append(punctuation[punctIndex++]);
            }
        }
        return result.toString();
    }

    private String join(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();

    }
}
