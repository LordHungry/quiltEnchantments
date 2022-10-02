package com.lordhungry.quiltenchantments.enchantments;

import com.lordhungry.quiltenchantments.quiltEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Objects;

public class FrostEnchantment extends Enchantment {
	public FrostEnchantment() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMinPower(int level) {
		return 10 + 20 * (level - 1);
	}

	@Override
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 50;
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		if(target instanceof LivingEntity) {
			((LivingEntity) target).addStatusEffect(
					new StatusEffectInstance(quiltEnchantments.FREEZING, checkFreeze(target) + (20*(level*2)+20))
			);
		}

		super.onTargetDamaged(user, target, level);
	}

	@Override
	public boolean canAccept(Enchantment other) {
		return !(other instanceof FireAspectEnchantment) && super.canAccept(other);
	}

	public int checkFreeze(Entity target) {
		if (((LivingEntity) target).hasStatusEffect(quiltEnchantments.FREEZING)) {
			return Objects.requireNonNull(((LivingEntity) target).getStatusEffect(quiltEnchantments.FREEZING)).getDuration();
		} else {
			return 0;
		}

	}

}
