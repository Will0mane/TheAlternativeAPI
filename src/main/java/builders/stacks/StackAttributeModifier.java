package builders.stacks;

import org.bukkit.attribute.AttributeModifier;

import java.util.UUID;

public class StackAttributeModifier {


    private final AttributeModifier a;

    public StackAttributeModifier(String name, double amount, AttributeModifier.Operation operation){
        a = new AttributeModifier(UUID.randomUUID(), name, amount, operation);
    }

    public UUID getUUID(){
        return a.getUniqueId();
    }

    public String getName(){
        return a.getName();
    }

    public double getAmount(){
        return a.getAmount();
    }

    public AttributeModifier.Operation getOperation(){
        return a.getOperation();
    }

    public AttributeModifier getAttributeModifier() {
        return a;
    }
}
