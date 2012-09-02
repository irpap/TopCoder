public class LotteryTicket {
    public String buy(int price, int b1, int b2, int b3, int b4) {
        int[] notes = {b1, b2, b3, b4};
        //Check all subsets
        for (int i = 0; i <= Integer.valueOf("1111", 2); i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                if ((1 << j & i) != 0) sum += notes[j];
            }
            if (sum == price) return "POSSIBLE";
        }
        return "IMPOSSIBLE";
    }
}
