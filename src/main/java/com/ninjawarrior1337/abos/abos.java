package com.ninjawarrior1337.abos;

import com.ninjawarrior1337.abos.block.CreativeLaser.CreativeLazer;
import com.ninjawarrior1337.abos.block.RedstoneInfusedDirt;
import com.ninjawarrior1337.abos.events.changeplayerdisplayname;
import com.ninjawarrior1337.abos.events.superevent;
import com.ninjawarrior1337.abos.item.*;
import com.ninjawarrior1337.abos.proxy.CommonProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.CompressorManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import vazkii.botania.api.BotaniaAPI;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:appliedenergistics2;required-after:BuildCraft|Silicon")
public class abos {
    public static Item itemObsidianRod;
    public static Item diamondObsidianPickaxe;
    public static Item diamondObsidianSword;
    public static Item diamondObsidianAxe;
    public static Item diamondObsidianShovel;
    public static Item diamondObsidianHoe;
    public static Item obsidianApple;
    public static Item scrod;
    public static Item scPick;
    public static Item scAxe;
    public static Item scSword;
    public static Item scHoe;
    public static Item scShovel;
    public static Item scApple;
    public static Block RedDirt;
    public static Item DirtCell;
    public static Block CreativeLaser;

    public static Block BuildCraftLaser;




