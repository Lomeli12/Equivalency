package net.lomeli.equivalency.core.handler;

import java.util.EnumSet;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.lib.ModVars;

import net.lomeli.lomlib.util.ToolTipUtil;
import net.lomeli.lomlib.util.XMLUtil;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionTickHandler implements ITickHandler {

    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if(!Equivalency.updater.isUpdate()) {
            if(!initialized) {
                for(TickType tickType : type) {
                    if(tickType == TickType.CLIENT) {
                        if(FMLClientHandler.instance().getClient().currentScreen == null) {
                            initialized = true;
                            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                                    ToolTipUtil.BLUE + "[" + ToolTipUtil.ORANGE + ModVars.MOD_NAME + ToolTipUtil.BLUE
                                            + "]: There is a new version available at " + Equivalency.updater.getDownloadURL());
                            for(int i = 1; i <= 3; i++){
                                FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                                        ToolTipUtil.BLUE + "[" + ToolTipUtil.ORANGE + ModVars.MOD_NAME + ToolTipUtil.BLUE
                                                + "]: * " +  XMLUtil.getShort(ModVars.UPDATE_XML, ("updateInfo" + i)));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {
        return ModVars.MOD_NAME + ": " + this.getClass().getSimpleName();
    }

}
