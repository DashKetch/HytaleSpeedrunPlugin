package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

public class SpeedrunPlugin extends JavaPlugin {
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public SpeedrunPlugin(JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from %s version %s", this.getName(), this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new SpeedrunCommand());

        this.getEventRegistry().register(PlayerConnectEvent.class, event -> PlayerRegistry.playerJoined(event.getPlayerRef()));

        this.getEventRegistry().register(PlayerDisconnectEvent.class, event -> PlayerRegistry.playerLeft(event.getPlayerRef()));

        this.getCodecRegistry(Interaction.CODEC).register("TrackingCompassInteraction", TrackingCompassInteraction.class, TrackingCompassInteraction.CODEC);
    }
}
