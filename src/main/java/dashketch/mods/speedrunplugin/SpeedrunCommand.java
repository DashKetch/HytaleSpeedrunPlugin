package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class SpeedrunCommand extends CommandBase {
    public static String speedRunner;

    public SpeedrunCommand() {
        super("speedrun", "Main speedrun command");
        this.setPermissionGroup(GameMode.Creative);
        this.addSubCommand(new SpeedrunStartCommand() {
            @Override
            protected @Nullable CompletableFuture<Void> execute(@NonNull CommandContext ctx) {
                chooseRunner();
                ctx.sendMessage(Message.raw(speedRunner+"has been chosen to be the speedrunner. Everyone else is a hunter!")); //replace with refrence to a method in SpeedrunStartCommand.java
                return null;
            }
        });
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        ctx.sendMessage(Message.raw("Not a full command! Use the sub command Start to start the speedrun!"));
    }
}
