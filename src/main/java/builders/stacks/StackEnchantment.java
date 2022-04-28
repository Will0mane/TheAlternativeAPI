package builders.stacks;

public class StackEnchantment {

    private final StackEnch[] e;

    public StackEnchantment(StackEnch... enchantments){
        e = enchantments;
    }

    public StackEnch[] getEnchantments() {
        return e;
    }
}
