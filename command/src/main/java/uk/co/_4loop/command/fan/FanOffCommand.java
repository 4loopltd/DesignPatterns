package uk.co._4loop.command.fan;

import uk.co._4loop.command.Command;

public class FanOffCommand implements Command {
    private final Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.stopRotate();
    }
}
