package andrews.swampier_swamps.network.client;

import andrews.swampier_swamps.network.client.util.ClientPacketHandlerClass;
import andrews.swampier_swamps.util.Reference;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record MessageClientGasExplosionParticles(BlockPos pos) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageClientGasExplosionParticles> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MODID, "gas_explosion_particles_packet"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageClientGasExplosionParticles> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, MessageClientGasExplosionParticles::pos, MessageClientGasExplosionParticles::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void registerPacket()
    {
        ClientPlayNetworking.registerGlobalReceiver(TYPE, (payload, context) -> context.client().execute(() ->
        {
            if (context.client().level != null)
                ClientPacketHandlerClass.handleSpawnGasExplosionParticles(payload.pos());
        }));
    }
}
