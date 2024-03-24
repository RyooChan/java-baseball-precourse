package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class BaseballNumberGenerator {
    public final static int BASEBALL_DIGIT_LENGTH = 3;
    public final static int[] RANDOM_NUM_LIST = new int[BASEBALL_DIGIT_LENGTH];
    private final static List<Integer> BASEBALL_NUM_DIGIT_LIST = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public void makeRandomDigitList() {
        List<Integer> copy = new ArrayList<>(BASEBALL_NUM_DIGIT_LIST);
        shuffle(copy);

        for (int i = 0; i< BASEBALL_DIGIT_LENGTH; i++) {
            RANDOM_NUM_LIST[i] = copy.get(i);
        }
    }
}
