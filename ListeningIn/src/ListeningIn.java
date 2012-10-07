public class ListeningIn {
    public String probableMatch(String typed, String phrase) {
        return match("", typed, phrase);
    }

    private String match(String acc, String typed, String phrase) {
        if (typed.equals("")) return acc + phrase;
        char next = typed.charAt(0);
        int index = phrase.indexOf(next);
        if (index == -1) return "UNMATCHED";
        return match(acc + phrase.substring(0, index), typed.substring(1), phrase.substring(index + 1));

    }
}
