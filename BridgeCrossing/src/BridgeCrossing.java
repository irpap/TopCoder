import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

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

                    move(person1, sideA, sideB);
                    move(person2, sideA, sideB);

                    minTime = min(minTime, max(person1, person2) + movePeople(sideA, sideB, !torchIsAtSideA));

                    move(person1, sideB, sideA);
                    move(person2, sideB, sideA);
                }
            }
        } else {
            if (sideB.isEmpty() || sideA.isEmpty()) return 0;
            for (int i = 0; i < sideB.size(); i++) {
                Integer personToMove = sideB.get(i);

                move(personToMove, sideB, sideA);

                minTime = min(minTime, personToMove + movePeople(sideA, sideB, !torchIsAtSideA));

                move(personToMove, sideA, sideB);
            }
        }
        return minTime;
    }

    private void move(Integer person, List<Integer> from, List<Integer> to) {
        from.remove(person);
        to.add(person);
    }
}
