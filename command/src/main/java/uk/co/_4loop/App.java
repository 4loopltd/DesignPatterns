package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.command.Switch;
import uk.co._4loop.command.fan.Fan;
import uk.co._4loop.command.fan.FanOffCommand;
import uk.co._4loop.command.fan.FanOnCommand;
import uk.co._4loop.command.light.Light;
import uk.co._4loop.command.light.LightOffCommand;
import uk.co._4loop.command.light.LightOnCommand;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Light light = new Light();
        LightOnCommand loc = new LightOnCommand(light);
        LightOffCommand lfc = new LightOffCommand(light);

        Switch lightSwitch = new Switch(loc, lfc);
        lightSwitch.flipUp();
        lightSwitch.flipDown();

        Fan fan = new Fan();
        FanOnCommand foc = new FanOnCommand(fan);
        FanOffCommand ffc = new FanOffCommand(fan);

        Switch fanSwitch = new Switch(foc, ffc);
        fanSwitch.flipUp();
        fanSwitch.flipDown();

    }

}