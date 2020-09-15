package de.schmiereck.projects.gnn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) {
        System.out.println("gnn V1.0.0");

        final RuleSet ruleSet = new RuleSet(new Character[] { null, '0', '1' });

        final Matrix matrix = new Matrix();

        {
            final Line inputLine = new Line();
            final Character[] inputArr = new Character[]{
                    '1',
                    '0',
                    null
            };

            Arrays.stream(inputArr).forEach(c -> inputLine.addCell(new Cell(ruleSet, c)));
            matrix.setInputLine(inputLine);
        }
        {
            final Line line = new Line();
            {
                final Cell cell = new Cell(ruleSet, null);
                cell.setRule('1', null, '1', '0');
                line.addCell(cell);
            }
            {
                final Cell cell = new Cell(ruleSet, null);
                cell.setRule('1', '1', '0', null);
                line.addCell(cell);
            }
            {
                final Cell cell = new Cell(ruleSet, null);
                cell.setRule('0', '0', null, '1');
                line.addCell(cell);
            }
            matrix.addLine(0, line);
        }
        {
            final Line outputLine = new Line();
            final Character[] inputArr = new Character[]{
                    '1',
                    null,
                    null
            };

            Arrays.stream(inputArr).forEach(c -> outputLine.addCell(new Cell(ruleSet, c)));
            matrix.setOutputLine(outputLine);
        }

        calcOutput(matrix);

        System.out.println("------------------");
        matrix.getLineList().stream().forEach(line -> {
            line.getCellList().stream().forEach(cell -> {
                final Character status = cell.getStatus();
                if (Objects.nonNull(status)) {
                    System.out.print(status);
                } else {
                    System.out.print("-");
                }
            });
            System.out.println();
        });
        System.out.println("------------------");
    }

    private static void calcOutput(final Matrix matrix) {
        matrix.getLineList().stream().forEach(line -> calcOutput(matrix, line));
    }

    private static void calcOutput(final Matrix matrix, final Line line) {
        line.getCellList().stream().forEach(cell -> calcOutput(matrix, line, cell));
    }

    private static void calcOutput(final Matrix matrix, final Line line, final Cell cell) {
        final Cell[] inputCells = new Cell[3];

        inputCells[0] = matrix.getCell(line.getPos() - 1, cell.getPos() - 1);
        inputCells[1] = matrix.getCell(line.getPos() - 1, cell.getPos());
        inputCells[2] = matrix.getCell(line.getPos() - 1, cell.getPos() + 1);

        final Rules rules = cell.getRules();

        final Rule rule = rules.findRule(inputCells[0].getStatus(), inputCells[1].getStatus(), inputCells[2].getStatus());

        if (Objects.nonNull(rule)) {
            cell.setStatus(rule.outputStatus);
        }
    }
}
