package games.commands;

public class GamesWorker {
    public void doWork(Command command){
        command.execute();
    }
}
