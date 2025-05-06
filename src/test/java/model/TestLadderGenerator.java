package model;

import java.util.List;
import util.LadderGenerator;

public class TestLadderGenerator implements LadderGenerator {

    private final List<Boolean> values;
    private int index = 0;

    public TestLadderGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        boolean value = values.get(index);
        index++;
        if (index >= values.size()) {
            index = 0;
        }
        return value;
    }
}
