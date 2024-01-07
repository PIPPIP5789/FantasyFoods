package com.PIPPIP5789.fantasyfoods;

import com.PIPPIP5789.fantasyfoods.init.ItemRegistry;
import com.PIPPIP5789.fantasyfoods.init.ResearchInit;
import com.PIPPIP5789.fantasyfoods.init.RusticFoodItemsCompat;
import com.PIPPIP5789.fantasyfoods.proxy.CommonProxy;
import com.PIPPIP5789.fantasyfoods.proxy.KnowledgePageRegistry;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.recipe.CarpenterRecipeLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rustic.core.Rustic;

@Mod(modid = FantasyFoods.MODID, name = FantasyFoods.NAME, version = FantasyFoods.VERSION, dependencies = "after:" + MineFantasyReforged.MOD_ID + ";after:" + Rustic.MODID)
public class FantasyFoods {
    public static final String MODID = "fantasyfoods";
    public static final String NAME = "Fantasy Foods";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "com.PIPPIP5789.fantasyfoods.proxy.ClientProxy", serverSide = "com.PIPPIP5789.fantasyfoods.proxy.CommonProxy")
    public static CommonProxy PROXY;
    public ItemRegistry itemRegistry;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Initializing Compatabilities");
        if (Loader.isModLoaded("rustic")) {
            LoadedAddons.rustic = true;
        }

        System.out.println("Initializing Items");
        if(LoadedAddons.rustic) {
            RusticFoodItemsCompat.preInitRusticCompat();
        }
        ItemRegistry.initMFRItems();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        CarpenterRecipeLoader.INSTANCE.loadRegistry("carpenter", "assets/fantasyfoods/carpenter_recipes", "config/MineFantasyReforged/custom/recipes/carpenter_recipes/");
        if(LoadedAddons.rustic) {
            CarpenterRecipeLoader.INSTANCE.loadRegistry("carpenter", "assets/fantasyfoods/compat/rustic/carpenter_recipes", "config/MineFantasyReforged/custom/recipes/carpenter_recipes/");
        }
        ResearchInit.initResearch();
    }
}