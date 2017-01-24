package com.ildo.rest.mars;

public class Position {
    private int x;
    private int y;
    private char direction;
    private final Compass compass;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.compass = new Compass();
    }

    public void update(char command) {
        if (command == 'M')
            this.forward();
        else if ("RL".indexOf(command) > -1)
            this.rotate(command);
    }

    private void rotate(char corner) {
        direction = compass.getSibling(direction, corner);
    }

    private void forward() {
        if ("NS".indexOf(direction) > -1)
            y = y + calculateChange();
        else
            x = x + calculateChange();
    }

    private int calculateChange() {
        return "NE".indexOf(direction) > -1 ? 1 : -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + direction + ")";
    }
}
