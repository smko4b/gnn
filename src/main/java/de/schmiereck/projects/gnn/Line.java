package de.schmiereck.projects.gnn;

import java.util.ArrayList;

public class Line {
    private int pos;
    private ArrayList<Cell> cellList = new ArrayList<>();

    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    public void addCell(final Cell cell) {
        cell.setPos(this.cellList.size());
        this.cellList.add(cell);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(final int pos) {
        this.pos = pos;
    }

    public int getSize() {
        return this.cellList.size();
    }

    public Cell getCell(final int cellPos) {
        return this.cellList.get(cellPos);
    }
}
