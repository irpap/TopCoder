import java.util.LinkedList;
import java.util.List;

/**
 * Single Round Match 146 Round 1 - Division II, Level Three
 */
public class BridgeCrossing {
    public int minTime(int[] times) {
        LinkedList<Integer> sideA = new LinkedList<Integer>();
        for (int t : times) sideA.add(t);
        return movePeople(sideA, new LinkedList<Integer>(), true);
    }

    /**
     * returns the min time to move the people from sideA to sideB
     */
    int movePeople(List<Integer> sideA, List<Integer> sideB, boolean torchIsAtSideA) {
        int minTime = Integer.MAX_VALUE;

        if (torchIsAtSideA) {
            if (sideA.isEmpty()) return 0;
            if (sideA.size() == 1) return sideA.get(0);

            for (int i = 0; i < sideA.size(); i++) {
                for (int j = i + 1; j < sideA.size(); j++) {
                    Integer person1 = sideA.get(i);
                    Integer person2 = sideA.get(j);

                    LinkedList<Integer> newA = new LinkedList<Integer>(sideA);
                    LinkedList<Integer> newB = new LinkedList<Integer>(sideB);

                    newA.remove(person1);
                    newA.remove(person2);

                    newB.add(person1);
                    newB.add(person2);

                    int time = Math.max(person1, person2) + movePeople(newA, newB, !torchIsAtSideA);
                    minTime = Math.min(minTime, time);

                }
            }
        } else {
            if (sideB.isEmpty() || sideA.isEmpty()) return 0;
            for (int i = 0; i < sideB.size(); i++) {
                Integer personToMove = sideB.get(i);

                LinkedList<Integer> newA = new LinkedList<Integer>(sideA);
                LinkedList<Integer> newB = new LinkedList<Integer>(sideB);

                newB.remove(personToMove);
                newA.add(personToMove);

                int time = personToMove + movePeople(newA, newB, !torchIsAtSideA);
                minTime = Math.min(minTime, time);

            }
        }
        return minTime;
    }
}
