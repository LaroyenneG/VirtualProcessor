package processor;

public class OperationAnd extends Operation {

    public OperationAnd() {
        super(13);
    }

    @Override
    public void execute() {

        Integer[] destAddress = readAddress();
        Integer[] n1Address = readAddress();
        Integer[] n2Address = readAddress();

        Integer result = 0;

        if (processor.getMemory().getValue(n1Address).equals(1) && processor.getMemory().getValue(n2Address).equals(1)) {
            result = 1;
        }

        processor.getMemory().setValue(destAddress, result);
    }
}