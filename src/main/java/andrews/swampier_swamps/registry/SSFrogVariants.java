package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.util.Reference;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;

public class SSFrogVariants
{
    public static final Holder.Reference<FrogVariant> WHITE_VARIANT      = createFrogVariant("white_variant", "frog_white");
    // Orange is one of vanilla's Frogs.
    public static final Holder.Reference<FrogVariant> MAGENTA_VARIANT    = createFrogVariant("magenta_variant", "frog_magenta");
    public static final Holder.Reference<FrogVariant> LIGHT_BLUE_VARIANT = createFrogVariant("light_blue_variant", "frog_light_blue");
    public static final Holder.Reference<FrogVariant> YELLOW_VARIANT     = createFrogVariant("yellow_variant", "frog_yellow");
    public static final Holder.Reference<FrogVariant> LIME_VARIANT       = createFrogVariant("lime_variant", "frog_lime");
    public static final Holder.Reference<FrogVariant> PINK_VARIANT       = createFrogVariant("pink_variant", "frog_pink");
    public static final Holder.Reference<FrogVariant> GRAY_VARIANT       = createFrogVariant("gray_variant", "frog_gray");
    // Light Gray is one of vanilla's Frogs.
    public static final Holder.Reference<FrogVariant> CYAN_VARIANT       = createFrogVariant("cyan_variant", "frog_cyan");
    public static final Holder.Reference<FrogVariant> PURPLE_VARIANT     = createFrogVariant("purple_variant", "frog_purple");
    public static final Holder.Reference<FrogVariant> BLUE_VARIANT       = createFrogVariant("blue_variant", "frog_blue");
    public static final Holder.Reference<FrogVariant> BROWN_VARIANT      = createFrogVariant("brown_variant", "frog_brown");
    // Green is one of vanilla's Frogs.
    public static final Holder.Reference<FrogVariant> RED_VARIANT        = createFrogVariant("red_variant", "frog_red");
    public static final Holder.Reference<FrogVariant> BLACK_VARIANT      = createFrogVariant("black_variant", "frog_black");

    private static Holder.Reference<FrogVariant> createFrogVariant(String name, String texture)
    {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Reference.MODID, name);
        return Registry.registerForHolder(BuiltInRegistries.FROG_VARIANT, id,
                new FrogVariant(ResourceLocation.fromNamespaceAndPath(Reference.MODID, "textures/entity/frog/" + texture + ".png")));
    }

    public static void init() {}
}
