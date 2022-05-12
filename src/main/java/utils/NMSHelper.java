package utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class NMSHelper {

    public static Object getHandle(Player player) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return player.getClass().getMethod("getHandle").invoke(player);
    }

    public static GameProfile getGameProfile(Player player) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object handle = getHandle(player);

        return (GameProfile) handle.getClass()
                .getSuperclass()
                .getDeclaredMethod("getProfile")
                .invoke(handle);
    }

    public static Property getTexturesProperty(GameProfile profile) {
        Optional<Property> texturesProperty = profile.getProperties().get("textures").stream().findFirst();
        return texturesProperty.orElse(null);
    }

    public static void disguise(Player p, String skin) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        String texture = "";
        String signature = "";

        GameProfile gameProfile = getGameProfile(p);

        gameProfile.getProperties().clear();
        gameProfile.getProperties()
                .put("textures",
                        new Property(
                                "textures",
                                texture,
                                signature
                        ));
    }

    public static void nickPlayer(Plugin plugin, Player p, String nickname) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        GameProfile gameProfile = getGameProfile(p);

        try {
            Field field = gameProfile.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(gameProfile, nickname);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (nickname != null) p.setDisplayName(nickname);

        Bukkit.getOnlinePlayers().forEach(all -> {
            all.hidePlayer(plugin, p);
            all.showPlayer(plugin, p);
        });
    }

}
