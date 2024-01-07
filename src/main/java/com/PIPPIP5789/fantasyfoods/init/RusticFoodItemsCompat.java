package com.PIPPIP5789.fantasyfoods.init;

import minefantasy.mfr.api.stamina.CustomFoodEntry;
import minefantasy.mfr.init.MineFantasyItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import rustic.common.crafting.CrushingTubRecipe;
import rustic.common.crafting.ICrushingTubRecipe;
import rustic.common.crafting.Recipes;
import rustic.common.items.ModItems;
import rustic.common.blocks.fluids.ModFluids;

public class RusticFoodItemsCompat {

    public static void preInitRusticCompat() {
        //CustomFoodEntry.registerItem(new ItemStack(ModItems.TOMATO, 1, 0), 1, 0.2F, 0.0F, 0.2F);
        //CustomFoodEntry.registerItem(new ItemStack(ModItems.CHILI_PEPPER, 1, 0), 1, 0.1F, 0.1F, 0.1F);
        //CustomFoodEntry.registerItem(new ItemStack(ModItems.WILDBERRIES, 1, 0), 1, 0.0F, 0.0F, 0.0F);
        //CustomFoodEntry.registerItem(new ItemStack(ModItems.GRAPES, 1, 0), 1, 0.5F, 0.2F, 0.0F);

        Recipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.WILDBERRY_JUICE, 250), new ItemStack(MineFantasyItems.BERRIES, 1)));
        Recipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.WILDBERRY_JUICE, 500), new ItemStack(MineFantasyItems.BERRIES_JUICY, 1)));
    }

}
