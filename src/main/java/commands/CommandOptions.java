package commands;

public enum CommandOptions {
    SHOW_FIRST_CAT("Show the first game category", new ShowFirstCat()),
    SHOW_FIFTH_GAME("Show the fifth game", new ShowFifthGame());

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
