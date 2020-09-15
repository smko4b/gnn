package de.schmiereck.projects.gnn;

import java.util.ArrayList;

public class RuleSet {
    private ArrayList<RuleSetEntry> ruleList = new ArrayList<>();

    public RuleSet(final Character[] characters) {
        for (final Character character0 : characters) {
            for (final Character character1 : characters) {
                for (final Character character2 : characters) {
                    this.ruleList.add(new RuleSetEntry(this.ruleList.size(), character0, character1, character2));
                }
            }
        }
    }

    public ArrayList<RuleSetEntry> getRuleList() {
        return ruleList;
    }
}
