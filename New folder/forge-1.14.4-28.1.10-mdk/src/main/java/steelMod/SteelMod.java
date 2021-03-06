package steelMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import steelMod.lists.ArmorMaterialList;
import steelMod.lists.BlockList;
import steelMod.lists.ItemList;
import steelMod.lists.ToolMaterialList;

@Mod("ncwdsteelmod")
public class SteelMod 
{
	public static SteelMod instance;
	public static final String modid = "ncwdsteelmod";
	private static final Logger logger = LogManager.getLogger(modid);
	

	
	public SteelMod() 
	{
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered.");
	}
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientregistries method registered");
	}
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(	//!!!!!!Change cooldown speed!!!!!!
					ItemList.steel_ingot = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("steel_ingot")),
					ItemList.steel_axe = new AxeItem(ToolMaterialList.steelMod, +1.0f, .01f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("steel_axe")),
					ItemList.steel_hoe = new HoeItem(ToolMaterialList.steelMod, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("steel_hoe")),	
					ItemList.steel_pickaxe = new PickaxeItem(ToolMaterialList.steelMod, (int) -1.0f, 0.0000005f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("steel_pickaxe")),
					ItemList.steel_shovel = new ShovelItem(ToolMaterialList.steelMod, -1.5f, 0.06f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("steel_shovel")),
					ItemList.steel_sword = new SwordItem(ToolMaterialList.steelMod, 0, .002f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("steel_sword")),
					ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.steel_block.getRegistryName()),
					ItemList.steel_helmet = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("steel_helmet")),
					ItemList.steel_leggings = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("steel_leggings")),
					ItemList.steel_chestplate = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("steel_chestplate")),
					ItemList.steel_boots = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("steel_boots"))
			);
			
			logger.info("Items registered.");
		}
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					BlockList.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 30.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("steel_block"))
			);
			
			logger.info("Items registered.");
		}
	}
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(modid, name);
	}
}
