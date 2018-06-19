package processor;

import java.util.*;

public class Processor {

    public static final int ADDRESS_SIZE = 12;

    private int cursor;
    private List<Vector<Integer>> program;
    private Map<Integer, Operation> operations;
    private Memory memory;

    public Processor() {
        cursor = 0;
        program = new ArrayList<>();
        operations = new HashMap<>();
        memory = new Memory();
    }

    public void moveCursor(int value) {
        cursor += value;
    }

    public void execute() {

        while (cursor < program.size()) {
            Vector<Integer> line = program.get(cursor);

            Operation operation = operations.get(line.get(0));

            if (operation == null) {
                System.err.println("invalid operation");
                System.exit(-3);
            }

            for (int i = 1; i < line.size(); i++) {
                operation.addParameters(line.get(i));
            }

            operation.setProcessor(this);

            operation.execute();

            cursor++;
        }
    }

    public Memory getMemory() {
        return memory;
    }

    public void setupNewInstruction(Operation operation) {
        operations.put(operation.getCode(), operation);
    }

    public void addNewCommand(Vector<Integer> line) {

        program.add(line);
    }
}