package test.task.java.controller.command;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final String COMMAND_USERS = "users";
    public static final String COMMAND_ADD_USER = "add_user";
    public static final String COMMAND_FIND_USER = "find_user";
    public static final String COMMAND_UPDATE_USER = "update_user";
    public static final String COMMAND_SHOW_USER = "show_user";

    private static CommandFactory instance;

    private Map<String, Command> commands;

    private CommandFactory(){
        commands = new HashMap<String, Command>();
        commands.put(COMMAND_USERS, new CommandGetUsers());
        commands.put(COMMAND_ADD_USER, new CommandAddUser());
        commands.put(COMMAND_FIND_USER, new CommandFind());
        commands.put(COMMAND_UPDATE_USER, new CommandUpdateUser());
        commands.put(COMMAND_SHOW_USER, new CommandShowUser());
    }

    public static CommandFactory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommands(String command) {
        return commands.get(command);
    }
}
