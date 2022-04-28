package serializers;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.Map;

public interface WilloSerializable {

    public Map<String, Object> serialize(Object obj);

    public Object deSerialize(ConfigurationSection section);

}
