import java.util.ArrayList;
import java.util.Collections;

/** SRM 144 */
public class Lottery {

    long[][] pascalTriangle;

    public String[] sortByOdds (String[] rules) {
        this.pascalTriangle = createPascalTriangle(101);
        ArrayList<Rule> r = readRules(rules);
        Collections.sort(r);
        ArrayList<LotteryNumberOfTickets> sorted = new ArrayList<LotteryNumberOfTickets>();
        for (Rule rule : r) {
            sorted.add(new LotteryNumberOfTickets(rule.name, numberOfTickets(rule)));
        }
        Collections.sort(sorted);
        String[] sortedNames = new String[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
            sortedNames[i] = sorted.get(i).name;
        }
        return sortedNames;
    }

    private ArrayList<Rule> readRules (String[] rules) {
        ArrayList<Rule> r = new ArrayList<Rule>(rules.length);
        for (String s : rules) {
            String[] nameAndRest = s.split(":");
            String name = nameAndRest[0];
            String[] rest = nameAndRest[1].split(" ");
            int choices = Integer.parseInt(rest[1]);
            int blanks = Integer.parseInt(rest[2]);
            boolean sorted = !rest[3].equals("F");
            boolean unique = !rest[4].equals("F");
            Rule rule = new Rule(name, choices, blanks, sorted, unique);
            r.add(rule);
        }
        return r;
    }

    private class LotteryNumberOfTickets implements Comparable {
        String name;
        long numberOfTickets;

        public LotteryNumberOfTickets (String name, long numberOfTickets) {
            this.name = name;
            this.numberOfTickets = numberOfTickets;
        }

        public int compareTo (Object o) {
            return new Long(numberOfTickets).compareTo(((LotteryNumberOfTickets) o).numberOfTickets);
        }
    }

    private class Rule implements Comparable {
        private Rule (String name, int choices, int blanks, boolean sorted, boolean unique) {
            this.name = name;
            this.choices = choices;
            this.blanks = blanks;
            this.sorted = sorted;
            this.unique = unique;
        }

        public String name;
        public int choices;
        public int blanks;
        public boolean sorted;
        public boolean unique;

        public int compareTo (Object o) {
            return name.compareTo(((Rule) o).name);
        }
    }

    /** Rules:
     * TT : n choose k
     * FT: (n choose k) k!
     * TF: (n+k-1) choose k
     * FF: choices^blanks */
    private long numberOfTickets (Rule rule) {

        if (rule.sorted && rule.unique) {
            return choose(rule.choices, rule.blanks);
        } else if (!rule.sorted && rule.unique) {
            return choose(rule.choices, rule.blanks) * fac(rule.blanks);
        } else if (rule.sorted && !rule.unique) {
            return choose(rule.choices + rule.blanks - 1, rule.blanks);
        } else {
            return (long) Math.pow(rule.choices, rule.blanks);
        }
    }

    private long fac (int n) {
        if (n == 1) { return 1; }
        return n * fac(n - 1);
    }

    private long choose (int n, int k) {
        return pascalTriangle[n][k];
    }

    private long[][] createPascalTriangle (int n) {
        long[][] triangle = new long[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new long[i + 1];
            triangle[i][0] = 1L;
            triangle[i][i] = 1L;
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }
}
