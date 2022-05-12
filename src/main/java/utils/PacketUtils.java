package utils;

import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PacketUtils {

    public static void playPackets(Packet<?> packet, List<Player> playerList){
        playerList.forEach(p ->{
            try {
                ((EntityPlayer) NMSHelper.getHandle(p)).b.sendPacket(packet);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}
