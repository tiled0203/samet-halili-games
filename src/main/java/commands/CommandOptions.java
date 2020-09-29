package commands;

public enum CommandOptions {
    SHOW_FIRST_CAT("Show first game category", new ShowFirstCat());

    private final String description;
    private final Command command;

    CommandOptions(String description, Command command) {
        this.description = description;
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return command;
    }
}