    //Tab
    public static final CreativeTabs mo_rod = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return abos.itemObsidianRod;
        }
    };

    //Tool Materials
    public static final Item.ToolMaterial diamondObsidianToolMaterial = EnumHelper.addToolMaterial("diamondObsidianToolMaterial",5, 3122, 25.0F, 6.0F, 20);
    public static final Item.ToolMaterial scMaterial = EnumHelper.addToolMaterial("scMaterial", 3, 1337, 8.7F, 5.0F, 20);

    @Mod.Instance(Reference.MOD_ID)
    public static abos instance;

    @SidedProxy(clientSide = "com.ninjawarrior1337.abos.proxy.ClientProxy", serverSide = "com.ninjawarrior1337.abos.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);

        //Items
        itemObsidianRod = new ItemObsidianRod().setUnlocalizedName("ItemObsidianRod").setMaxStackSize(64).setTextureName(Reference.MOD_ID + ":obsidianstick");
        GameRegistry.registerItem(itemObsidianRod, itemObsidianRod.getUnlocalizedName().substring(5));

        scrod = new scrod().setUnlocalizedName("scrod").setMaxStackSize(64).setTextureName("abos:scrod").setMaxStackSize(64);
        GameRegistry.registerItem(scrod, scrod.getUnlocalizedName().substring(5));

        DirtCell = new DirtCell();
        GameRegistry.registerItem(DirtCell, DirtCell.getUnlocalizedName().substring(5));

        //Tools
        diamondObsidianPickaxe = new ItemObsidianPickaxe(diamondObsidianToolMaterial).setUnlocalizedName("ItemObsidianPickaxe").setTextureName("abos:obPick");
        GameRegistry.registerItem(diamondObsidianPickaxe, diamondObsidianPickaxe.getUnlocalizedName().substring(5));

        diamondObsidianSword = new ItemObsidianSword(diamondObsidianToolMaterial).setUnlocalizedName("ItemObsidianSword").setTextureName("abos:obSword");
        GameRegistry.registerItem(diamondObsidianSword, diamondObsidianSword.getUnlocalizedName().substring(5));

        diamondObsidianAxe = new ItemObsidianAxe(diamondObsidianToolMaterial).setUnlocalizedName("ItemObsidianAxe").setTextureName("abos:obAxe");
        GameRegistry.registerItem(diamondObsidianAxe, diamondObsidianAxe.getUnlocalizedName().substring(5));

        diamondObsidianShovel = new ItemObsidianShovel(diamondObsidianToolMaterial).setUnlocalizedName("ItemObsidianShovel").setTextureName("abos:obShovel");
        GameRegistry.registerItem(diamondObsidianShovel, diamondObsidianShovel.getUnlocalizedName().substring(5));

        diamondObsidianHoe = new ItemObsidianHoe(diamondObsidianToolMaterial).setUnlocalizedName("ItemObsidianHoe").setTextureName("abos:obHoe");
        GameRegistry.registerItem(diamondObsidianHoe, diamondObsidianHoe.getUnlocalizedName().substring(5));

       scPick = new scPick(scMaterial).setUnlocalizedName("scPick").setTextureName("abos:scPick");
        GameRegistry.registerItem(scPick, scPick.getUnlocalizedName().substring(5));

        scSword = new scSword(scMaterial).setUnlocalizedName("scSword").setTextureName("abos:scSword");
        GameRegistry.registerItem(scSword, scSword.getUnlocalizedName().substring(5));

        scAxe = new scAxe(scMaterial).setUnlocalizedName("scAxe").setTextureName("abos:scAxe");
        GameRegistry.registerItem(scAxe, scAxe.getUnlocalizedName().substring(5));

        scShovel = new scShovel(scMaterial).setUnlocalizedName("scShovel").setTextureName("abos:scShovel");
        GameRegistry.registerItem(scShovel, scShovel.getUnlocalizedName().substring(5));

        scHoe = new scHoe(scMaterial).setUnlocalizedName("scHoe").setTextureName("abos:scHoe");
        GameRegistry.registerItem(scHoe, scHoe.getUnlocalizedName().substring(5));

        //Blocks
        RedDirt = new RedstoneInfusedDirt(Material.rock).setBlockName("RedstoneInfusedDirt").setBlockTextureName("abos:RedstoneInfusedDirt");
        GameRegistry.registerBlock(RedDirt, RedDirt.getUnlocalizedName().substring(5));

        CreativeLaser = new CreativeLazer().setBlockName("creative_laser");
        GameRegistry.registerBlock(CreativeLaser, CreativeLaser.getUnlocalizedName().substring(5));

        //Food
        obsidianApple = new ItemObsidianApple(20, 2.0F, true).setUnlocalizedName("ItemObsidianApple").setTextureName("abos:obApple");
        GameRegistry.registerItem(obsidianApple, obsidianApple.getUnlocalizedName().substring(5));

        scApple = new scApple (6, 0.5F, true).setUnlocalizedName("scApple").setTextureName("abos:scApple");
        GameRegistry.registerItem(scApple, scApple.getUnlocalizedName().substring(5));

        FMLInterModComms.sendMessage("Waila", "register", "com.ninjawarrior1337.abos.thirdparty.Waila.onWailaCall");

        System.out.println("Checking If Thuamcraft is installed");
        if(Loader.isModLoaded("Thaumcraft"))
        {
            System.out.println("Thaumcraft has been detected");
            loadThaumcraft();
        }

        System.out.println("Checking If Botania is installed");
        if(Loader.isModLoaded("Botania"))
        {
            System.out.println("Botania has been detected");
            loadBotania();
        }

    }

    @Optional.Method(modid = "Thaumcraft")
    private void loadThaumcraft()
    {
        ThaumcraftApi.registerObjectTag(new ItemStack(DirtCell), new AspectList().add(Aspect.MECHANISM, 10).add(Aspect.EARTH, 1).add(Aspect.VOID, 64));
        InfusionRecipe dirtCellRecipe = ThaumcraftApi.addInfusionCraftingRecipe("", new ItemStack(DirtCell), 0,new AspectList().add(Aspect.MECHANISM, 1).add(Aspect.EARTH, 1).add(Aspect.VOID, 16), new ItemStack(Items.nether_star), new ItemStack[]{new ItemStack(RedDirt), new ItemStack(RedDirt), new ItemStack(RedDirt), new ItemStack(RedDirt)});
    }

    @Optional.Method(modid = "Botania")
    private void loadBotania()
    {
        BotaniaAPI.registerPureDaisyRecipe(Blocks.dirt, abos.RedDirt, 0);
        BotaniaAPI.registerPetalRecipe(new ItemStack(abos.DirtCell), new Object[]{new ItemStack(abos.RedDirt), new ItemStack(abos.RedDirt), new ItemStack(abos.RedDirt), new ItemStack(abos.RedDirt), new ItemStack(Items.nether_star)});
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent e)
    {
        proxy.init(e);

        //Events
        MinecraftForge.EVENT_BUS.register(new changeplayerdisplayname());
        MinecraftForge.EVENT_BUS.register(new superevent());

        //Recipes
        GameRegistry.addRecipe(new ItemStack(itemObsidianRod, 4), new Object[]{"   ", "O  ", "O  ", 'O', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(itemObsidianRod, 4), new Object[]{"   ", " O ", " O ", 'O', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianPickaxe, 1), new Object[]{"DDD"," O "," O ", 'D', Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianSword, 1), new Object[]{" D "," D "," O ", 'D',Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianSword, 1), new Object[]{"D  ","D  ","O  ", 'D',Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianAxe, 1), new Object[]{"DD ","DO "," O ", 'O',abos.itemObsidianRod, 'D',Items.diamond});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianAxe, 1), new Object[]{" DD"," OD"," O ", 'O',abos.itemObsidianRod, 'D',Items.diamond});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianShovel, 1),new Object[]{"D  ","O  ","O  ", 'D',Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianShovel, 1),new Object[]{" D "," O "," O ", 'D',Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(diamondObsidianHoe, 1),new Object[]{"DD "," O "," O ", 'D',Items.diamond, 'O',abos.itemObsidianRod});
        GameRegistry.addRecipe(new ItemStack(obsidianApple, 1), new Object[]{"OOO","OAO","OOO", 'O',abos.itemObsidianRod, 'A', Items.golden_apple});
        GameRegistry.addRecipe(new ItemStack(scrod, 4), new Object[]{"XXX","   ","   ", 'X',Items.reeds});
        GameRegistry.addRecipe(new ItemStack(scrod, 4), new Object[]{"   ","XXX","   ", 'X',Items.reeds});
        GameRegistry.addRecipe(new ItemStack(scPick, 1), new Object[]{"DDD"," O "," O ", 'D', Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scSword, 1), new Object[]{" D "," D "," O ", 'D',Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scSword, 1), new Object[]{"D  ","D  ","O  ", 'D',Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scAxe, 1), new Object[]{"DD ","DO "," O ", 'O',abos.scrod, 'D',Items.diamond});
        GameRegistry.addRecipe(new ItemStack(scAxe, 1), new Object[]{" DD"," OD"," O ", 'O',abos.scrod, 'D',Items.diamond});
        GameRegistry.addRecipe(new ItemStack(scShovel, 1),new Object[]{"D  ","O  ","O  ", 'D',Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scShovel, 1),new Object[]{" D "," O "," O ", 'D',Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scHoe, 1),new Object[]{"DD "," O "," O ", 'D',Items.diamond, 'O',abos.scrod});
        GameRegistry.addRecipe(new ItemStack(scApple, 1), new Object[]{"OOO","OAO","OOO", 'O',abos.scrod, 'A', Items.golden_apple});
        GameRegistry.addShapelessRecipe(new ItemStack(RedDirt, 1), new Object[]{new ItemStack(Items.redstone), new ItemStack(Blocks.dirt)});

        CompressorManager.addRecipe(new ItemStack(CreativeLaser, 1, 0), 320, new ItemStack(RedDirt));

        OreDictionary.registerOre("itemNetherStar", Items.nether_star);
        OreDictionary.registerOre("itemNetherStar", DirtCell);
        OreDictionary.registerOre("blockRedDirt", RedDirt);

        //API's
        FMLInterModComms.sendMessage("cfm","register","com.ninjawarrior1337.abos.RegisterRecipes.register");
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}


