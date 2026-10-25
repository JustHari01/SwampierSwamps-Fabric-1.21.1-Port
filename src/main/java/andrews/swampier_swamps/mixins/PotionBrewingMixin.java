package andrews.swampier_swamps.mixins;

import andrews.swampier_swamps.SwampierSwamps;
import andrews.swampier_swamps.registry.SSItems;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public abstract class PotionBrewingMixin
{
    @Redirect(method = "addVanillaMixes", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/alchemy/PotionBrewing$Builder;addMix(Lnet/minecraft/core/Holder;Lnet/minecraft/world/item/Item;Lnet/minecraft/core/Holder;)V"))
    private static void swampierSwamps$replaceLeapingIngredient(PotionBrewing.Builder builder, Holder<Potion> input, Item ingredient, Holder<Potion> output)
    {
        if (SwampierSwamps.SS_CONFIG != null
                && SwampierSwamps.SS_CONFIG.SSCommonConfig.alterRecipes
                && input.equals(Potions.AWKWARD)
                && ingredient == Items.RABBIT_FOOT
                && output.equals(Potions.LEAPING))
        {
            builder.addMix(input, SSItems.FROG_LEG, output);
        }
        else
        {
            builder.addMix(input, ingredient, output);
        }
    }

    @Inject(method = "addVanillaMixes", at = @At("TAIL"))
    private static void swampierSwamps$addLuckPotion(PotionBrewing.Builder builder, CallbackInfo ci)
    {
        if (SwampierSwamps.SS_CONFIG != null && SwampierSwamps.SS_CONFIG.SSCommonConfig.alterRecipes)
            builder.addMix(Potions.AWKWARD, Items.RABBIT_FOOT, Potions.LUCK);
    }
}
