package com.mrbysco.heads.registry;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.blockentity.HeadBlockEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadsRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Heads.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Heads.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Heads.MOD_ID);

	public static final Map<HeadTypes, HeadReg> headMap = new HashMap<>();
	public static final List<HeadReg> headList = new ArrayList<>();

	public static final HeadReg AXOLOTL_LUCY = new HeadReg("axolotl", "axolotl_lucy", "head", HeadTypes.AXOLOTL_LUCY);
	public static final HeadReg AXOLOTL_WILD = new HeadReg("axolotl", "axolotl_wild", "head", HeadTypes.AXOLOTL_WILD);
	public static final HeadReg AXOLOTL_GOLD = new HeadReg("axolotl", "axolotl_gold", "head", HeadTypes.AXOLOTL_GOLD);
	public static final HeadReg AXOLOTL_CYAN = new HeadReg("axolotl", "axolotl_cyan", "head", HeadTypes.AXOLOTL_CYAN);
	public static final HeadReg AXOLOTL_BLUE = new HeadReg("axolotl", "axolotl_blue", "head", HeadTypes.AXOLOTL_BLUE);
	public static final HeadReg BAT = new HeadReg("bat", "head", HeadTypes.BAT);
	public static final HeadReg BEE = new HeadReg("bee", "head", HeadTypes.BEE);
	public static final HeadReg BLAZE = new HeadReg("blaze", "head", HeadTypes.BLAZE);
	public static final HeadReg BROWN_MOOSHROOM = new HeadReg("mooshroom", "brown_mooshroom", "head", HeadTypes.BROWN_MOOSHROOM);
	public static final HeadReg CAT_TABBY = new HeadReg("cat", "cat_tabby", "head", HeadTypes.CAT_TABBY);
	public static final HeadReg CAT_BLACK = new HeadReg("cat", "cat_black", "head", HeadTypes.CAT_BLACK);
	public static final HeadReg CAT_RED = new HeadReg("cat", "cat_red", "head", HeadTypes.CAT_RED);
	public static final HeadReg CAT_SIAMESE = new HeadReg("cat", "cat_siamese", "head", HeadTypes.CAT_SIAMESE);
	public static final HeadReg CAT_BRITISH_SHORTHAIR = new HeadReg("cat", "cat_british_shorthair", "head", HeadTypes.CAT_BRITISH_SHORTHAIR);
	public static final HeadReg CAT_CALICO = new HeadReg("cat", "cat_calico", "head", HeadTypes.CAT_CALICO);
	public static final HeadReg CAT_PERSIAN = new HeadReg("cat", "cat_persian", "head", HeadTypes.CAT_PERSIAN);
	public static final HeadReg CAT_RAGDOLL = new HeadReg("cat", "cat_ragdoll", "head", HeadTypes.CAT_RAGDOLL);
	public static final HeadReg CAT_WHITE = new HeadReg("cat", "cat_white", "head", HeadTypes.CAT_WHITE);
	public static final HeadReg CAT_JELLIE = new HeadReg("cat", "cat_jellie", "head", HeadTypes.CAT_JELLIE);
	public static final HeadReg CAT_ALL_BLACK = new HeadReg("cat", "cat_all_black", "head", HeadTypes.CAT_ALL_BLACK);
	public static final HeadReg CAVE_SPIDER = new HeadReg("cave_spider", "head", HeadTypes.CAVE_SPIDER);
	public static final HeadReg CHICKEN = new HeadReg("chicken", "head", HeadTypes.CHICKEN);
	public static final HeadReg COW = new HeadReg("cow", "head", HeadTypes.COW);
	public static final HeadReg DONKEY = new HeadReg("donkey", "head", HeadTypes.DONKEY);
	public static final HeadReg ENDERMAN = new HeadReg("enderman", "head", HeadTypes.ENDERMAN);
	public static final HeadReg ENDERMITE = new HeadReg("endermite", "head", HeadTypes.ENDERMITE);
	public static final HeadReg FOX = new HeadReg("fox", "head", HeadTypes.FOX);
	public static final HeadReg FOX_SNOW = new HeadReg("fox", "fox_snow", "head", HeadTypes.FOX_SNOW);
	public static final HeadReg GHAST = new HeadReg("ghast", "head", HeadTypes.GHAST);
	public static final HeadReg HORSE_WHITE = new HeadReg("horse", "horse_white", "head", HeadTypes.HORSE_WHITE);
	public static final HeadReg HORSE_CREAMY = new HeadReg("horse", "horse_creamy", "head", HeadTypes.HORSE_CREAMY);
	public static final HeadReg HORSE_CHESTNUT = new HeadReg("horse", "horse_chestnut", "head", HeadTypes.HORSE_CHESTNUT);
	public static final HeadReg HORSE_BROWN = new HeadReg("horse", "horse_brown", "head", HeadTypes.HORSE_BROWN);
	public static final HeadReg HORSE_BLACK = new HeadReg("horse", "horse_black", "head", HeadTypes.HORSE_BLACK);
	public static final HeadReg HORSE_GRAY = new HeadReg("horse", "horse_gray", "head", HeadTypes.HORSE_GRAY);
	public static final HeadReg HORSE_DARKBROWN = new HeadReg("horse", "horse_darkbrown", "head", HeadTypes.HORSE_DARKBROWN);
	public static final HeadReg HORSE_UNDEAD = new HeadReg("horse", "horse_undead", "head", HeadTypes.HORSE_UNDEAD);
	public static final HeadReg HORSE_SKELETON = new HeadReg("horse_skeleton", "head", HeadTypes.HORSE_SKELETON);
	public static final HeadReg IRON_GOLEM = new HeadReg("iron_golem", "head", HeadTypes.IRON_GOLEM);
	public static final HeadReg MAGMA_CUBE = new HeadReg("magma_cube", "head", HeadTypes.MAGMA_CUBE);
	public static final HeadReg OCELOT = new HeadReg("ocelot", "head", HeadTypes.OCELOT);
	public static final HeadReg PIG = new HeadReg("pig", "head", HeadTypes.PIG);
	public static final HeadReg PIGLIN_BRUTE = new HeadReg("piglin_brute", "head", HeadTypes.PIGLIN_BRUTE);
	public static final HeadReg PIGLIN = new HeadReg("piglin", "head", HeadTypes.PIGLIN);
	public static final HeadReg RED_MOOSHROOM = new HeadReg("mooshroom", "red_mooshroom", "head", HeadTypes.RED_MOOSHROOM);
	public static final HeadReg BLACK_SHEEP = new HeadReg("sheep", "black_sheep", "head", HeadTypes.BLACK_SHEEP);
	public static final HeadReg BLUE_SHEEP = new HeadReg("sheep", "blue_sheep", "head", HeadTypes.BLUE_SHEEP);
	public static final HeadReg BROWN_SHEEP = new HeadReg("sheep", "brown_sheep", "head", HeadTypes.BROWN_SHEEP);
	public static final HeadReg CYAN_SHEEP = new HeadReg("sheep", "cyan_sheep", "head", HeadTypes.CYAN_SHEEP);
	public static final HeadReg GRAY_SHEEP = new HeadReg("sheep", "gray_sheep", "head", HeadTypes.GRAY_SHEEP);
	public static final HeadReg GREEN_SHEEP = new HeadReg("sheep", "green_sheep", "head", HeadTypes.GREEN_SHEEP);
	public static final HeadReg LIGHT_BLUE_SHEEP = new HeadReg("sheep", "light_blue_sheep", "head", HeadTypes.LIGHT_BLUE_SHEEP);
	public static final HeadReg LIGHT_GRAY_SHEEP = new HeadReg("sheep", "light_gray_sheep", "head", HeadTypes.LIGHT_GRAY_SHEEP);
	public static final HeadReg LIME_SHEEP = new HeadReg("sheep", "lime_sheep", "head", HeadTypes.LIME_SHEEP);
	public static final HeadReg MAGENTA_SHEEP = new HeadReg("sheep", "magenta_sheep", "head", HeadTypes.MAGENTA_SHEEP);
	public static final HeadReg ORANGE_SHEEP = new HeadReg("sheep", "orange_sheep", "head", HeadTypes.ORANGE_SHEEP);
	public static final HeadReg PINK_SHEEP = new HeadReg("sheep", "pink_sheep", "head", HeadTypes.PINK_SHEEP);
	public static final HeadReg PURPLE_SHEEP = new HeadReg("sheep", "purple_sheep", "head", HeadTypes.PURPLE_SHEEP);
	public static final HeadReg RED_SHEEP = new HeadReg("sheep", "red_sheep", "head", HeadTypes.RED_SHEEP);
	public static final HeadReg SHEEP = new HeadReg("sheep", "head", HeadTypes.SHEEP);
	public static final HeadReg SHEEP_SHAVEN = new HeadReg("sheep", "sheep_shaven", "head", HeadTypes.SHEEP_SHAVEN);
	public static final HeadReg YELLOW_SHEEP = new HeadReg("sheep", "yellow_sheep", "head", HeadTypes.YELLOW_SHEEP);
	public static final HeadReg GLOW_SQUID = new HeadReg("glow_squid", "head", HeadTypes.GLOW_SQUID);
	public static final HeadReg GOAT = new HeadReg("goat", "head", HeadTypes.GOAT);
	public static final HeadReg SILVERFISH = new HeadReg("silverfish", "head", HeadTypes.SILVERFISH);
	public static final HeadReg SLIME = new HeadReg("slime", "head", HeadTypes.SLIME);
	public static final HeadReg SNOW_GOLEM = new HeadReg("snow_golem", "head", HeadTypes.SNOW_GOLEM);
	public static final HeadReg SPIDER = new HeadReg("spider", "head", HeadTypes.SPIDER);
	public static final HeadReg SQUID = new HeadReg("squid", "head", HeadTypes.SQUID);
	public static final HeadReg TURTLE = new HeadReg("turtle", "head", HeadTypes.TURTLE);
	public static final HeadReg VILLAGER = new HeadReg("villager", "head", HeadTypes.VILLAGER);
	public static final HeadReg WANDERING_TRADER = new HeadReg("wandering_trader", "head", HeadTypes.WANDERING_TRADER);
	public static final HeadReg WITCH = new HeadReg("witch", "head", HeadTypes.WITCH);
	public static final HeadReg WOLF = new HeadReg("wolf", "head", HeadTypes.WOLF);
	public static final HeadReg ZOMBIE_VILLAGER = new HeadReg("zombie_villager", "head", HeadTypes.ZOMBIE_VILLAGER);
	public static final HeadReg ZOMBIFIED_PIGLIN = new HeadReg("zombified_piglin", "skull", HeadTypes.ZOMBIFIED_PIGLIN);

	public static final RegistryObject<BlockEntityType<HeadBlockEntity>> HEAD = BLOCK_ENTITIES.register("head", () -> BlockEntityType.Builder.of(HeadBlockEntity::new,
			getSkulls()).build(null));

	public static Block[] getSkulls() {
		Collection<RegistryObject<Block>> blocks = BLOCKS.getEntries();
		ArrayList<Block> heads = new ArrayList<>();
		for (RegistryObject<Block> registryObject : blocks) {
			if (registryObject.get() instanceof AbstractSkullBlock) {
				heads.add(registryObject.get());
			}
		}
		return heads.toArray(new Block[0]);
	}
}
