package net.intheminecraftgalaxy.itmg;

import net.fabricmc.api.ModInitializer;

import net.intheminecraftgalaxy.itmg.block.ModBlocks;
import net.intheminecraftgalaxy.itmg.component.ModDataComponentTypes;
import net.intheminecraftgalaxy.itmg.item.ModItemGroups;
import net.intheminecraftgalaxy.itmg.item.ModItems;
import net.intheminecraftgalaxy.itmg.util.ModLootTableModifiers;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ITMG implements ModInitializer {
	public static final String MOD_ID = "itmg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		InTheMinecraftGalaxyConfig.loadConfig();
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		ModDataComponentTypes.registerDataComponentTypes();

		ModLootTableModifiers.modifyLootTables();

		LifeSteal.register();
	}
}