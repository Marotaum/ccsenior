package com.ildo.rest.mars;

import java.util.ArrayList;

public class MarsValidator {
    private int BORDER_LIMIT = 5;
    private ArrayList<String> commandList = new ArrayList<String>();

    public MarsValidator(String commands){
        parse(commands);
    }

    public ArrayList<String> getCommandList(){
        return commandList;
    }

    private void parse(String commands){
        for (char letter : commands.toCharArray()) {
            if ( isCommandValid(letter) )
                commandList.add(String.valueOf(letter));
            else {
                commandList.clear();
                break;
            }
        }
    }

    public boolean isCommandListValid(){
        return commandList.size() > 0;
    }

    public boolean isFuturePositionValid(){
        Position position = new Position(0, 0, 'N');
        for (String command : this.commandList )
            position.update(command.charAt(0));

        return isPositionValid(position);
    }

    private boolean isCommandValid(char letter){
        if ("MRL".indexOf(letter) > -1)
            return true;
        else
            return false;
    }

    private boolean isPositionValid(Position position) {
        return isAxisValid(position.getX()) && isAxisValid(position.getY());
    }

    private boolean isAxisValid(int axis) {
        return axis < BORDER_LIMIT && axis >= 0;
    }
}
