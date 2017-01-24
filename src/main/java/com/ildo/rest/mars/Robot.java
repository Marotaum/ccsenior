package com.ildo.rest.mars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ildo on 1/24/2017.
 */
public class Robot {

    private Position position;

    public Robot( Position position ){
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    public boolean executeCommands(ArrayList<String> commandList){
        boolean statusExecution = false;
        for (String command : commandList ) {
            statusExecution = executeCommand(command.charAt(0));
            if ( !statusExecution )
                break;
        }
        return statusExecution;
    }

    private boolean executeCommand(char command){
        boolean engineExecution = this.executeFakeEngine(command);
        if ( engineExecution )
            this.position.update(command);

        return engineExecution;
    }

    /*
    Here we can implement any kind of operation
     */
    private boolean executeFakeEngine(char command){
        return true;
    }

}
