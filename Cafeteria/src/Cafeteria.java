import java.util.*;

public class Cafeteria {
    static final int MINSINDAY = 1440;
    static final int TWOTHIRTY = 870;

    public String latestTime(int[] offset, int[] walkingTime, int[] drivingTime) {
        int latestDeparture = 0;
        //departure minute, if there if all buses would arrive exactly at 2:30
        for (int i = 0; i < drivingTime.length; i++) {
            drivingTime[i] = TWOTHIRTY - drivingTime[i] - walkingTime[i];

            int minutesAfterHour = drivingTime[i] % 60;
            int latestBusToCatch = 0;
            int curOffset = offset[i];
            if (curOffset > minutesAfterHour) {
                //need to get the last for the previous hour
                latestBusToCatch = (curOffset + 50) + 60 * ((drivingTime[i] / 60) - 1);
            } else {
                int j = curOffset;
                for (; j < 60; j += 10) {
                    if (j <= minutesAfterHour && (j + 10) > minutesAfterHour) break;
                }
                latestBusToCatch = 60 * (drivingTime[i] / 60) + j;
            }
            latestDeparture = Math.max(latestBusToCatch, latestDeparture);
        }
        StringBuilder answer = new StringBuilder();

        int hour = (latestDeparture / 60) % 24;
        int minute = latestDeparture % 60;
        if (hour >=10) answer.append(hour); else answer.append("0").append(hour);
        answer.append(":");
        if (minute >=10) answer.append(minute); else answer.append("0").append(minute);
        return answer.toString();
    }
}
