package formats;

import builders.*;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DateFormatting {

    public static String formatTime(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    public static ItemStack getTestItem(){
        return new StackBuilder(
                "",
                Arrays.asList(

                ),
                Material.CLOCK,
                "",
                0,
                true,
                new StackEnchantment(new StackEnch(Enchantment.DURABILITY, 3, true)),
                new StackAttributes(new StackAttribute(Attribute.GENERIC_ATTACK_DAMAGE, new StackAttributeModifier("Something",
                        10, AttributeModifier.Operation.ADD_NUMBER)))
        ).build();
    }

}
