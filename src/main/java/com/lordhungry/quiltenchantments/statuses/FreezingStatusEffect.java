package com.lordhungry.quiltenchantments.statuses;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class FreezingStatusEffect extends StatusEffect {
	public FreezingStatusEffect() {
		super(StatusEffectType.HARMFUL, 0x80E5EF);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity) {
			entity.setInPowderSnow(true);
		}
	}
}
