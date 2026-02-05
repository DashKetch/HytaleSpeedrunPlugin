package dashketch.mods.speedrunplugin;

import com.hypixel.hytale.server.core.universe.PlayerRef;
import org.jetbrains.annotations.UnknownNullability;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class PlayerRegistry {

    private static final Set<PlayerRef> ONLINE_PLAYERS = new HashSet<>();

    public static void playerJoined(@UnknownNullability PlayerRef player) {
        ONLINE_PLAYERS.add(player);
    }

    public static void playerLeft(PlayerRef player) {
        ONLINE_PLAYERS.remove(player);
    }

    public static Set<PlayerRef> getOnlinePlayers() {
        return Collections.unmodifiableSet(ONLINE_PLAYERS);
    }
}
