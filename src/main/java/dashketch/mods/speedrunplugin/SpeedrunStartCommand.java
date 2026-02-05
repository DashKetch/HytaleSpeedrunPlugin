package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpeedrunStartCommand extends CommandBase {

    private static final Random RANDOM = new Random();

    public SpeedrunStartCommand() {
        super("start", "Start the speedrun");
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {

        List<PlayerRef> players = new ArrayList<>(
                PlayerRegistry.getOnlinePlayers()
        );

        if (players.isEmpty()) {
            ctx.sendMessage(Message.raw("No players are currently online."));
            return;
        }

        PlayerRef chosen = players.get(
                RANDOM.nextInt(players.size())
        );

        SpeedrunCommand.speedRunnerName = chosen.getUsername();

        ctx.sendMessage(Message.raw(
                chosen.getUsername() + " has been chosen as the speedrunner!"
        ));
    }
}
