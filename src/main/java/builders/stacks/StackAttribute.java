package builders.stacks;

import org.bukkit.attribute.Attribute;

public class StackAttribute {

    private final Attribute a;
    private final StackAttributeModifier m;

    public Attribute getAttribute() {
        return a;
    }

    public StackAttribute(Attribute attribute, StackAttributeModifier modifier){
        a = attribute;
        m = modifier;
    }

    public StackAttributeModifier getModifier() {
        return m;
    }
}
