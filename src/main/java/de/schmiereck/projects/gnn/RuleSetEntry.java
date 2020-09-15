package de.schmiereck.projects.gnn;

public class RuleSetEntry {
    public final int pos;
    public final Character c0;
    public final Character c1;
    public final Character c2;

    public RuleSetEntry(final int pos, final Character c0, final Character c1, final Character c2) {
        this.pos = pos;
        this.c0 = c0;
        this.c1 = c1;
        this.c2 = c2;
    }
}
