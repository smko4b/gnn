package de.schmiereck.projects.gnn;

public class Cell {
    private int pos;
    private Character status = null;
    private final Rules rules;

    public Cell(final RuleSet ruleSet, final Character status) {
        this.rules = new Rules(ruleSet);
        this.status = status;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(final int pos) {
        this.pos = pos;
    }

    public Rules getRules() {
        return this.rules;
    }

    public Character getStatus() {
        return this.status;
    }

    public void setStatus(final Character status) {
        this.status = status;
    }

    public void setRule(final Character status, final Character c0, final Character c1, final Character c2) {
        rules.setRule(status, c0, c1, c2);
    }
}
