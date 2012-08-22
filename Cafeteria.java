public class Cafeteria {
    static final int TWOTHIRTY = 14 * 60 + 30;

    public String latestTime(int[] offset, int[] walkingTime, int[] drivingTime) {
        int latestDeparture = 0;
        for (int i = 0; i < drivingTime.length; i++) {
            int latestTimeToBeAtBusStop = TWOTHIRTY - drivingTime[i];

            int latestMinute = latestTimeToBeAtBusStop % 60;
            int latestBusToCatch = 0;
            int busOffset = offset[i];
            if (busOffset > latestMinute) {
                //need to get the last of the previous hour
                latestBusToCatch = (busOffset + 50) + 60 * ((latestTimeToBeAtBusStop / 60) - 1);
            } else {
                int j = busOffset;
                for (; j < 60; j += 10) {
                    if (j <= latestMinute && (j + 10) > latestMinute) break;
                }
                latestBusToCatch = 60 * (latestTimeToBeAtBusStop / 60) + j;
            }
            latestDeparture = Math.max(latestBusToCatch - walkingTime[i], latestDeparture);
        }

        int hour = (latestDeparture / 60) % 12 == 0 && latestDeparture / 60 > 0 ? 12 : (latestDeparture / 60) % 12;
        int minute = latestDeparture % 60;

        StringBuilder answer = new StringBuilder();
        if (hour <10) answer.append("0"); answer.append(hour).append(":");
        if (minute <10) answer.append("0"); answer.append(minute);
        return answer.toString();
    }
}
