package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import javax.annotation.Nonnull;

public class SpeedrunCommand extends CommandBase {
    public static String speedRunnerName;

    public SpeedrunCommand() {
        super("speedrun", "Main speedrun command");
        this.setPermissionGroup(GameMode.Creative);
        this.addSubCommand(new SpeedrunStartCommand() {
        });
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        ctx.sendMessage(Message.raw("Not a full command! Use the sub command Start to start the speedrun!"));
    }
}
