package uk.co._4loop.command;

public class Switch {
    private final Command upCommand;
    private final Command downCommand;

    public Switch(Command upCommand, Command downCommand) {
        this.upCommand = upCommand;
        this.downCommand = downCommand;
    }

    public void flipUp() {
        upCommand.execute();
    }

    public void flipDown() {
        downCommand.execute();
    }
}