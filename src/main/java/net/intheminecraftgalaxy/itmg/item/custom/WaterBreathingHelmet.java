package net.intheminecraftgalaxy.itmg.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class WaterBreathingHelmet extends ArmorItem {
    private static final int MAX_DURATION = 204; // 20 seconds in ticks
    private int fireResistanceCountdown = MAX_DURATION;

    public WaterBreathingHelmet(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {

            // Check if the helmet is being worn
            if (livingEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == this) {

                if (livingEntity.isOnFire()) {
                    // Countdown while in lava
                    if (fireResistanceCountdown > 0) {
                        fireResistanceCountdown--;
                    }
                } else {
                    // If the player is out of lava and fire resistance has expired, reapply it
                    if (fireResistanceCountdown < MAX_DURATION) {
                        fireResistanceCountdown++;
                    }
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, fireResistanceCountdown, 0, false, false, true));

                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}