package com.lordhungry.quiltenchantments;

import com.lordhungry.quiltenchantments.enchantments.FrostEnchantment;
import com.lordhungry.quiltenchantments.statuses.FreezingStatusEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class quiltEnchantments implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Quilt Enchantments");

	public static final StatusEffect FREEZING = new FreezingStatusEffect();
	public static final Enchantment FROST = new FrostEnchantment();
	public static final String modid = "quiltenchantments";

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		Registry.register(Registry.STATUS_EFFECT, new Identifier(modid, "freezing"), FREEZING);
		Registry.register(Registry.ENCHANTMENT, new Identifier(modid, "frost"), FROST);
	}
}
