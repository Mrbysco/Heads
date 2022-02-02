package com.mrbysco.heads.mixin;

import com.google.common.collect.ImmutableMap;
import com.mrbysco.heads.client.ClientHandler;
import com.mrbysco.heads.client.models.BatSkullModel;
import com.mrbysco.heads.client.models.BeeSkullModel;
import com.mrbysco.heads.client.models.ChickenSkullModel;
import com.mrbysco.heads.client.models.CowSkullModel;
import com.mrbysco.heads.client.models.EndermanSkullModel;
import com.mrbysco.heads.client.models.EndermiteSkullModel;
import com.mrbysco.heads.client.models.FoxSkullModel;
import com.mrbysco.heads.client.models.GoatSkullModel;
import com.mrbysco.heads.client.models.HeadModelBase;
import com.mrbysco.heads.client.models.HorseSkullModel;
import com.mrbysco.heads.client.models.IronGolemSkullModel;
import com.mrbysco.heads.client.models.MagmaCubeSkullModel;
import com.mrbysco.heads.client.models.MooshroomSkullModel;
import com.mrbysco.heads.client.models.OcelotSkullModel;
import com.mrbysco.heads.client.models.PigSkullModel;
import com.mrbysco.heads.client.models.PiglinSkullModel;
import com.mrbysco.heads.client.models.SheepSkullFurModel;
import com.mrbysco.heads.client.models.SheepSkullModel;
import com.mrbysco.heads.client.models.SilverfishSkullModel;
import com.mrbysco.heads.client.models.SlimeSkullModel;
import com.mrbysco.heads.client.models.SpiderSkullModel;
import com.mrbysco.heads.client.models.SquidSkullModel;
import com.mrbysco.heads.client.models.TurtleSkullModel;
import com.mrbysco.heads.client.models.VillagerSkullModel;
import com.mrbysco.heads.client.models.WitchSkullModel;
import com.mrbysco.heads.client.models.WolfSkullModel;
import com.mrbysco.heads.registry.HeadTypes;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.SkullBlock.Type;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(SkullBlockRenderer.class)
public class SkullBlockRendererMixin {
	@Inject(
			method = "createSkullRenderers",
			at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;", remap = false),
			locals = LocalCapture.CAPTURE_FAILSOFT
	)
	private static void registerModel(EntityModelSet entityModelSet, CallbackInfoReturnable<Map<Type, SkullModelBase>> cir,
									  ImmutableMap.Builder<SkullBlock.Type, SkullModelBase> builder) {
		builder.put(HeadTypes.AXOLOTL_LUCY, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)));
		builder.put(HeadTypes.AXOLOTL_WILD, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)));
		builder.put(HeadTypes.AXOLOTL_GOLD, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)));
		builder.put(HeadTypes.AXOLOTL_CYAN, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)));
		builder.put(HeadTypes.AXOLOTL_BLUE, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)));
		builder.put(HeadTypes.BAT, new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.BAT)));
		builder.put(HeadTypes.BEE, new BeeSkullModel(entityModelSet.bakeLayer(ClientHandler.BEE)));
		builder.put(HeadTypes.BLACK_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BLACK)));
		builder.put(HeadTypes.BLAZE, new SkullModel(entityModelSet.bakeLayer(ClientHandler.BLAZE)));
		builder.put(HeadTypes.BLUE_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BLUE)));
		builder.put(HeadTypes.BROWN_MOOSHROOM, new MooshroomSkullModel(entityModelSet.bakeLayer(ClientHandler.BROWN_MOOSHROOM), false));
		builder.put(HeadTypes.BROWN_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BROWN)));
		builder.put(HeadTypes.CAT_TABBY, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_BLACK, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_RED, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_SIAMESE, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_BRITISH_SHORTHAIR, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_CALICO, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_PERSIAN, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_RAGDOLL, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_WHITE, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_JELLIE, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAT_ALL_BLACK, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)));
		builder.put(HeadTypes.CAVE_SPIDER, new SpiderSkullModel(entityModelSet.bakeLayer(ClientHandler.CAVE_SPIDER)));
		builder.put(HeadTypes.CHICKEN, new ChickenSkullModel(entityModelSet.bakeLayer(ClientHandler.CHICKEN)));
		builder.put(HeadTypes.COW, new CowSkullModel(entityModelSet.bakeLayer(ClientHandler.COW)));
		builder.put(HeadTypes.CYAN_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.CYAN)));
		builder.put(HeadTypes.DONKEY, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.DONKEY)));
		builder.put(HeadTypes.ENDERMAN, new EndermanSkullModel(entityModelSet.bakeLayer(ClientHandler.ENDERMAN)));
		builder.put(HeadTypes.ENDERMITE, new EndermiteSkullModel(entityModelSet.bakeLayer(ClientHandler.ENDERMITE)));
		builder.put(HeadTypes.GHAST, new HeadModelBase(entityModelSet.bakeLayer(ClientHandler.GHAST)));
		builder.put(HeadTypes.FOX, new FoxSkullModel(entityModelSet.bakeLayer(ClientHandler.FOX)));
		builder.put(HeadTypes.FOX_SNOW, new FoxSkullModel(entityModelSet.bakeLayer(ClientHandler.FOX)));
		builder.put(HeadTypes.GLOW_SQUID, new SquidSkullModel(entityModelSet.bakeLayer(ClientHandler.GLOW_SQUID), true));
		builder.put(HeadTypes.GOAT, new GoatSkullModel(entityModelSet.bakeLayer(ClientHandler.GOAT)));
		builder.put(HeadTypes.GRAY_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.GRAY)));
		builder.put(HeadTypes.GREEN_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.GREEN)));
		builder.put(HeadTypes.IRON_GOLEM, new IronGolemSkullModel(entityModelSet.bakeLayer(ClientHandler.IRON_GOLEM)));
		builder.put(HeadTypes.HORSE_WHITE, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_CREAMY, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_CHESTNUT, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_BROWN, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_BLACK, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_GRAY, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_DARKBROWN, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_UNDEAD, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.HORSE_SKELETON, new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)));
		builder.put(HeadTypes.LIGHT_BLUE_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIGHT_BLUE)));
		builder.put(HeadTypes.LIGHT_GRAY_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIGHT_GRAY)));
		builder.put(HeadTypes.LIME_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIME)));
		builder.put(HeadTypes.MAGENTA_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.MAGENTA)));
		builder.put(HeadTypes.MAGMA_CUBE, new MagmaCubeSkullModel(entityModelSet.bakeLayer(ClientHandler.MAGMA_CUBE)));
		builder.put(HeadTypes.OCELOT, new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.OCELOT)));
		builder.put(HeadTypes.ORANGE_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.ORANGE)));
		builder.put(HeadTypes.PIG, new PigSkullModel(entityModelSet.bakeLayer(ClientHandler.PIG)));
		builder.put(HeadTypes.PIGLIN, new PiglinSkullModel(entityModelSet.bakeLayer(ClientHandler.PIGLIN)));
		builder.put(HeadTypes.PIGLIN_BRUTE, new PiglinSkullModel(entityModelSet.bakeLayer(ClientHandler.PIGLIN_BRUTE)));
		builder.put(HeadTypes.PINK_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.PINK)));
		builder.put(HeadTypes.PURPLE_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.PURPLE)));
		builder.put(HeadTypes.RED_MOOSHROOM, new MooshroomSkullModel(entityModelSet.bakeLayer(ClientHandler.RED_MOOSHROOM), true));
		builder.put(HeadTypes.RED_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.RED)));
		builder.put(HeadTypes.SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.WHITE)));
		builder.put(HeadTypes.SHEEP_SHAVEN, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)));
		builder.put(HeadTypes.SILVERFISH, new SilverfishSkullModel(entityModelSet.bakeLayer(ClientHandler.SILVERFISH)));
		builder.put(HeadTypes.SLIME, new SlimeSkullModel(entityModelSet.bakeLayer(ClientHandler.SLIME)));
		builder.put(HeadTypes.SNOW_GOLEM, new HeadModelBase(entityModelSet.bakeLayer(ClientHandler.SNOW_GOLEM)));
		builder.put(HeadTypes.SPIDER, new SpiderSkullModel(entityModelSet.bakeLayer(ClientHandler.SPIDER)));
		builder.put(HeadTypes.SQUID, new SquidSkullModel(entityModelSet.bakeLayer(ClientHandler.SQUID), false));
		builder.put(HeadTypes.TURTLE, new TurtleSkullModel(entityModelSet.bakeLayer(ClientHandler.TURTLE)));
		builder.put(HeadTypes.VILLAGER, new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.VILLAGER)));
		builder.put(HeadTypes.WANDERING_TRADER, new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.WANDERING_TRADER)));
		builder.put(HeadTypes.WITCH, new WitchSkullModel(entityModelSet.bakeLayer(ClientHandler.WITCH)));
		builder.put(HeadTypes.WOLF, new WolfSkullModel(entityModelSet.bakeLayer(ClientHandler.WOLF)));
		builder.put(HeadTypes.YELLOW_SHEEP, new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP), new SheepSkullFurModel(entityModelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.YELLOW)));
		builder.put(HeadTypes.ZOMBIE_VILLAGER, new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.ZOMBIE_VILLAGER)));
		builder.put(HeadTypes.ZOMBIFIED_PIGLIN, new PiglinSkullModel(entityModelSet.bakeLayer(ClientHandler.ZOMBIFIED_PIGLIN)));
	}
}
