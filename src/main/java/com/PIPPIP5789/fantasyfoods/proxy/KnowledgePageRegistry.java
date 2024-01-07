package com.PIPPIP5789.fantasyfoods.proxy;

import com.PIPPIP5789.fantasyfoods.LoadedAddons;
import com.PIPPIP5789.fantasyfoods.init.ItemRegistry;
import com.PIPPIP5789.fantasyfoods.init.ResearchInit;
import minefantasy.mfr.client.knowledge.EntryPageRecipeCarpenter;
import minefantasy.mfr.client.knowledge.EntryPageText;
import minefantasy.mfr.constants.Skill;
import minefantasy.mfr.recipe.CarpenterCraftMatrix;
import minefantasy.mfr.recipe.CarpenterRecipeLoader;
import minefantasy.mfr.recipe.CraftingManagerCarpenter;
import minefantasy.mfr.recipe.ICarpenterRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KnowledgePageRegistry {
    public static void initPages() {
        //MineFantasyKnowledgeList.ores.addPages(new EntryPageText("knowledge.ores.3"));
        //MineFantasyKnowledgeList.ores.addPages(new EntryPage[] {new EntryPageImage("LeadOre.png", 96, 96, "knowledge.ores.lead"), new EntryPageSmelting(new ItemStack(RegistryManager.ore_lead), new ItemStack(RegistryManager.ingot_lead))});
        //MineFantasyKnowledgeList.ores.addPages(new EntryPageImage("textures/gui/knowledge/image/" + "QuartzOre" + ".png", 96, 96, "knowledge.ores.quartz"));

        ResearchInit.jams.addPages(new EntryPageText("knowledge.jams.page.1"));
        ResearchInit.jams.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_apple")));
        ResearchInit.jams.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_berry")));

        ResearchInit.jamrolls.addPages(new EntryPageText("knowledge.jamrolls.page.1"));
        ResearchInit.jamrolls.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_apple_roll")));
        ResearchInit.jamrolls.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_berry_roll")));

        ResearchInit.pottage.addPages(new EntryPageText("knowledge.pottage.page.1"));
        ResearchInit.pottage.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("pottage")));

        ResearchInit.slicing.addPages(new EntryPageText("knowledge.slicing.page.1"));
        ResearchInit.slicing.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("slices_carrot")));
        ResearchInit.slicing.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("slices_potato")));

        if(LoadedAddons.rustic) {
            ResearchInit.jams.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_grape")));

            ResearchInit.jamrolls.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("jam_grape_roll")));

            ResearchInit.salad.addPages(new EntryPageText("knowledge.salad.page.1"));
            ResearchInit.salad.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("salad")));

            ResearchInit.sandwitch_veggie.addPages(new EntryPageText("knowledge.veggie_sandwitch.page.1"));
            ResearchInit.sandwitch_veggie.addPages(new EntryPageRecipeCarpenter(CraftingManagerCarpenter.getRecipeByName("sandwitch_veggie")));
        }
        //golems.addPages(new EntryPageImage("textures/gui/knowledge/images/" + "AncientGolem" + ".png", 96, 96, "knowledge.golems.1"));
    }
}