package com.faboslav.friendsandfoes.common.mixin;

import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.util.datafix.schemas.V1460;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.function.Supplier;

@Mixin(V1460.class)
public abstract class V1460Mixin
{
	@Shadow
	protected static void registerMob(Schema schema, Map<String, Supplier<TypeTemplate>> map, String string) {
	}

	@Inject(method = "registerEntities", at = @At("RETURN"))
	public void registerModdedEntities(Schema schema, CallbackInfoReturnable<Map<String, Supplier<TypeTemplate>>> cir) {
		var map = cir.getReturnValue();
		registerMob(schema, map, "friendsandfoes:copper_golem");
		registerMob(schema, map, "friendsandfoes:crab");
		registerMob(schema, map, "friendsandfoes:glare");
		registerMob(schema, map, "friendsandfoes:iceologer");
		registerMob(schema, map, "friendsandfoes:illusioner");
		registerMob(schema, map, "friendsandfoes:ice_chunk");
		registerMob(schema, map, "friendsandfoes:mauler");
		registerMob(schema, map, "friendsandfoes:moobloom");
		registerMob(schema, map, "friendsandfoes:rascal");
		registerMob(schema, map, "friendsandfoes:tuff_golem");
		registerMob(schema, map, "friendsandfoes:wildfire");
		//? if <= 1.21.8 {
		/*registerMob(schema, map, "friendsandfoes:player_illusion");*/
		//? }
	}
}
