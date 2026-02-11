package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import org.jspecify.annotations.NonNull;

public class TrackingCompassInteraction extends SimpleInstantInteraction {

    @Override
    protected void firstRun(
            @NonNull InteractionType interactionType,
            @NonNull InteractionContext interactionContext,
            @NonNull CooldownHandler cooldownHandler
    ) {
        PlayerRef speedRunner = SpeedrunStartCommand.speedRunner;

        if (speedRunner == null) {
            return;
        }

        var transform = speedRunner.getTransform();
        var position = transform.getPosition();

        SpeedrunPlugin.LOGGER.atInfo().log(position.toString());
    }
}

