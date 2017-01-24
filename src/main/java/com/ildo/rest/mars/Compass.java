package com.ildo.rest.mars;

import java.util.Arrays;
import java.util.List;

public class Compass {
    private static final List<Character> SPOTS = Arrays.asList('N', 'E', 'S', 'W');

    private int indexOf(char point) {
        return SPOTS.indexOf(point);
    }

    public char getSibling(char point, char direction) {
        return SPOTS.get(fixOverlap(getNext(direction, indexOf(point))));
    }

    private int fixOverlap(int index) {
        if (index == -1)
            return 3;
        if (index == 4)
            return 0;
        return index;
    }

    private int getNext(char direction, int index) {
        if (direction == 'L')
            return index - 1;
        return index + 1;
    }
}
