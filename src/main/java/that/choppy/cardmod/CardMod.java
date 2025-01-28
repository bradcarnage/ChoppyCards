package that.choppy.cardmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(CardMod.MODID)
public class CardMod {
    public static final String MODID = "cardmod";

    public CardMod() {
        IEventBus modEventBus = MinecraftForge.EVENT_BUS; // Use the main event bus

        // Register items and creative tabs
        ModItems.register(modEventBus);

        // Register creative tab contents
        modEventBus.addListener(ModItems::addCreative);

        // Register other events
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}