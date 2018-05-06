package cscot.basicnetherores.util.handler;

import cscot.basicnetherores.BasicNetherOres;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static boolean pigmanGuard;
    public static boolean regeisterIngots;

    public static int protectionRange = 16;

    //TODO add public static boolean for seperate areas

    public static void init(File file) {

        config = new Configuration(file);

        String category;

        category = "Ore Protector";
        config.addCustomCategoryComment(category, "Pigman Projection Settings");
        pigmanGuard = config.getBoolean("Enable Pigmen Aggro when Ores are harvested", category, true, "If set to 'true' Pigmen will protect Nether Ores");
        protectionRange = config.getInt("Projection Range", category, 16, 1, 64,"Set range that Pigmen will aggro when mining ores");


        category = "Nuggets, Ingots, & Blocks";
        config.addCustomCategoryComment(category, "Register Ingot and Blocks");
        regeisterIngots = config.getBoolean("Register Copper and Tin Items", category, true, "Set to false to turn off registering of Metals");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event) {

        BasicNetherOres.config = new File(event.getModConfigurationDirectory() + "/BasicNetherOres");
        BasicNetherOres.config.mkdirs();
        init(new File(BasicNetherOres.config.getPath(), "BasicNetherOres.cfg"));
    }

}
