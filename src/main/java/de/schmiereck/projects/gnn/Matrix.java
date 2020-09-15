package de.schmiereck.projects.gnn;

import java.util.ArrayList;

public class Matrix {
    private ArrayList<Line> lineList = new ArrayList<>();
    private Line inputLine = null;
    private Line outputLine = null;

    public void setInputLine(final Line inputLine) {
        this.inputLine = inputLine;
    }

    public void setOutputLine(final Line outputLine) {
        this.outputLine = outputLine;
    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }

    public void addLine(final int linePos, final Line line) {
        line.setPos(linePos);
        this.lineList.add(linePos, line);
        for (int pos = linePos + 1; pos < this.lineList.size(); pos++) {
            this.lineList.get(pos).setPos(pos);
        }
    }

    public Cell getCell(final int linePos, final int cellPos) {
        final Line line;

        if (linePos < 0) {
            line = inputLine;
        } else {
            if (linePos >= this.lineList.size()) {
                line = this.outputLine;
            } else {
                line = this.lineList.get(linePos);
            }
        }

        final Cell cell;

        if (cellPos < 0) {
            cell = line.getCell(line.getSize() - 1);
        } else {
            if (cellPos >= line.getSize()) {
                cell = line.getCell(0);
            } else {
                cell = line.getCell(cellPos);
            }
        }
        return cell;
    }
}
