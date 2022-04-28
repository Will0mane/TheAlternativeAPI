package profiles;

import org.bukkit.configuration.ConfigurationSection;
import serializers.WilloSerializable;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Profile implements WilloSerializable {

    private final UUID o;
    private final Map<String, Object> dS;
    private final UUID pI;

    public Profile(UUID owner, Map<String, Object> dataStorage){
        o = owner;
        dS = dataStorage;
        pI = UUID.randomUUID();
    }
    public Profile(UUID owner, Map<String, Object> dataStorage, UUID profileID){
        o = owner;
        dS = dataStorage;
        pI = profileID;
    }

    public Object getStoredDataFromKey(String key){
        return dS.get(key);
    }

    public Map<String, Object> getDataStorage() {
        return dS;
    }

    public UUID getOwner() {
        return o;
    }

    public UUID getProfileID() {
        return pI;
    }

    @Override
    public Map<String, Object> serialize(@Nonnull Object obj) {
        Map<String, Object> objectMap = new HashMap<>();
        Profile profile = (Profile) obj;
        objectMap.put("owner", profile.getOwner().toString());
        for(Map.Entry<String, Object> data : profile.getDataStorage().entrySet()){
            objectMap.put(data.getKey(), data.getValue());
        }
        objectMap.put("profileID", profile.getProfileID().toString());
        return objectMap;
    }

    @Override
    public Object deSerialize(ConfigurationSection section) {
        return new Profile(
                UUID.fromString(section.getString("owner")),
                Objects.requireNonNull(section.getConfigurationSection("data")).getValues(true),
                UUID.fromString(section.getString("profileID"))
        );
    }
}
