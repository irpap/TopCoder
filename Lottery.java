/*
 * -----------------------------------------------------------------------
 *
 * QATARLYST LIMITED
 *
 * -----------------------------------------------------------------------
 *
 * (C) Copyright 2012 Qatarlyst Limited. All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant hereto is,
 *          and remains, the property of Qatarlyst Limited.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Qatarlyst Limited. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Qatarlyst Limited.
 *
 * -----------------------------------------------------------------------
 */

import java.util.ArrayList;

public class Lottery {
    public String[] sortByOdds(String[] rules) {
        ArrayList<Rule> r = readRules(rules);
        return null;
    }

    private ArrayList<Rule> readRules(String[] rules) {
        ArrayList<Rule> r = new ArrayList<Rule>(rules.length);
        for (String s : rules) {
            String[] nameAndRest = s.split(":");
            String name = nameAndRest[0];
            String[] rest = nameAndRest[1].split(" ");
            int choices = Integer.parseInt(rest[1]);
            int blanks = Integer.parseInt(rest[2]);
            boolean sorted = rest[3].equals("F") ? false : true;
            boolean unique = rest[4].equals("F") ? false : true;
            Rule rule = new Rule(name, choices, blanks, sorted, unique);
            r.add(rule);
        }
        return r;
    }

    private class Rule {
        private Rule(String name, int choices, int blanks, boolean sorted, boolean unique) {
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
    }
}
