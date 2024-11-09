package net.intheminecraftgalaxy.itmg.item;

import net.intheminecraftgalaxy.itmg.ITMG;
import net.intheminecraftgalaxy.itmg.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;


public class ModItems {


    public static final Item HEART_STATE_1 = registerItem("heart_state_1", new Item(createSettings("heart_state_1").maxCount(16)));
    public static final Item HEART = registerItem("heart", new HeartItem(createSettings("heart")
            .maxCount(1)
            .rarity(Rarity.EPIC)));

    public static final Item CRAFTING_KEY = registerItem("crafting_key", new Item(createSettings("crafting_key").maxCount(1).rarity(Rarity.EPIC)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.crafting_key"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item SNOW_SWORD = registerItem("snow_sword",
            new SnowSwordItem(
                    ModToolMaterials.SNOW_TOOL.getMaterial(),
                    3.0f,
                    -2.4f,
                    createSettings("snow_sword")
                            .rarity(Rarity.EPIC)
            ));

    public static final Item VEIN_MINING_PICKAXE_ITEM = registerItem("vein_mining_pickaxe",
            new VeinMiningPickaxeItem(
                    ModToolMaterials.VEINMININGPICKAXETOOL.getMaterial(),
                    1,
                    -2.8f,
                    createSettings("vein_mining_pickaxe")
                            .rarity(Rarity.EPIC)));

    public static final Item TIMBER_AXE = registerItem("timber_axe",
            new TimberAxeItem(ModToolMaterials.TIMBER_TOOL.getMaterial(),
                    6,
                    -3.2f,
                    createSettings("timber_axe")
                            .rarity(Rarity.EPIC)));


    public static final Item TIMBER_AXE_HEAD = registerItem("timber_axe_head", new Item(createSettings("timber_axe_head").maxCount(1)));

    public static final Item MINING_STAFF = registerItem("mining_staff", new MiningStaffItem(createSettings("mining_staff").maxDamage(32).rarity(Rarity.EPIC)));

    public static final Item THUNDERBLADE = registerItem("thunderblade", new ThunderBladeItem(createSettings("thunderblade").maxCount(1).rarity(Rarity.EPIC)));

    // static final Item FIRE_RESISTANCE_HELMET = registerItem("fire_resistance_helmet", new WaterBreathingHelmet(ArmorMaterials.NETHERITE, EquipmentType.HELMET, createSettings("fire_resistance_helmet")));

    // Helper method to automatically generate item settings with a registry key
    private static Item.Settings createSettings(String itemName) {
        Identifier id = Identifier.of(ITMG.MOD_ID, itemName);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);
        return new Item.Settings().registryKey(key);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ITMG.MOD_ID, name), item);
    }


    public static void registerModItems(){
        ITMG.LOGGER.info("Registering Mod Items for " + ITMG.MOD_ID);
    }
}
