package serializers;

import annotations.Helper;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import profiles.Profile;

import java.util.Map;

public class SerializeUtils {

    @Helper("The Object you serialize must implement WilloSerializable")
    public static boolean serializeToConfiguration(ConfigurationSection section, Object obj) {
        if(obj instanceof WilloSerializable){
            WilloSerializable serializable = (WilloSerializable) obj;
            for(Map.Entry<String, Object> objectMap : serializable.serialize(serializable).entrySet()){
                section.set(objectMap.getKey(), objectMap.getValue());
            }
            return true;
        }else{
            return false;
        }
    }
}
