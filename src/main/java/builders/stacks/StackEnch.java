package builders.stacks;

import org.bukkit.enchantments.Enchantment;

public class StackEnch {

    private final Enchantment e;
    private final int l;
    private final boolean i;

    public StackEnch(Enchantment enchantment, int level, boolean ignoreLevelRestrictions){
        e = enchantment;
        l = level;
        i = ignoreLevelRestrictions;
    }

    public Enchantment getEnchantment() {
        return e;
    }

    public int getLevel() {
        return l;
    }

    public boolean isIgnoreLevelRestriction() {
        return i;
    }
}
