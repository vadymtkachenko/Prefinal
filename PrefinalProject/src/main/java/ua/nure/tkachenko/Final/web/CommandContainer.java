package ua.nure.tkachenko.Final.web;


import ua.nure.tkachenko.Final.web.command.LoginCommand;
import ua.nure.tkachenko.Final.web.command.sign.Register;


import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    //private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        // common commands
        commands.put("register", new Register());
        commands.put("login", new LoginCommand());
//        commands.put("logout", new LogoutCommand());
//        commands.put("viewSettings", new ViewSettingsCommand());
//        commands.put("noCommand", new NoCommand());
//        // client commands
//        commands.put("listMenu", new ListMenuCommand());
//        // admin commands
//        commands.put("listOrders", new ListOrdersCommand());

      // LOG.debug("Command container was successfully initialized");
        //LOG.trace("Number of commands --> " + commands.size());
    }

    /**
     * Returns command object with the given name.
     *
     * @param commandName
     *            Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName) {
        if (commandName == null || commandName.isEmpty()) {
           // LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}