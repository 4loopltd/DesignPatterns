package uk.co._4loop.command.fan;

import uk.co._4loop.command.Command;

public class FanOnCommand implements Command {
    private final Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.startRotate();
    }
}
