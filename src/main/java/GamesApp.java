import commands.CommandOptions;
import commands.GamesWorker;

import java.util.*;

import static java.lang.Thread.sleep;

public class GamesApp {
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public static void main(String[] args) {
        GamesApp gamesApp = new GamesApp();
        gamesApp.start();
    }

    private void start() {
        System.out.println("Games - Samet Halili");
        while (running){
            try {
                showAvailableCommands();
                Optional<CommandOptions> commandOption = getCommandOption();
                commandOption.ifPresent(commandOptions -> new GamesWorker().doWork(commandOptions.getCommand()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Optional<CommandOptions> getCommandOption() throws InterruptedException {
        System.out.print("Choose a command:");
        int commandNumber;
        if (scanner.hasNextInt()) commandNumber = scanner.nextInt();
        else {
            commandNumber = -1;
            scanner.next();
            String s = "";
        }

        if (commandNumber == 0) {
            running = false;
            return Optional.empty();
        }

        Optional<CommandOptions> optionalCommandOptions = Arrays.stream(CommandOptions.values())
                .filter(commandOptions -> commandOptions.ordinal() == commandNumber - 1)
                .findFirst();
        if (optionalCommandOptions == null) {
            System.err.println("Give in a correct number!");
            sleep(1500);
            start();
        }
        return optionalCommandOptions;
    }


    public void showAvailableCommands() {
        System.out.println("Menu");
        Arrays.stream(CommandOptions.values())
                .forEach(commandOptions -> System.out.println((commandOptions.ordinal()+ 1) + ". " + commandOptions.getDescription()));
        System.out.println("0: Exit");
    }
}
