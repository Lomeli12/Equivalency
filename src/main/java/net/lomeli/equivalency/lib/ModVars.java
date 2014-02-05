package net.lomeli.equivalency.lib;

public class ModVars {
    public static final String MOD_ID = "Equivalency";
    public static final String MOD_NAME = MOD_ID;

    public static final int MAJOR = 1, MINOR = 5, REVISION = 6;

    public static final String VERSION = MAJOR + "." + MINOR + "." + REVISION;

    public static final String UPDATE_XML = "https://dl.dropboxusercontent.com/u/17430088/Minecraft%20Mods/Equivalency/updateXML.xml";

    public static final String CORE = "net.lomeli.equivalency.core.";

    public static final String CLIENT = CORE + "ClientProxy";
    public static final String COMMON = CORE + "CommonProxy";

    public static final String EE3_ID = "EE3";
    public static final String AE_ID = "AppliedEnergistics";
    public static final String FORESTRY_ID = "Forestry";
    public static final String IC2_ID = "IC2";
    public static final String MM_ID = "magiks";
    public static final String RC_ID = "Railcraft";
    public static final String TC_ID = "Thaumcraft";
    public static final String TE_ID = "ThermalExpansion";
    public static final String DART_ID = "DartCraft";
    public static final String TINKER_ID = "TConstruct";
    public static final String ARS_ID = "arsmagica2";
    public static final String PRED_ID = "ProjRed|Core";

    public static final String emeraldDesc = "Modifying this will change the emerald recipe. "
            + "True = 8 Gold Ingot <-> 1 Emerald False = 1 Diamond + 3 Cactus Green -> 1 Emerald";
    public static final String blazeDesc = "Enabling this will allow you to craft Diamonds from Blaze rods";
    public static final String cQDesc = "Modifying this will change the Iron to Certus Quartz recipe"
            + "True = 1 Certus Quartz <-> 2 Iron || False = 1 Certus Quartz <-> 2 Iron Blocks";

    public static boolean emeraldTransmute, blazeTransmute, cQTransmute, steelTransmute, quratzRecipe, ic2Recipe, limitRecipes, glowStone;
}
