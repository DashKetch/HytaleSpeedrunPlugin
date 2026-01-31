package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.server.core.command.system.AbstractCommand;

public abstract class SpeedrunStartCommand extends AbstractCommand {
    public SpeedrunStartCommand() {
        super("Start", "Start the speedrun!");
    }

    public void chooseRunner() {
        /*
        TODO Figure out how to get all active players and possibly index them,
         then get a random index and assign the player with that index as speedrunner
         */
    }
}