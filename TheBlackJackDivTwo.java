public class TheBlackJackDivTwo {
    public int score(String[] cards) {
        int score = 0;
        for (String card : cards) {
            char c = card.charAt(0);
            if (c >= '2' && c <= '9') score += c - '0';
            else if (c == 'T' || c == 'J' || c == 'Q' || c == 'K') score += 10;
            else if (c == 'A') score += 11;
        }
        return score;
    }
}