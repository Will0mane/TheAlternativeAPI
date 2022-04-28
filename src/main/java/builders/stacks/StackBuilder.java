package builders.stacks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.WilloUtils;

import java.util.List;

public class StackBuilder {

    private final String n;
    private final List<String> l;
    private final Material m;
    private final String d;
    private final int s;
    private final boolean u;
    private final StackEnchantment e;
    private final StackAttributes a;
    private final ItemFlag[] f;

    public StackBuilder(String name, List<String> lore, Material material, String data, int skin, boolean unbreakable,
                 StackEnchantment enchantment, StackAttributes attributes, ItemFlag... flags){
        n = name;
        l = lore;
        m = material;
        d = data;
        s = skin;
        u = unbreakable;
        e = enchantment;
        a = attributes;
        f = flags;
    }

    public StackAttributes getAttributes() {
        return a;
    }

    public StackEnchantment getEnchantment() {
        return e;
    }

    public ItemFlag[] getFlags() {
        return f;
    }

    public boolean getUnbreakable() {
        return u;
    }

    public int getSkin() {
        return s;
    }
    public String getName() {
        return n;
    }

    public List<String> getLore() {
        return l;
    }

    public Material getMat() {
        return m;
    }

    public String getData() {
        return d;
    }

    public ItemStack build(){
        ItemStack stack;
        if(getData().contains("head:")){
            String head = getData().replace("head:", "");
            stack = WilloUtils.getCustomSkull(head);
        }else{
            stack = new ItemStack(m);
        }
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(getName());
        meta.setLore(getLore());
        meta.setCustomModelData(getSkin());
        meta.setUnbreakable(getUnbreakable());
        meta.addItemFlags(getFlags());
        for(StackEnch enchantment : getEnchantment().getEnchantments()){
            meta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel(), enchantment.isIgnoreLevelRestriction());
        }
        for(StackAttribute stackAttribute : getAttributes().getAttributes()){
            meta.addAttributeModifier(stackAttribute.getAttribute(), stackAttribute.getModifier().getAttributeModifier());
        }
        stack.setItemMeta(meta);
        return stack;
    }
}
