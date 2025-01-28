package that.choppy.cardmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CardMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CardMod.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CardMod.MODID);

    // Register the base card item
    public static final RegistryObject<Item> BASE_CARD = ITEMS.register("base_card",
            () -> new Item(new Item.Properties()));

    // Register the base pack item
    public static final RegistryObject<Item> BASE_PACK = ITEMS.register("base_pack",
            () -> new Item(new Item.Properties()));

    // Register a creative tab
    public static final RegistryObject<CreativeModeTab> CARD_MOD_TAB = CREATIVE_MODE_TABS.register("card_mod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cardmod"))
                    .icon(() -> new ItemStack(BASE_PACK.get()))
                    .displayItems((params, output) -> {
                        output.accept(BASE_PACK.get());
                        output.accept(BASE_CARD.get());
                    })
                    .build());

    // Method to register items and tabs
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // Add items to the creative tab
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CARD_MOD_TAB.getKey()) {
            event.accept(BASE_PACK);
            event.accept(BASE_CARD);
        }
    }
}