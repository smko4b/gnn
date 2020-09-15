package de.schmiereck.projects.gnn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rules {
    private final RuleSet ruleSet;
    private final Rule[] ruleList;

    public Rules(final RuleSet ruleSet) {
        this.ruleSet = ruleSet;
        this.ruleList = new Rule[this.ruleSet.getRuleList().size()];
    }

    public void setRule(final Character outputStatus, final Character c0, final Character c1, final Character c2) {
        final RuleSetEntry ruleSetEntry = findRuleSetEntry(c0, c1, c2);

        if (Objects.isNull(ruleSetEntry)) {
            throw new RuntimeException("Found no RuleSetEntry for c0, c1, c2.");
        }

        final Rule rule = this.ruleList[ruleSetEntry.pos];

        if (Objects.nonNull(rule)) {
            rule.outputStatus = outputStatus;
        } else {
            ruleList[ruleSetEntry.pos] = new Rule(outputStatus);
        }
    }

    public RuleSetEntry findRuleSetEntry(final Character status0, final Character status1, final Character status2) {
        final RuleSetEntry retRuleSetEntry;

        final List<RuleSetEntry> foundRuleSetEntryList = //
                this.ruleSet.getRuleList().stream(). //
                        filter  //
                        (       //
                                rule -> Objects.equals(rule.c0, status0) && //
                                        Objects.equals(rule.c1, status1) && //
                                        Objects.equals(rule.c2, status2) //
                        ).collect(Collectors.toUnmodifiableList());

        if (!foundRuleSetEntryList.isEmpty()) {
            retRuleSetEntry = foundRuleSetEntryList.get(0);
        } else {
            retRuleSetEntry = null;
        }
        return retRuleSetEntry;
    }

    public Rule findRule(final Character status0, final Character status1, final Character status2) {
        final Rule retRule;

        final RuleSetEntry ruleSetEntry = findRuleSetEntry(status0, status1, status2);

        if (Objects.nonNull(ruleSetEntry)) {
            retRule = this.ruleList[ruleSetEntry.pos];
        } else {
            retRule = null;
        }
        return retRule;
    }
}
