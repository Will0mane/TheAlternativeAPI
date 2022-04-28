package utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import serializers.SerializeUtils;

import java.lang.reflect.Field;
import java.util.UUID;

public class WilloUtils {

    public static ItemStack getCustomSkull(String head) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", head));
        Field profileField = null;
        try {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
            profileField.setAccessible(false);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        item.setItemMeta(itemMeta);
        return item;
    }
    public static Skull getCustomSkullBlock(Block b, String head) {
        Skull blockMeta = (Skull) b.getState();
        GameProfile profile = getProfileForCustomSkull(head);
        Field profileField = null;
        try {
            profileField = blockMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(blockMeta, profile);
            profileField.setAccessible(false);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        blockMeta.update();
        return blockMeta;
    }

    public static GameProfile getProfileForCustomSkull(String head){
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", head));
        return profile;
    }

}
