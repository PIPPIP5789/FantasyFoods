package com.PIPPIP5789.fantasyfoods.init;

import com.PIPPIP5789.fantasyfoods.LoadedAddons;
import com.PIPPIP5789.fantasyfoods.proxy.KnowledgePageRegistry;
import minefantasy.mfr.constants.Skill;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.init.MineFantasyKnowledgeList;
import minefantasy.mfr.mechanics.knowledge.InformationBase;
import minefantasy.mfr.mechanics.knowledge.InformationList;
import minefantasy.mfr.mechanics.knowledge.InformationPage;
import minefantasy.mfr.mechanics.knowledge.ResearchArtefacts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.world.ChunkEvent;
import rustic.common.items.ModItems;

import javax.sound.sampled.Line;

public class ResearchInit {

    public static InformationBase jams;
    public static InformationBase jamrolls;
    public static InformationBase pottage;
    public static InformationBase salad;
    public static InformationBase sandwitch_veggie;
    public static InformationBase slicing;
    //public static InformationBase golems;

    public static void initResearch() {
        jams = (new InformationBase("jams", -2, 1, 1, ItemRegistry.appleJam, null)).registerStat().setPage(InformationList.provisioning).addSkill(Skill.PROVISIONING, 5);
        jamrolls = (new InformationBase("jamrolls", -3, 2, 1, ItemRegistry.appleJamRoll, jams)).registerStat().setPage(InformationList.provisioning).addSkill(Skill.PROVISIONING, 20);
        pottage = (new InformationBase("pottage", 2, -3, 4, ItemRegistry.pottage, MineFantasyKnowledgeList.stew)).registerStat().setPage(InformationList.provisioning).addSkill(Skill.PROVISIONING, 50);
        slicing = (new InformationBase("slicing", -2, -1, 0, ItemRegistry.carrotSlices, null)).registerStat().setPage(InformationList.provisioning).setUnlocked();
        //golems = (new InformationBase("golems", 0, 4, 0, RegistryManager.ancient_motive_core, null)).registerStat().setUnlocked();
        //tinkerHammer = (new InformationBase("tinker_hammer", 10, 0, 1, RegistryManager.tinker_hammer, composite_alloy)).registerStat().setPage(engineering).addSkill(Skill.ENGINEERING, 50).addSkill(Skill.ARTISANRY, 30);
        if(LoadedAddons.rustic) {
            salad = (new InformationBase("salad", 5, 0, 2, ItemRegistry.salad, MineFantasyKnowledgeList.oats)).registerStat().setPage(InformationList.provisioning).addSkill(Skill.PROVISIONING, 20);
            sandwitch_veggie = (new InformationBase("veggie_sandwitch", 1, -9, 2, ItemRegistry.veggieSandwitch, MineFantasyKnowledgeList.sandwitch)).registerStat().setPage(InformationList.provisioning).addSkill(Skill.PROVISIONING, 40);
        }
        initArtefacts();
        KnowledgePageRegistry.initPages();
    }

    private static void initArtefacts() {
        ResearchArtefacts.addArtefact(MineFantasyItems.BERRIES, jams);
        ResearchArtefacts.addArtefact(Items.APPLE, jams);

        ResearchArtefacts.addArtefact(ItemRegistry.appleJam, jamrolls);
        ResearchArtefacts.addArtefact(ItemRegistry.berryJam, jamrolls);

        if(LoadedAddons.rustic) {
            ResearchArtefacts.addArtefact(ModItems.GRAPES, jams);
            ResearchArtefacts.addArtefact(ItemRegistry.grapeJam, jamrolls);

            ResearchArtefacts.addArtefact(Blocks.LEAVES, salad);
            ResearchArtefacts.addArtefact(ModItems.TOMATO, salad);

            ResearchArtefacts.addArtefact(MineFantasyItems.BREAD_SLICE, sandwitch_veggie);
            ResearchArtefacts.addArtefact(ModItems.TOMATO, sandwitch_veggie);
        }

        ResearchArtefacts.addArtefact(MineFantasyItems.GENERIC_MEAT_UNCOOKED, pottage);
        ResearchArtefacts.addArtefact(Items.MILK_BUCKET, pottage);
        ResearchArtefacts.addArtefact(Items.CARROT, pottage);
        ResearchArtefacts.addArtefact(Items.POTATO, pottage);
    }
}