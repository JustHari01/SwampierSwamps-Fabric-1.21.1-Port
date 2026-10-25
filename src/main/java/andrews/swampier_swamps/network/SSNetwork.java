package andrews.swampier_swamps.network;

import andrews.swampier_swamps.network.client.MessageClientGasExplosionParticles;
import andrews.swampier_swamps.network.client.MessageClientSplashParticles;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class SSNetwork
{
    public static void registerPayloadTypes()
    {
        PayloadTypeRegistry.playS2C().register(MessageClientSplashParticles.TYPE, MessageClientSplashParticles.CODEC);
        PayloadTypeRegistry.playS2C().register(MessageClientGasExplosionParticles.TYPE, MessageClientGasExplosionParticles.CODEC);
    }

    public static void registerClientNetworkMessages()
    {
        MessageClientSplashParticles.registerPacket();
        MessageClientGasExplosionParticles.registerPacket();
    }

//    public static void registerNetworkMessages() {}
}
