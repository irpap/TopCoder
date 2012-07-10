public class Time {
    public String whatTime(int seconds) {


        int secs = seconds %60;
        int rest = seconds / 60;
        int mins = rest %60;
        rest = rest /60;
        return rest + ":" + mins + ":" + secs;

    }


}